package com.singlemusic.shortener.repository;

import com.singlemusic.shortener.ShortenerApplication;
import com.singlemusic.shortener.FlywayConfig;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ShortenerApplication.class, FlywayConfig.class})
@ActiveProfiles("test")
@Transactional
public abstract class RepositoryTest {
}
