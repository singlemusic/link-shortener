package com.singlemusic.shortener.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class SlugValidationException extends RuntimeException {
    private static final long serialVersionUID = 6261223952885392187L;

    public SlugValidationException(final String message) {
        super(message);
    }
}
