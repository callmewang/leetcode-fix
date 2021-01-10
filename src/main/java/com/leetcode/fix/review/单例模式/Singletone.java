package com.leetcode.fix.review.单例模式;

public class Singletone {
    private static volatile Singletone singletone;
    private Singletone(){}

    public Singletone getInstance() {
        if (singletone == null) {
            synchronized (this){
                if (singletone == null) {
                    singletone = new Singletone();
                }
            }
        }
        return singletone;
    }

//    private static volatile Singletone singletone;
//
//    private Singletone(){};
//
//    public Singletone getSingletone(){
//        if (singletone == null) {
//            synchronized (Singletone.class) {
//                if (singletone == null) {
//                    singletone = new Singletone();
//                }
//            }
//        }
//        return singletone;
//    }

}
