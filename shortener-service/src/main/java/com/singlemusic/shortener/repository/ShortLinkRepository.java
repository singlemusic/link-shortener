package com.singlemusic.shortener.repository;

import com.singlemusic.shortener.entity.ShortLink;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ShortLinkRepository extends JpaRepository<ShortLink, String> {
    ShortLink findOneBySlug(String slug);

    @Query("SELECT s FROM ShortLink s " +
            "WHERE (" +
            "   s.title LIKE CONCAT('%', :query, '%') " +
            "   OR s.link LIKE CONCAT('%', :query, '%')" +
            "   OR s.slug LIKE CONCAT('%', :query, '%')" +
            ")")
    Page<ShortLink> findByQuery(String query, Pageable pageable);
}
