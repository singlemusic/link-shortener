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

import java.io.Serializable;

public class ShortLinkClick implements Serializable {
    private static final long serialVersionUID = -7140001805827360399L;
    private String id;
    private String shortLinkId;
    private String link;
    private String ipAddress;
    private String userAgent;
    private String referrer;
    private DateTime createdAt;


    public DateTime getCreatedAt() {
        return createdAt;
    }

    public String getId() {
        return id;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public String getLink() {
        return link;
    }

    public String getReferrer() {
        return referrer;
    }

    public String getShortLinkId() {
        return shortLinkId;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setCreatedAt(DateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setReferrer(String referrer) {
        this.referrer = referrer;
    }

    public void setShortLinkId(String shortLinkId) {
        this.shortLinkId = shortLinkId;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }
}
