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
package com.singlemusic.shortener.controller;

import com.singlemusic.shortener.controller.api.ShortLink;
import com.singlemusic.shortener.controller.api.ShortLinkClick;
import com.singlemusic.shortener.controller.api.ShortLinkClickCount;
import com.singlemusic.shortener.controller.api.adapter.ApiAdapter;
import com.singlemusic.shortener.service.ShortLinkClickService;
import com.singlemusic.shortener.service.ShortLinkService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Collections;

@RestController
@RequestMapping("/short-link")
public class ShortLinkController {
    @Resource
    private ShortLinkService shortLinkService;
    @Resource
    private ShortLinkClickService shortLinkClickService;
    @Resource
    private ApiAdapter<ShortLink, com.singlemusic.shortener.entity.ShortLink> shortLinkAdapter;
    @Resource
    private ApiAdapter<ShortLinkClick, com.singlemusic.shortener.entity.ShortLinkClick> shortLinkClickAdapter;

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ShortLink archive(final @PathVariable("id") String id) {
        return shortLinkAdapter.toApi(shortLinkService.archive(id));
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    public ShortLinkClickCount count(final @RequestParam(value = "id", required = false) String id,
                                     final @RequestParam(value = "slug", required = false) String slug) {
        if (StringUtils.isNotBlank(id)) {
            return shortLinkClickService.countByShortLinkId(id);
        }
        if (StringUtils.isNotBlank(slug)) {
            return shortLinkClickService.countBySlug(slug);
        }
        return new ShortLinkClickCount(0);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ShortLink create(final @RequestBody ShortLink shortLink) {
        return shortLinkAdapter.toApi(shortLinkService.create(shortLinkAdapter.toEntity(shortLink)));
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Page<ShortLink> find(final @RequestParam(value = "slug", required = false) String slug,
                                final @RequestParam(value = "query", required = false) String query,
                                final Pageable pageable) {
        if (StringUtils.isNotBlank(slug)) {
            final ShortLink shortLink = shortLinkAdapter.toApi(shortLinkService.getBySlug(slug));
            return new PageImpl<>(Collections.singletonList(shortLink), pageable, 1L);
        }
        if (StringUtils.isNotBlank(query)) {
            return shortLinkService.find(query, pageable)
                    .map(shortLinkAdapter::toApi);
        }
        return shortLinkService.findAll(pageable)
                .map(shortLinkAdapter::toApi);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ShortLink get(final @PathVariable("id") String id) {
        return shortLinkAdapter.toApi(shortLinkService.getById(id));
    }

    @RequestMapping(value = "/click", method = RequestMethod.GET)
    public Page<ShortLinkClick> getClicks(final @RequestParam(value = "id", required = false) String id,
                                          final @RequestParam(value = "slug", required = false) String slug,
                                          final Pageable pageable) {
        if (StringUtils.isNotBlank(id)) {
            return shortLinkClickService.findByShortLinkId(id, pageable)
                    .map(shortLinkClickAdapter::toApi);
        }
        if (StringUtils.isNotBlank(slug)) {
            return shortLinkClickService.findBySlug(slug, pageable)
                    .map(shortLinkClickAdapter::toApi);
        }
        return Page.empty();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ShortLink update(final @PathVariable("id") String id,
                            final @RequestBody ShortLink shortLink) {
        return shortLinkAdapter.toApi(shortLinkService.update(shortLinkAdapter.toEntity(shortLink)));
    }

    @RequestMapping(value = "/validate", method = RequestMethod.POST)
    public ShortLink validate(final @RequestBody @Validated ShortLink shortLink) {
        shortLinkService.validate(shortLinkAdapter.toEntity(shortLink));
        return shortLink;
    }
}
