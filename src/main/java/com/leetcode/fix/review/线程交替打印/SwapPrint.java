package com.leetcode.fix.review.线程交替打印;

import java.util.concurrent.atomic.AtomicInteger;

public class SwapPrint {

    static volatile int t = 0;
    static Object obj = new Object();

    static class Thread1 extends Thread{
        @Override
        public void run() {
            synchronized (obj) {
                while (t <= 100) {
                    if (t%2==0) {
                        System.out.println("SwapPrint1===>" + t);
                        obj.notify();
                        t++;
                    }
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        }
    }

    static class Thread2 extends Thread{

        @Override
        public void run() {
            synchronized (obj) {
                while (t<=100) {
                    if (t%2==1) {
                        System.out.println("SwapPrint2===>" + t);
                        obj.notify();
                        t++;
                    }
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }

        }
    }

    public static void main(String[] args) {
        new Thread1().start();
        new Thread2().start();
    }



}
