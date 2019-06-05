package com.open.ehcache.service;

import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class EhcacheTestService {
    @CachePut(value = "cachetest", key = "#key")
    public String put(String key, String value) {
        System.out.println("保存数据, " + key + " : " + value);

        return value;
    }

    @Cacheable(value = "cachetest", key = "#name")
    public String getName(String name) {
        return String.valueOf(System.currentTimeMillis());
    }
}
