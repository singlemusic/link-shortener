package com.singlemusic.shortener.entity;

import com.singlemusic.shortener.entity.enums.ShortLinkState;
import com.singlemusic.shortener.util.JsonToString;
import org.hibernate.annotations.GenericGenerator;
import org.joda.time.DateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(
        name = "short_link",
        indexes = {
                @Index(
                        name = "idx_short_link_slug",
                        unique = true,
                        columnList = "slug"),
                @Index(
                        name = "idx_short_link_link",
                        columnList = "link"
                )
        }
)
public class ShortLink implements Serializable {
    private static final long serialVersionUID = -5892145160292571662L;
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id")
    private String id;
    @Column(name = "slug", nullable = false, unique = true)
    private String slug;
    @Column(name = "title")
    private String title;
    @Column(name = "link", nullable = false)
    private String link;
    @Column(name = "created_at", nullable = false)
    private DateTime createdAt;
    @Column(name = "state", nullable = false)
    @Enumerated
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

    @Override
    public String toString() {
        return JsonToString.write(this);
    }
}
