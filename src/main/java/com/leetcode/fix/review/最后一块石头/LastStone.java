package com.leetcode.fix.review.最后一块石头;

import java.util.PriorityQueue;

public class LastStone {

    public static void main(String[] args) {
        PriorityQueue<Integer> stones = new PriorityQueue<Integer>((a,b) -> b-a);

        int[] s = {2,7,4,1,8,1};

        for (Integer i : s) {
            stones.offer(i);
        }

        while (stones.size() > 1) {

            int e1 = stones.poll();
            int e2 = stones.poll();

            if (e1 != e2) {
                stones.offer(Math.abs(e1 - e2));
            }
        }

        System.out.println(stones.poll());
    }

}
