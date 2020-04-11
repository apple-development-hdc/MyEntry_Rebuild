package com.myentry.MyEntry.Controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;
import java.util.logging.Logger;

@Slf4j
@RestController
@CrossOrigin("*")

public class AppController {

    @Autowired
    private CacheManager cacheManager;

    @GetMapping( "/hello" )
    public String firstPage() {
        Cache cache = cacheManager.getCache("token");
        assert cache != null;
      //  log.info( cache.getName()+ Objects.requireNonNull(cache.get("token")).get());
        return "Hello World";
    }
}
