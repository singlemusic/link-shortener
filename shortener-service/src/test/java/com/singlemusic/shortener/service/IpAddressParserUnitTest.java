package com.singlemusic.shortener.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(MockitoJUnitRunner.class)
public class IpAddressParserUnitTest {
    @InjectMocks
    private IpAddressParserImpl ipAddressParser;

    @Test
    public void parse() {
        assertEquals("108.87.159.80", ipAddressParser.parse("108.87.159.80, 172.31.9.45"));
        assertEquals("108.87.159.80", ipAddressParser.parse("108.87.159.80, 172.31.9.45, 172.31.9.50"));
        assertEquals("108.87.159.80", ipAddressParser.parse("108.87.159.80"));
        assertNull(ipAddressParser.parse(null));
        assertNull(ipAddressParser.parse("  "));
    }
}