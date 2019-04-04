package com.singlemusic.shortener.controller;

import com.singlemusic.shortener.entity.ShortLink;
import com.singlemusic.shortener.service.ShortLinkClickService;
import com.singlemusic.shortener.service.ShortLinkService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/click")
public class ShortLinkClickController {
    private final Logger log = LoggerFactory.getLogger(ShortLinkClickController.class);

    @Resource
    private ShortLinkService shortLinkService;
    @Resource
    private ShortLinkClickService shortLinkClickService;

    @Value("${not.found.uri}")
    private String notFoundUri;

    @RequestMapping(value = "/{slug}", method = RequestMethod.GET)
    public void click(final @PathVariable("slug") String slug,
                      final HttpServletRequest request,
                      final HttpServletResponse response) throws IOException {
        ShortLink shortLink = shortLinkService.getBySlug(slug);
        if (null == shortLink) {
            log.warn("somebody trying to load short link that doesn't exist with slug {}", slug);
            response.sendRedirect(notFoundUri);
            return;
        }
        shortLinkClickService.trackClick(request, shortLink);
        response.sendRedirect(shortLink.getLink());
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public void homeRedirect(final HttpServletResponse response) throws IOException {
        response.sendRedirect(notFoundUri);
    }
}
