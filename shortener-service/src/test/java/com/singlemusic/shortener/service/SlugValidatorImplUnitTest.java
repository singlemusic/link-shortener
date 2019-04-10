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