package com.leetcode.fix.review;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCacha<K,V>{

    int capty;

    LinkedHashMap<K,V> map;


    LRUCacha(int init){
        this.capty = init;
        map = new LinkedHashMap<K,V>(capty,0.75f,true){
            @Override
            protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                return map.size() > capty;
            }
        };
    }
    public V get(K key) {
        return map.get(key);
    }

    public void put(K key, V value) {
        map.put(key, value);
    }
}
