package com.singlemusic.shortener;

import org.flywaydb.core.Flyway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * This is a test configuration that allows us to run flyway migrations
 * before our integration tests.
 */
@Configuration
public class FlywayConfig {
    @Resource
    private DataSource dataSource;

    /**
     * This runs the flyway migrations against the database.
     * @return flyway - the flyway instance.
     */
    @Bean
    Flyway flyway() {
        Flyway flyway = new Flyway();
        flyway.setDataSource(dataSource);
        flyway.setLocations("db/migration");
        flyway.migrate();
        return flyway;
    }
}
