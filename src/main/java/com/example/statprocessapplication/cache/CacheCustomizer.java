package com.example.statprocessapplication.cache;

import static java.util.Arrays.asList;

import org.springframework.boot.autoconfigure.cache.CacheManagerCustomizer;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.stereotype.Component;

@Component
public class CacheCustomizer
        implements CacheManagerCustomizer<ConcurrentMapCacheManager> {

    @Override
    public void customize(ConcurrentMapCacheManager cacheManager) {
        cacheManager.setCacheNames(asList(
                "salesAndTrafficByDate",
                "salesAndTrafficByDateRange",
                "salesAndTrafficByAsins",
                "salesAndTrafficByAsin"
        ));
    }
}
