package com.jjzhou.jdktest.collection;

import org.junit.Test;

import java.util.LinkedList;

/**
 * @author zhoujianjun
 * @description
 * @date 2021/1/14 11:57 上午
 */
public class LinkedListDemo {

    @Test
    public void testAdd() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);

        linkedList.get(1);
    }


}
