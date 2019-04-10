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