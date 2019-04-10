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

import com.singlemusic.shortener.entity.ShortLink;
import com.singlemusic.shortener.entity.enums.ShortLinkState;
import com.singlemusic.shortener.service.SlugGenerator;
import com.singlemusic.shortener.service.SlugValidator;
import com.singlemusic.shortener.util.SystemTimeFacade;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class ShortLinkAdapter implements ApiAdapter<com.singlemusic.shortener.controller.api.ShortLink, ShortLink> {
    @Resource
    private SystemTimeFacade systemTimeFacade;
    @Resource
    private SlugValidator slugValidator;
    @Resource
    private SlugGenerator slugGenerator;

    @Override
    public com.singlemusic.shortener.controller.api.ShortLink toApi(ShortLink entity) {
        if (null == entity) {
            return null;
        }
        final com.singlemusic.shortener.controller.api.ShortLink shortLink = new com.singlemusic.shortener.controller.api.ShortLink();
        shortLink.setId(entity.getId());
        shortLink.setLink(entity.getLink());
        shortLink.setSlug(entity.getSlug());
        shortLink.setTitle(entity.getTitle());
        shortLink.setCreatedAt(entity.getCreatedAt());
        shortLink.setState(entity.getState());
        return shortLink;
    }

    @Override
    public ShortLink toEntity(com.singlemusic.shortener.controller.api.ShortLink api) {
        if (null == api) {
            return null;
        }
        final ShortLink shortLink = new ShortLink();
        shortLink.setId(api.getId());
        shortLink.setLink(api.getLink());
        shortLink.setSlug(getSlug(api));
        shortLink.setTitle(api.getTitle());
        shortLink.setCreatedAt(null == api.getId() ? systemTimeFacade.now() : api.getCreatedAt());
        shortLink.setState(null == api.getId() ? ShortLinkState.ACTIVE : api.getState());
        return shortLink;
    }

    private String getSlug(com.singlemusic.shortener.controller.api.ShortLink api) {
        if (StringUtils.isNotBlank(api.getSlug())) {
            return slugValidator.validate(api.getSlug());
        }
        return slugGenerator.generate(api.getLink());
    }
}
