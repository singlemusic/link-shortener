/*
    link-shortener
    Copyright (C) 2019  Single LLC

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package com.singlemusic.shortener.service;

import com.singlemusic.shortener.controller.api.ShortLinkClickCount;
import com.singlemusic.shortener.entity.ShortLink;
import com.singlemusic.shortener.entity.ShortLinkClick;
import com.singlemusic.shortener.exception.ShortLinkNotFoundException;
import com.singlemusic.shortener.repository.ShortLinkClickRepository;
import com.singlemusic.shortener.repository.ShortLinkRepository;
import com.singlemusic.shortener.util.SystemTimeFacade;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Service
public class ShortLinkClickServiceImpl implements ShortLinkClickService {
    @Resource
    private ShortLinkClickRepository shortLinkClickRepository;
    @Resource
    private ShortLinkRepository shortLinkRepository;
    @Resource
    private IpAddressParser ipAddressParser;
    @Resource
    private SystemTimeFacade systemTimeFacade;

    @Override
    public ShortLinkClickCount countByShortLinkId(String shortLinkId) {
        final int count = shortLinkClickRepository.countByShortLinkId(shortLinkId);
        return new ShortLinkClickCount(count);
    }

    @Override
    public ShortLinkClickCount countBySlug(String slug) {
        final ShortLink shortLink = shortLinkRepository.findOneBySlug(slug);
        if (null == shortLink) {
            throw new ShortLinkNotFoundException(slug);
        }
        final int count = shortLinkClickRepository.countByShortLinkId(shortLink.getId());
        return new ShortLinkClickCount(count);
    }

    @Override
    public Page<ShortLinkClick> findByShortLinkId(String shortLinkId, Pageable pageable) {
        return shortLinkClickRepository.findByShortLinkIdOrderByCreatedAtDesc(shortLinkId, pageable);
    }

    @Override
    public Page<ShortLinkClick> findBySlug(String slug, Pageable pageable) {
        final ShortLink shortLink = shortLinkRepository.findOneBySlug(slug);
        if (null == shortLink) {
            throw new ShortLinkNotFoundException(slug);
        }
        return shortLinkClickRepository.findByShortLinkIdOrderByCreatedAtDesc(shortLink.getId(), pageable);
    }

    @Override
    public ShortLinkClick trackClick(HttpServletRequest request, ShortLink shortLink) {
        final ShortLinkClick click = new ShortLinkClick();
        click.setShortLinkId(shortLink.getId());
        click.setCreatedAt(systemTimeFacade.now());
        click.setLink(shortLink.getLink());
        click.setIpAddress(ipAddressParser.parse(request.getHeader("X-Forwarded-For")));
        click.setReferrer(StringUtils.truncate(request.getHeader("Referer"), 512));
        click.setUserAgent(request.getHeader("User-Agent"));
        return shortLinkClickRepository.save(click);
    }
}
