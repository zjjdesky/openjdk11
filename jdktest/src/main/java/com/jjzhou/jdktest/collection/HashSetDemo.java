package com.jjzhou.jdktest.collection;

import org.junit.Test;

import java.util.HashSet;

/**
 * @author zhoujianjun
 * @description
 * @date 2021/1/14 12:20 下午
 */
public class HashSetDemo {

    @Test
    public void testHashSet() {
        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(1);

        System.out.println(set.size());
    }
}
