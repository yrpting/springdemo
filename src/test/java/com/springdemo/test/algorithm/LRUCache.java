package com.springdemo.test.algorithm;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;

public class LRUCache<K, V> extends LinkedHashMap<K, V> {

    /**
     *Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = -6684027786161033453L;

    private int               MAX_CACHE_SIZE;

    public LRUCache(int cacheSize) {
        this(cacheSize, false);
    }
    public LRUCache(int cacheSize, boolean accessorder) {
        super((int) Math.ceil(cacheSize / 0.75) + 1, 0.75f, true);
        this.MAX_CACHE_SIZE = cacheSize;
    }

    @Override
    protected boolean removeEldestEntry(java.util.Map.Entry<K, V> eldest) {
        return size() > MAX_CACHE_SIZE;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (Map.Entry<K, V> entry : entrySet()) {
            sb.append(entry.getKey()).append(":").append(entry.getValue()).append("\n");
        }
        return super.toString();
    }
}
