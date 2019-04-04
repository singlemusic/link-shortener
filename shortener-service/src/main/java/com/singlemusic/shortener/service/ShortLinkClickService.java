package com.singlemusic.shortener.service;

import com.singlemusic.shortener.controller.api.ShortLinkClickCount;
import com.singlemusic.shortener.entity.ShortLink;
import com.singlemusic.shortener.entity.ShortLinkClick;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.servlet.http.HttpServletRequest;

public interface ShortLinkClickService {
    ShortLinkClickCount countByShortLinkId(String shortLinkId);

    ShortLinkClickCount countBySlug(String slug);

    Page<ShortLinkClick> findByShortLinkId(String shortLinkId, Pageable pageable);

    Page<ShortLinkClick> findBySlug(String slug, Pageable pageable);

    ShortLinkClick trackClick(HttpServletRequest request, ShortLink shortLink);
}
