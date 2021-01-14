package com.jjzhou.jdktest.collection;

import org.junit.Test;

import java.util.ArrayDeque;

/**
 * ArrayDeque内部实现是一个循环数组
 *
 * @author zhoujianjun
 * @description
 * @date 2021/1/14 12:05 下午
 */
public class ArrayDequeDemo {

    @Test
    public void testArrayDequeAdd() {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.add(1);
        deque.add(2);

    }
}
