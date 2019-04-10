/*
    link-shortener
    Copyright (C) 2019  Single LLC

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
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
