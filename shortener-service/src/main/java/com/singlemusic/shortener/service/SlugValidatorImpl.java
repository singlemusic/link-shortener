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
