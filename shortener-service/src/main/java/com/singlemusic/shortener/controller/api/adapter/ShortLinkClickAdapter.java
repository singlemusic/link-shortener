package com.singlemusic.shortener.controller.api.adapter;

import com.singlemusic.shortener.controller.api.ShortLinkClick;
import com.singlemusic.shortener.controller.api.ShortLinkClickBuilder;
import org.springframework.stereotype.Component;

@Component
public class ShortLinkClickAdapter implements ApiAdapter<ShortLinkClick, com.singlemusic.shortener.entity.ShortLinkClick> {
    @Override
    public ShortLinkClick toApi(com.singlemusic.shortener.entity.ShortLinkClick entity) {
        return null == entity ? null : ShortLinkClickBuilder.aShortLinkClick()
                .id(entity.getId())
                .shortLinkId(entity.getShortLinkId())
                .link(entity.getLink())
                .ipAddress(entity.getIpAddress())
                .referrer(entity.getReferrer())
                .userAgent(entity.getUserAgent())
                .createdAt(entity.getCreatedAt())
                .build();
    }

    @Override
    public com.singlemusic.shortener.entity.ShortLinkClick toEntity(ShortLinkClick api) {
        throw new UnsupportedOperationException("method not implemented");
    }
}
