package com.example.statprocessapplication.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CacheCleaner {

    @Scheduled(fixedRate = 120000)
    @CacheEvict(
            value = {
                    "salesAndTrafficByDate",
                    "salesAndTrafficByDateRange",
                    "salesAndTrafficByAsins",
                    "salesAndTrafficByAsin"
            }, allEntries = true
    )
    public void clearCache() {
        System.out.println("Cache has been cleared");
    }
}
