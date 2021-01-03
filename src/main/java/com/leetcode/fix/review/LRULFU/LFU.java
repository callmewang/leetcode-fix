package com.leetcode.fix.review.LRULFU;

import com.sun.jmx.snmp.Timestamp;

import javax.xml.soap.Node;
import java.util.*;

public class LFU<K,V> {

    int capacity ;

    HashMap<K,LFUNode> data;

    class LFUNode <K,V> implements Comparable<LFUNode>{
        K k;
        V v;
        long time;
        int count;

        public LFUNode(K k,V v,long time,int count){
            this.k = k;
            this.v = v;
            this.time = time;
            this.count = count;
        }

        @Override
        public int compareTo(LFUNode o) {
            int compare = Integer.compare(this.count, o.count);
            //在数目相同的情况下 比较时间
            if (compare==0){
                return Long.compare(this.time,o.time);
            }
            return compare;
        }
    }

    public LFU(int size){
        this.capacity = size;
        this.data = new LinkedHashMap<>(size);
    }


    public void put(K k,V v) {
        LFUNode node = data.get(k);
        if (node == null) {
            if (data.size() >= capacity) {
                K remove = getRemoveKey();
                data.remove(remove);
            }
            node = new LFUNode(k, v, System.nanoTime(), 1);
            data.put(k,node);
        }
        node.v = v;
        node.time = System.nanoTime();
        node.count += 1;
        sort();
    }

    private void sort() {
        List<Map.Entry<K, LFUNode>> list = new ArrayList<>(data.entrySet());
        Collections.sort(list,new Comparator<Map.Entry<K, LFUNode>>(){
            @Override
            public int compare(Map.Entry<K, LFUNode> o1, Map.Entry<K, LFUNode> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        data.clear();
        for (Map.Entry<K, LFUNode> kNodeEntry : list) {
            data.put(kNodeEntry.getKey(),kNodeEntry.getValue());
        }
    }

    private K getRemoveKey() {
        Collection<LFUNode> values = data.values();
        LFUNode min = Collections.min(values);
        return (K)min.k;
    }
    
    public V get(K k){
        if (data.containsKey(k)){
            LFUNode node = data.get(k);
            node.count += 1;
            node.time = System.nanoTime();
            sort();
            return (V) node.v;
        }
        return null;
    }
}
