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
