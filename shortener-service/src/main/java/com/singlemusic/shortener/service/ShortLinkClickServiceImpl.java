package com.singlemusic.shortener.service;

import com.singlemusic.shortener.controller.api.ShortLinkClickCount;
import com.singlemusic.shortener.entity.ShortLink;
import com.singlemusic.shortener.entity.ShortLinkClick;
import com.singlemusic.shortener.exception.ShortLinkNotFoundException;
import com.singlemusic.shortener.repository.ShortLinkClickRepository;
import com.singlemusic.shortener.repository.ShortLinkRepository;
import com.singlemusic.shortener.util.SystemTimeFacade;
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
        click.setReferrer(request.getHeader("Referer"));
        click.setUserAgent(request.getHeader("User-Agent"));
        return shortLinkClickRepository.save(click);
    }
}
