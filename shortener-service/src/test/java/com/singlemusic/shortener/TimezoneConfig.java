package com.singlemusic.shortener;

import org.joda.time.DateTimeZone;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@Configuration
public class TimezoneConfig {

    @PostConstruct
    void setupTimezones() {
        DateTimeZone.setDefault(DateTimeZone.UTC);
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
    }
}
