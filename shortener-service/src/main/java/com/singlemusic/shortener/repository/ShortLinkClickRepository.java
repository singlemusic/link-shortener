package com.singlemusic.shortener.repository;

import com.singlemusic.shortener.entity.ShortLinkClick;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShortLinkClickRepository extends JpaRepository<ShortLinkClick, String> {
    int countByShortLinkId(String shortLinkId);

    Page<ShortLinkClick> findByShortLinkIdOrderByCreatedAtDesc(String shortLinkId, Pageable pageable);
}
