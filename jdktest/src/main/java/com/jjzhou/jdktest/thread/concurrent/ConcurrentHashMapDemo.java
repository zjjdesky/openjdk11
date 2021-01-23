package com.jjzhou.jdktest.thread.concurrent;

import org.junit.Test;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author jjzhou
 * @date 2021/1/21 11:09 上午
 * @description
 */
public class ConcurrentHashMapDemo {

    @Test
    public void testAdd() {
        ConcurrentHashMap<String, String> chm = new ConcurrentHashMap<>();
        chm.put("1", "1");

    }

    @Test
    public void testResizeStamp() {
//        static final int resizeStamp(int n) {
//            return Integer.numberOfLeadingZeros(n) | (1 << (RESIZE_STAMP_BITS - 1));
//        }
        // 最高位无符号的0的个数     16：10000    ->   32-5=27
        System.out.println(Integer.numberOfLeadingZeros(16));
    }
}
