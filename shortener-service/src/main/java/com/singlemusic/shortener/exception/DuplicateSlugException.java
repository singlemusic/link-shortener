package com.singlemusic.shortener.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DuplicateSlugException extends RuntimeException {
    private static final long serialVersionUID = 2088883761842964899L;

    private final String slug;

    public DuplicateSlugException(String slug) {
        this.slug = slug;
    }

    @Override
    public String getMessage() {
        return String.format("the short link '%s' is already taken", slug);
    }
}
