package com.leetcode.fix.review.LRULFU;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCacha<K,V>{

    int capty;

    LinkedHashMap<K,V> map;


//    LRUCacha(int init){
//        this.capty = init;
//        map = new LinkedHashMap<K,V>(capty,0.75f,true){
//            @Override
//            protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
//                return map.size() > capty;
//            }
//        };
//    }
//    public V get(K key) {
//        return map.get(key);
//    }
//
//    public void put(K key, V value) {
//        map.put(key, value);
//    }

    public LRUCacha(int size) {
        this.capty = size;
        map = new LinkedHashMap<K,V>(size,0.75f,true){
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return map.size() > capty;
            }
        };
    }

}
