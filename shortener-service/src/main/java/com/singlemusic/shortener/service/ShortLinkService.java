package com.singlemusic.shortener.service;

import com.singlemusic.shortener.entity.ShortLink;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ShortLinkService {
    ShortLink archive(String id);

    ShortLink create(ShortLink shortLink);

    Page<ShortLink> find(String query, Pageable pageable);

    Page<ShortLink> findAll(Pageable pageable);

    ShortLink getById(String id);

    ShortLink getBySlug(String slug);

    ShortLink update(ShortLink shortLink);
}
