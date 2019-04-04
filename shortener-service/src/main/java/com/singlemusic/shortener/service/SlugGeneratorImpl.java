package com.singlemusic.shortener.service;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Component;

@Component
public class SlugGeneratorImpl implements SlugGenerator {
    @Override
    public String generate(String input) {
        return DigestUtils.md2Hex(input).substring(0, 8);
    }
}
