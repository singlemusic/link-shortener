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
package com.singlemusic.shortener;

import com.singlemusic.shortener.service.IpAddressParserUnitTest;
import com.singlemusic.shortener.service.SlugValidatorImplUnitTest;
import com.wix.mysql.EmbeddedMysql;
import com.wix.mysql.config.DownloadConfig;
import com.wix.mysql.config.MysqldConfig;
import com.wix.mysql.config.SchemaConfig;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import java.time.ZoneId;
import java.util.TimeZone;

import static com.wix.mysql.distribution.Version.v5_7_19;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        IpAddressParserUnitTest.class,
        SlugValidatorImplUnitTest.class
})
public class TestSuite {
    private static EmbeddedMysql embeddedMysql;

    @BeforeClass
    public static void _setupBeforeClass() {
        MysqldConfig config = MysqldConfig.aMysqldConfig(v5_7_19)
                .withPort(3308)
                .withTimeZone(TimeZone.getTimeZone(ZoneId.of("UTC")))
                .withUser("test", "test")
                .build();

        SchemaConfig schemaConfig = SchemaConfig.aSchemaConfig("shortener")
                .build();

        embeddedMysql = EmbeddedMysql.anEmbeddedMysql(config)
                .withDownloadConfig(DownloadConfig.aDownloadConfig()
                        .withCacheDir("./.embedmysql")
                        .build())
                .addSchema(schemaConfig)
                .start();
    }

    @AfterClass
    public static void _tearDownAfterClass() {
        if (null != embeddedMysql) {
            embeddedMysql.stop();
        }
    }
}
