package com.singlemusic.shortener.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class SlugGeneratorImplUnitTest {
    @InjectMocks
    private SlugGeneratorImpl slugGenerator;

    @Test
    public void generate() {
        assertEquals("ac831eed", slugGenerator.generate("https://google.com"));
        assertEquals("229b1158", slugGenerator.generate("https://singlemusic.com"));
        assertEquals("2c88e57a", slugGenerator.generate("https://taylor.singleapp.co/api/boostlink/foo"));
    }
}