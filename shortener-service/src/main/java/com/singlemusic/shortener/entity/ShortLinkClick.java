package com.singlemusic.shortener.entity;

import org.hibernate.annotations.GenericGenerator;
import org.joda.time.DateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "short_link_click")
public class ShortLinkClick implements Serializable {
    private static final long serialVersionUID = 8269171662751386944L;
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id")
    private String id;
    @Column(name = "short_link_id", nullable = false)
    private String shortLinkId;
    @Column(name = "link", nullable = false)
    private String link;
    @Column(name = "ip_address", nullable = false)
    private String ipAddress;
    @Column(name = "user_agent")
    private String userAgent;
    @Column(name = "referrer")
    private String referrer;
    @Column(name = "created_at")
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
