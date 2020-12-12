package com.leetcode.fix.review.移除k个数字剩下数字最小;


import java.util.Deque;
import java.util.LinkedList;

public class RemoveK {

    public static void main(String[] args) {
        String target = "1432219";
        String rest = removeK4(target,5);
        System.out.println(rest);
    }

    private static String removeK(String num, int k) {
        Deque<Character> deque = new LinkedList<Character>();
        int length = num.length();
        for (int i = 0; i < length; ++i) {
            char digit = num.charAt(i);
            while (!deque.isEmpty() && k > 0 && deque.peekLast() > digit) {
                deque.pollLast();
                k--;
            }
            deque.offerLast(digit);
        }

        for (int i = 0; i < k; ++i) {
            deque.pollLast();
        }

        StringBuilder ret = new StringBuilder();
        boolean leadingZero = true;
        while (!deque.isEmpty()) {
            char digit = deque.pollFirst();
            if (leadingZero && digit == '0') {
                continue;
            }
            leadingZero = false;
            ret.append(digit);
        }
        return ret.length() == 0 ? "0" : ret.toString();
    }

    private static String removeK2(java.lang.String target, int k) {
        Deque<Character> queue= new LinkedList<>();
        int length = target.length();
        for (int i =0;i<length;++i) {
            char temp = target.charAt(i);
            if (!queue.isEmpty() && k>0 && queue.peekLast() > temp) {
                queue.pollLast();
                k--;
            }
            queue.offerLast(temp);
        }
        while (k>0) {
            queue.pollLast();
            k--;
        }

        StringBuffer buffer = new StringBuffer();
        boolean leadingZero = true;
        while (!queue.isEmpty()) {
            Character t = queue.pollFirst();
            if (leadingZero && "0".equals(t)) {
                continue;
            }
            leadingZero = false;
            buffer.append(t+"");
        }

        return buffer.length() == 0 ? "0" : buffer.toString();
    }



    private static String removeK3(String target, int k) {
        int length = target.length();

        StringBuffer stringBuffer = new StringBuffer(target);

        for (int i =0;i<k;i++) {
            for (int j=1;j<length;j++) {
                if (stringBuffer.charAt(j) >= stringBuffer.charAt(j - 1)) {
                    stringBuffer.deleteCharAt(stringBuffer.length()-1);
                }
                stringBuffer.append(target.charAt(j)+"");
            }
        }
        while (stringBuffer.length() > 1 && stringBuffer.charAt(0) == '0') stringBuffer.delete(0, 1);
        return stringBuffer.toString();
    }


    private static String removeK4(String target, int k) {

        Deque<Character> queue = new LinkedList<>();
        int length = target.length();

        for (int i=0;i<length;i++) {
            char temp = target.charAt(i);
            while(!queue.isEmpty() && k>0 && queue.peekLast() > temp){
               queue.pollLast();
               k--;
            }
            queue.offerLast(temp);
        }

        while (k>0) {
            queue.pollLast();
            k--;
        }

        StringBuffer buffer = new StringBuffer();
        while (!queue.isEmpty()) {
            Character t = queue.pollFirst();
            if ( "0".equals(t)) {
                continue;
            }
            buffer.append(t+"");
        }
        return buffer.toString();
    }




}
