package com.leetcode.fix.review.延时队列;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayTest {


    public static void main(String[] args) throws InterruptedException {
        DelayQueue<DelayMain> queue = new DelayQueue<>();

        long now = System.currentTimeMillis();
        queue.add(new DelayMain(now + 10000));
        queue.add(new DelayMain(now + 5000));
        queue.add(new DelayMain(now + 15000));

        while (true) {
            if (queue.size() > 0) {
                DelayMain main = queue.take();
                main.print();
            } else {
                System.out.println("finish");
                break;
            }
        }
    }

    static class DelayMain implements Delayed {

        long time = System.currentTimeMillis();

        public DelayMain(long time) {
            this.time = time;
        }

        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert(time - System.currentTimeMillis(),TimeUnit.MILLISECONDS);
        }

        @Override
        public int compareTo(Delayed o) {
            if(this.getDelay(TimeUnit.MILLISECONDS) < o.getDelay(TimeUnit.MILLISECONDS))
                return -1;
            else if(this.getDelay(TimeUnit.MILLISECONDS) > o.getDelay(TimeUnit.MILLISECONDS))
                return 1;
            else
                return 0;
        }

        public void print(){
            System.out.println("print=====>" + time);

        }
    }

}
