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
