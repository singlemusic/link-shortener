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
