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
