package com.leetcode.fix.review.大数相加;

public class BigNumAdd {

    public static void main(String[] args) {
        String num1 ="10889239457861239871982342374";
        String num2 ="24351324321234108786126359462";
        String rest = addNum(num1,num2);

        System.out.println(rest);
    }

    private static String addNum(String num1, String num2) {
        StringBuffer sb = new StringBuffer();

        int l1 = num1.length()-1;
        int l2 = num2.length()-1;
        int carry = 0;

        while (l1 >=0 || l2 >= 0) {
            int n1 = l1>=0?Integer.parseInt(num1.charAt(l1)+""):0;
            int n2 = l2>=0?Integer.parseInt(num2.charAt(l2)+""):0;
            int val = (n1+n2+carry)%10;
            carry = (n1+n2+carry)/10;
            sb.append(val);
            l1--;
            l2--;
        }
        if (carry > 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }

}
