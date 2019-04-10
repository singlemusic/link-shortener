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

import com.singlemusic.shortener.entity.ShortLink;
import com.singlemusic.shortener.entity.enums.ShortLinkState;
import com.singlemusic.shortener.exception.ShortLinkNotFoundException;
import com.singlemusic.shortener.repository.ShortLinkRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ShortLinkServiceImpl implements ShortLinkService {
    @Resource
    private ShortLinkRepository shortLinkRepository;

    @Override
    public ShortLink archive(final String id) {
        final ShortLink loaded = shortLinkRepository.findById(id)
                .orElseThrow(() -> new ShortLinkNotFoundException(id));
        loaded.setState(ShortLinkState.ARCHIVED);
        return shortLinkRepository.save(loaded);
    }

    @Override
    public ShortLink create(final ShortLink shortLink) {
        return shortLinkRepository.save(shortLink);
    }

    @Override
    public Page<ShortLink> find(String query, Pageable pageable) {
        return shortLinkRepository.findByQuery(query, pageable);
    }

    @Override
    public Page<ShortLink> findAll(Pageable pageable) {
        return shortLinkRepository.findAll(pageable);
    }

    @Override
    public ShortLink getById(String id) {
        return shortLinkRepository.findById(id)
                .orElseThrow(() -> new ShortLinkNotFoundException(id));
    }

    @Override
    public ShortLink getBySlug(final String slug) {
        return shortLinkRepository.findOneBySlug(slug);
    }

    @Override
    public ShortLink update(final ShortLink shortLink) {
        final ShortLink loaded = shortLinkRepository.findById(shortLink.getId())
                .orElseThrow(() -> new ShortLinkNotFoundException(shortLink.getId()));
        loaded.setLink(shortLink.getLink());
        loaded.setSlug(shortLink.getSlug());
        loaded.setTitle(shortLink.getTitle());
        return shortLinkRepository.save(loaded);
    }
}
