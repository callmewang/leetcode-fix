package com.leetcode.fix.common;

public class SingleTone {

    private volatile static  SingleTone singleTone = null;

    private SingleTone(){}

    public SingleTone getInstance(){
        if(singleTone == null) {
            synchronized (this){
                if (singleTone == null) {
                    singleTone = new SingleTone();
                }
            }
        }
        return singleTone;
    }
}
