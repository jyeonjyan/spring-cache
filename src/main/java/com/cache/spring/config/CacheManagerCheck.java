package com.cache.spring.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.sf.ehcache.CacheManager;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class CacheManagerCheck implements CommandLineRunner {
    private final CacheManager cacheManager;

    @Override
    public void run(String... args) throws Exception {
        log.info("\n\n" + "=========================================== \n"
            + "Using cache manager:" + this.cacheManager.getClass().getName() + "\n"
            + "=========================================================\n\n");
    }
}
