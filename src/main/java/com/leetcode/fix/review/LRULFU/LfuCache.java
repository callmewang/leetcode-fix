package com.leetcode.fix.review.LRULFU;

import java.util.*;

public class LfuCache <K,V>{

    private int capicity ;

    private HashMap<K,LFUEntity<K,V>> data ;

    LfuCache(int capicity){
        this.capicity = capicity;
        this.data = new LinkedHashMap<>();

    }

    class LFUEntity<K,V> implements Comparable<LFUEntity>{
        K k;
        V v;
        int count;
        long time;

        public LFUEntity(K k,V v,int count,long localDateTime){
            this.k = k;
            this.v = v;
            this.count = count;
            this.time = localDateTime;

        }

        @Override
        public int compareTo(LFUEntity o) {
            int compare = Integer.compare(this.count,o.count);
            if (compare == 0) {
                compare = Long.compare(this.time,o.time);
            }
            return compare;
        }
    }

    private void sort() {
        List<LFUEntity<K, V>> list = new ArrayList<>();
        for (Map.Entry<K, LFUEntity<K, V>> e : data.entrySet()) {
            list.add((LFUEntity<K, V>) e);
        }

        Collections.sort(list, new Comparator<LFUEntity<K, V>>() {
            @Override
            public int compare(LFUEntity<K, V> o1, LFUEntity<K, V> o2) {
                return o2.compareTo(o1);
            }
        });

        data.clear();

        for (LFUEntity<K, V> l : list) {
            data.put(l.k,l);
        }

    }

    public V get(K k) {
        if (containKey(k)) {
            LFUEntity entity = data.get(k);
            entity.count+=1;
            entity.time = System.currentTimeMillis();
            data.put(k,entity);
            sort();
            return (V)entity.v;
        }

        return null;
    }

    public void put(K k,V v){

        if (!containKey(k)) {
            LFUEntity<K, V> e = new LFUEntity<>(k,v,1,System.currentTimeMillis());
            if (data.size() >= capicity) {
                K remove = getRemoveKey();
                data.remove(remove);

            }
            data.put(k,e);
        }
        LFUEntity<K, V> e = data.get(k);
        e.count +=1;
        e.time = System.currentTimeMillis();
        e.v = v;
        sort();

    }

    private K getRemoveKey() {
        Collection<LFUEntity<K, V>> values = data.values();
        LFUEntity min = Collections.min(values);
        return (K)min.k;
    }


    public boolean containKey(K k){
        return data.containsKey(k);
    }



}
