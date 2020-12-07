package com.leetcode.fix.arrray;



public class BirthTest {
    public static void main(String args[]) {
        int date = 9;
        BirthTest test = new BirthTest();
        test.change(date);
        BirthDate d1 = new BirthDate(7, 7, 1970);
    }

    public int change(int i){
        i = 1234;
        return i;
    }
}


class BirthDate {
    private int day;
    private int month;
    private int year;
    public BirthDate(int d, int m, int y) {
        day = d;
        month = m;
        year = y;
    }
}



