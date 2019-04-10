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
package com.singlemusic.shortener.controller.api;

import org.joda.time.DateTime;

public final class ShortLinkClickBuilder {
    private String id;
    private String shortLinkId;
    private String link;
    private String ipAddress;
    private String userAgent;
    private String referrer;
    private DateTime createdAt;

    private ShortLinkClickBuilder() {
    }

    public static ShortLinkClickBuilder aShortLinkClick() {
        return new ShortLinkClickBuilder();
    }

    public ShortLinkClick build() {
        ShortLinkClick shortLinkClick = new ShortLinkClick();
        shortLinkClick.setId(id);
        shortLinkClick.setShortLinkId(shortLinkId);
        shortLinkClick.setLink(link);
        shortLinkClick.setIpAddress(ipAddress);
        shortLinkClick.setUserAgent(userAgent);
        shortLinkClick.setReferrer(referrer);
        shortLinkClick.setCreatedAt(createdAt);
        return shortLinkClick;
    }

    public ShortLinkClickBuilder createdAt(DateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public ShortLinkClickBuilder id(String id) {
        this.id = id;
        return this;
    }

    public ShortLinkClickBuilder ipAddress(String ipAddress) {
        this.ipAddress = ipAddress;
        return this;
    }

    public ShortLinkClickBuilder link(String link) {
        this.link = link;
        return this;
    }

    public ShortLinkClickBuilder referrer(String referrer) {
        this.referrer = referrer;
        return this;
    }

    public ShortLinkClickBuilder shortLinkId(String shortLinkId) {
        this.shortLinkId = shortLinkId;
        return this;
    }

    public ShortLinkClickBuilder userAgent(String userAgent) {
        this.userAgent = userAgent;
        return this;
    }
}
