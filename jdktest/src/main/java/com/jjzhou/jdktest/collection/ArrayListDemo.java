package com.jjzhou.jdktest.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhoujianjun
 * @description
 * @date 2020/12/16 2:27 下午
 */
public class ArrayListDemo {

    /**
     * 1. 首先判断是否容量满了，如果没有满，直接赋值
     * 2. 如果满了，就先去1.5倍扩容（容量最大为 Integer.MAX_VALUE - 8)，最后再去赋值
     */
    @Test
    public void testAdd() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        print(list);
    }

    @Test
    public void testRemove() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        print(list);
        list.remove(1);
    }

    /**
     * 只remove了一个数据
     */
    @Test
    public void testForCycleRemove() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        print(list);
        for (Integer val : list) {
            list.remove(val);
        }
        System.out.println("----------------");
        print(list);
    }

    @Test
    public void testForCycleRemove2() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        print(list);
        for (String val : list) {
            list.remove(val);
        }
        System.out.println("----------------");
        print(list);
    }

    /**
     * 会抛出 java.util.ConcurrentModificationException 异常
     */
    @Test
    public void testForCycleRemove3() {
        List<String> list = new ArrayList<>();
        list.add("100");
        list.add("200");
        print(list);
        for (String val : list) {
            if (val.equals("200")) {
                list.remove(val);
            }
        }
        System.out.println("----------------");
        print(list);
    }

    private static <T> void print(List<T> list) {
        if (null == list || list.isEmpty()) {
            System.out.println("no data ...");
            return;
        }
        for (T t : list) {
            System.out.print(t + "\t");
        }
    }
}
