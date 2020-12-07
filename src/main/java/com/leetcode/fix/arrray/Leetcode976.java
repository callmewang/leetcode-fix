package com.leetcode.fix.arrray;
/**
 * . 三角形的最大周长
 * */
public class Leetcode976 {
    public static void main(String[] args) {
        int[] a = {3,6,2,3};

        System.out.println(check(a));
    }

    public static int check(int[] A){
        int max = 0;
        if (A.length <=2) return 0;
        for (int t= 0;t<A.length-2;t++) {
            for (int m = t+1;m<A.length-1;m++) {
                for (int n = m+1;n<A.length;n++) {
                    if (!(A[t] >= A[m]+A[n]
                            || A[m] >= A[t]+A[n]
                            || A[n] >= A[m]+A[t])) {
                        max = Math.max(max,A[m]+A[n]+A[t]);
                    }
                }
            }
        }
        return max;
    }
}


//因为已经经过排序， 所以 a>=b>=c>=d....
//假设 abd为最大周长，由三角形的满足条件可得b+d > a;
//而c >= d, 所以 b+c>=b+d>a,也成立。。
