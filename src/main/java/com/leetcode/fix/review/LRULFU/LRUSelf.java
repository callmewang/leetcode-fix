package com.leetcode.fix.review.LRULFU;

import java.util.HashMap;

public class LRUSelf<K,V> {

    private final int MAX_CACHE_SIZE = 1<<4;
    private Entry first;
    private Entry last;

    private HashMap<K, Entry<K, V>> data = new HashMap<K, Entry<K, V>>();


    class Entry<K, V> {
        public Entry pre;
        public Entry next;
        public K key;
        public V value;
    }

    public void put(K key, V value) {
        Entry entry = getEntry(key);
        if (entry == null) {
            if (data.size() >= MAX_CACHE_SIZE) {
                data.remove(last.key);
                removeLast();
            }
            entry = new Entry();
            entry.key = key;
        }
        entry.value = value;
        moveToFirst(entry);
        data.put(key, entry);
    }

    public V get(K key) {
        Entry<K, V> entry = getEntry(key);
        if (entry == null) return null;
        moveToFirst(entry);
        return entry.value;
    }
//
//    public void remove(K key) {
//        Entry entry = getEntry(key);
//        if (entry != null) {
//            if (entry.pre != null) entry.pre.next = entry.next;
//            if (entry.next != null) entry.next.pre = entry.pre;
//            if (entry == first) first = entry.next;
//            if (entry == last) last = entry.pre;
//        }
//        data.remove(key);
//    }

    private void moveToFirst(Entry entry) {
        if (entry == first) return;
        if (entry.pre != null) entry.pre.next = entry.next;
        if (entry.next != null) entry.next.pre = entry.pre;
        if (entry == last) last = last.pre;

        if (first == null || last == null) {
            first = last = entry;
            return;
        }

        entry.next = first;
        first.pre = entry;
        first = entry;
        entry.pre = null;
    }

    private void removeLast() {
        if (last != null) {
            last = last.pre;
            if (last == null) first = null;
            else last.next = null;
        }
    }


    private Entry<K, V> getEntry(K key) {
        return data.get(key);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Entry entry = first;
        while (entry != null) {
            sb.append(String.format("%s:%s ", entry.key, entry.value));
            entry = entry.next;
        }
        return sb.toString();
    }


}
