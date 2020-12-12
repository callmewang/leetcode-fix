package com.leetcode.fix.review.优先级队列;

import java.util.PriorityQueue;

public class TopK {

    public static void main(String[] args) {
//        PriorityQueue<Integer> pq = new PriorityQueue<>(5);//队列默认自然顺序排列，小顶堆，不必重写compare
        int[] temp = {1,3,2,70,19,6,2,9,6,90,9,4};
//        for (int num : temp) {
//            if (pq.size() < 5) {
//                pq.offer(num);
//            } else if (pq.peek() < num) {//如果堆顶元素 < 新数，则删除堆顶，加入新数入堆
//                pq.poll();
//                pq.offer(num);
//            }
//        }
//        System.out.println(1);
        for (int i = temp.length/2 -1;i>=0;i--) {
            bigHeap(temp,i,temp.length);

        }

        for (int j = temp.length -1;j>temp.length -6;j--) {
            swapValue(temp,0,j);
            bigHeap(temp,0,j);
        }
        System.out.println(1);

        int[] array = {1,3,2,70,19,6,2,9,6,90,9,4};

        for (int i = array.length/2 -1;i>=0;i--) {
            smallHeap(array,i,array.length);
        }

        for (int j = array.length-1;j>temp.length -6;j--) {
            swapValue(array,0,j);
            smallHeap(array,0,j);
        }
        System.out.println(1);
    }

    private static void smallHeap(int[] array, int i, int length) {
        int temp = array[i];
        for (int k = 2*i+1;k<length;k=k*2+1){
            if (k+1<length && array[k+1] < array[k]) {
                k++;
            }
            if (array[k] < temp) {
                array[i] = array[k];
                i = k;
            } else {
                break;
            }
        }
        array[i] = temp;
    }

    private static void bigHeap(int[] temp, int i, int length) {
        int t = temp[i];
        for (int k = 2*i+1;k<length;k = 2*k+1) {
            if (k+1 < length && temp[k+1] > temp[k]) {
                k++;
            }
            if (temp[k] > t) {
                temp[i] = temp[k];
                i=k;
            } else {
                break;
            }
        }
        temp[i] = t;
    }

    private static void swapValue(int[] temp, int i, int j) {
        int t = temp[j];
        temp[j] = temp[i];
        temp[i] = t;
    }

}
