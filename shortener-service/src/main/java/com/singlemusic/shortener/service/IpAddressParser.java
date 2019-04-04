package com.singlemusic.shortener.service;

public interface IpAddressParser {
    /**
     * Parses the first IP address out of a comma+space-separated
     * list if IP addresses, which is what we may have in the
     * <code>X-Forwarded-For</code> header.
     *
     * The first IP is the original remote IP.
     *
     * @param ipAddressList a comma+space-separated list of IPv4 addresses
     * @return the first IP address in the list.
     */
    String parse(String ipAddressList);
}
