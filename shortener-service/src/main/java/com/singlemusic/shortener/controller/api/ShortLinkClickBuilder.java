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
