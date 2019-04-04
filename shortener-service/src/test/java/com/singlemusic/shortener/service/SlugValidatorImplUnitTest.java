package com.singlemusic.shortener.service;

import com.singlemusic.shortener.exception.SlugValidationException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class SlugValidatorImplUnitTest {
    @InjectMocks
    private SlugValidatorImpl slugValidator;

    @Test
    public void validate() {
        assertEquals("valid-slug", slugValidator.validate("valid-slug"));
    }

    @Test(expected = SlugValidationException.class)
    public void validate_invalid() {
        slugValidator.validate("Some%20Stupid$Nonsense!");
    }
}