package com.wildlife.stats.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;

@Service
public class CacheService<K,V> {

    private ConcurrentHashMap<K, V> cacheMap;

    public CacheService(ConcurrentHashMap<K,V> cacheMap) {
        this.cacheMap = cacheMap;
    }

    public CacheService(K key, V value, int cacheEvictionSeconds) {
        cacheMap = new ConcurrentHashMap();
        setEvictionPolicy(cacheEvictionSeconds);
    }

    public ConcurrentHashMap<K, V> getCacheMap() {
        return cacheMap;
    }

    public void setCacheMap(ConcurrentHashMap<K, V> cacheMap) {
        this.cacheMap = cacheMap;
    }


    private void setEvictionPolicy(int evictSeconds) {
        //Add logic to evict cache after evictSeconds on cacheMap
    }


}
