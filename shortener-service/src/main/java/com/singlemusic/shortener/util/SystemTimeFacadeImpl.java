package com.singlemusic.shortener.util;

import org.joda.time.DateTime;
import org.springframework.stereotype.Service;

@Service
public class SystemTimeFacadeImpl implements SystemTimeFacade {
    @Override
    public DateTime now() {
        return DateTime.now();
    }
}
