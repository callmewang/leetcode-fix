package com.leetcode.fix.review.字母异位分词;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = {"eat", ""};
        System.out.println(groupAnagrams(strs));

    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> rest = new HashMap<>();
        for(String str :strs){
            String c = mapContains(rest,str);
            if(!rest.containsKey(c)){
                List<String> r = new ArrayList<>();
                r.add(str);
                rest.put(str,r);
            } else {
                List<String> r = new ArrayList<>(rest.get(c));
                r.add(str);
                rest.put(c,r);
            }
        }
        List<List<String>> rr = new ArrayList<>();
        for (Map.Entry<String, List<String>> map : rest.entrySet()) {
            rr.add(map.getValue());
        }

        return rr;
    }

    public static String mapContains(Map<String, List<String>> rest, String target){
        char k0 = 0;
        for (int i = 0;i<target.length();i++) {
            k0 += target.charAt(i);
        }
        String r = "";
        for (Map.Entry<String, List<String>> map : rest.entrySet()) {
            char k1 = 0;
            for (int i = 0;i<map.getKey().length();i++) {
                k1 += map.getKey().charAt(i);
            }
            if (k1 == k0) {
                r = map.getKey();
                break;
            }
        }
        return r;
    }
}
