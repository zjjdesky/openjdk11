package com.jjzhou.jdktest.thread;

import java.text.SimpleDateFormat;

/**
 * @author zhoujianjun
 * @description
 * @date 2021/1/13 11:43 上午
 */
public class ThreadLocalDemo {

    private static final ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 0);

    public static void main(String[] args) {
        int n = 10;
        Thread[] threads = new Thread[n];
        for (int i = 0; i < n; i ++) {
            int finalIndex = i;
            threads[i] = new Thread(() -> {
                threadLocal.set(finalIndex);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " " + threadLocal.get());
            }, "Thread" + i);
            threads[i].start();
        }



    }
}
