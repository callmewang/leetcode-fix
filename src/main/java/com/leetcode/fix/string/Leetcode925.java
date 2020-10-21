package com.leetcode.fix.string;

/*
* number 8
* */
public class Leetcode925 {
    public static void main(String[] args) {
        System.out.println(isLongPressedName("alex" , "alexxr"));

    }
    public static boolean isLongPressedName(String name, String typed) {
        if (name != null
                && typed != null
                && name.equals(typed)) return true;
        if ((name != null && typed == null)
                || (name == null && typed != null)) return false;
        int n = name.length();
        int t = typed.length();
        int sn = 0;
        int st = 0;
        char pre = name.charAt(0);
        boolean rest = true;
        while(sn < n || st<t){
            if (sn < n ){
                char temp = name.charAt(sn);
                if (st < t && temp == typed.charAt(st) ) {
                    sn++;
                    st++;
                    pre = temp;
                } else {
                    if (st < t && typed.charAt(st) == pre ) {
                        st++;
                    } else {
                        rest = false;
                        break;
                    }
                }
            } else {
                while (st < t) {
                    if (typed.charAt(st) == pre) {
                        st++;
                    } else {
                        break;
                    }
                }
                break;
            }
        }
        if (!(sn == n && st == t)) {
            rest = false;
        }
        return rest;
    }
}
