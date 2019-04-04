package com.singlemusic.shortener.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class IpAddressParserImpl implements IpAddressParser {
    @Override
    public String parse(String ipAddressList) {
        if (StringUtils.isBlank(ipAddressList)) {
            return null;
        }
        if (!ipAddressList.contains(", ")) {
            return ipAddressList;
        }
        return ipAddressList.split(", ")[0].trim();
    }
}
