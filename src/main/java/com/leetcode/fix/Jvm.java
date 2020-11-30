package com.leetcode.fix;

import ch.qos.logback.core.hook.ShutdownHook;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.Arrays;

public class Jvm {

    public static void main(String[] args) {

        Runtime.getRuntime().addShutdownHook(new Thread(){
            @Override
            public void run() {
                System.out.println("================shutdown hook================");
            }
        });
        ThreadMXBean bean = ManagementFactory.getThreadMXBean();
        System.out.println("thread count:" + bean.getThreadCount());

        long[] ids = bean.getAllThreadIds();
        Arrays.stream(ids).forEach(e -> {
            System.out.println(bean.getThreadInfo(e));
        });
    }
}
