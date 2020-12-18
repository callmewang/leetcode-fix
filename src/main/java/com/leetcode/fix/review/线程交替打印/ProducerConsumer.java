package com.leetcode.fix.review.线程交替打印;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumer {

    private static volatile boolean run = true;

    private static int MAX_SIZE = 10;

    private static int current = 0;
    static List<Integer> list = new ArrayList<>();
    private static Lock lock = new ReentrantLock();
    private static Condition notFull = lock.newCondition();
    private static Condition notEmpty = lock.newCondition();

    static class ThreadProducer extends Thread {

        @Override
        public void run(){
            while(run){
                lock.lock();
                try{
                    while(MAX_SIZE == current){
                        notFull.await();
                    }
                    int goods = new Random(1000).nextInt();
                    System.out.println("producer===>" + goods);
                    list.add(goods);
                    current++;
                    notEmpty.signal();
                }catch(Exception e){
                    e.printStackTrace();
                }finally{
                    lock.unlock();
                }
            }
        }
    }

    static class ThreadConsumer extends Thread {
        @Override
        public void run(){

            while(run) {
                lock.lock();
                try{
                    while(current == 0){
                        notEmpty.await();
                    }
                    Integer goods = list.get(0);
                    System.out.println("consumer===>" + goods);
                    list.remove(goods);
                    current--;
                    notFull.signalAll();
                }catch(Exception e){
                    e.printStackTrace();
                }finally{
                    lock.unlock();
                }
            }
        }
    }

    public static void main(String[] args){
        new ThreadProducer().start();
        new ThreadProducer().start();
        new ThreadProducer().start();
        new ThreadProducer().start();
        new ThreadConsumer().start();

    }


}
