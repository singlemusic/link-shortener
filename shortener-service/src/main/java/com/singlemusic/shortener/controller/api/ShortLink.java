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

import com.singlemusic.shortener.entity.enums.ShortLinkState;
import org.hibernate.validator.constraints.URL;
import org.joda.time.DateTime;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

public class ShortLink implements Serializable {
    private static final long serialVersionUID = 5471500890475097978L;
    private String id;
    private String slug;
    private String title;
    @NotBlank
    @URL
    private String link;
    private DateTime createdAt;
    private ShortLinkState state;

    public DateTime getCreatedAt() {
        return createdAt;
    }

    public String getId() {
        return id;
    }

    public String getLink() {
        return link;
    }

    public String getSlug() {
        return slug;
    }

    public ShortLinkState getState() {
        return state;
    }

    public String getTitle() {
        return title;
    }

    public void setCreatedAt(DateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public void setState(ShortLinkState state) {
        this.state = state;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
