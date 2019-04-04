package com.singlemusic.shortener.exception;

public class ShortLinkNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 7372893381380401543L;

    public ShortLinkNotFoundException(final String message) {
        super(message);
    }
}
