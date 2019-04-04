package com.singlemusic.shortener.controller.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class ShortLinkClickCount implements Serializable {
    private static final long serialVersionUID = -4800362480250540607L;
    @JsonProperty("clicks")
    private final int clicks;

    @JsonCreator
    public ShortLinkClickCount(final @JsonProperty("clicks") int clicks) {
        this.clicks = clicks;
    }

    public int getClicks() {
        return clicks;
    }
}
