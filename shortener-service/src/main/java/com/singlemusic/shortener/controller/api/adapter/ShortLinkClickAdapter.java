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
