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