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
CREATE TABLE IF NOT EXISTS `short_link`
(
  `id`         VARCHAR(40)  NOT NULL,
  `slug`       VARCHAR(64)  NOT NULL UNIQUE,
  `link`       VARCHAR(512) NOT NULL,
  `title`      VARCHAR(512) NULL,
  `created_at` DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `state`      VARCHAR(32)  NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `idx_short_link_slug` (`slug`),
  INDEX `idx_short_link_link` (`link`)
);

CREATE TABLE IF NOT EXISTS `short_link_click`
(
  `id`            VARCHAR(40)  NOT NULL,
  `short_link_id` VARCHAR(40)  NOT NULL,
  `link`          VARCHAR(512) NOT NULL,
  `ip_address`    VARCHAR(39)  NOT NULL,
  `user_agent`    VARCHAR(512) NULL,
  `referrer`      VARCHAR(512) NULL,
  `created_at`    DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  INDEX `idx_short_link_click_short_link_id` (`short_link_id`)
);