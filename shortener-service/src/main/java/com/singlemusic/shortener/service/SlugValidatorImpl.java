package com.singlemusic.shortener.service;

import com.singlemusic.shortener.exception.SlugValidationException;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class SlugValidatorImpl implements SlugValidator {
    private static final Pattern SLUG_PATTERN = Pattern.compile("^[a-zA-Z0-9-_]+$");
    @Override
    public String validate(String slug) {
        if (!SLUG_PATTERN.matcher(slug).matches()) {
            throw new SlugValidationException(slug + " is an invalid slug. " +
                    "Only alphanumeric characters, hyphens, and underscores are allowed.");
        }
        return slug;
    }
}
