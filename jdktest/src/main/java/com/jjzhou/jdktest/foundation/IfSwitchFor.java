package com.jjzhou.jdktest.foundation;

import org.junit.Test;

/**
 * @author zhoujianjun
 * @description if、switch和for的实现原理
 * @date 2020/12/16 10:51 上午
 */
public class IfSwitchFor {

    /**
     * 条件执行具体是怎么实现的呢？
     *
     * 程序最终都是一条条的指令，CPU有一个指令指示器，指向下一条要执行的指令，CPU根据指示器的指示加载指令并且执行。
     * 指令大部分是具体的操作和运算，在执行这些操作时，执行完一个操作后，指令指示器会自动指向挨着的下一条指令。
     *
     * 但有一些特殊的指令，称为跳转指令，这些指令会修改指令指示器的值，让CPU跳到一个指定的地方执行。
     * 跳转有两种：一种是条件跳转；另一种是无条件跳转。
     * 条件跳转检查某个条件，满足则进行跳转，无条件跳转则是直接进行跳转。
     *
     * 比如下面的代码，转换成跳转指令会是：
     * 1. int a = 1;
     * 2. 条件跳转： 如果 a % 2 == 1，跳转到第4行
     * 3. 无条件跳转： 跳转到第7行
     * 4. {
     * 5.     System.out.println("奇数");
     * 6. }
     * 7. System.out.println("偶数");
     *
     * 你可能会奇怪第3行的无条件跳转指令，没有它不行吗？
     * 不行，没有这条指令，它会顺序执行接下来的指令，导致不管什么条件，括号中的代码都会执行。
     */
    @Test
    public void testIf() {
        int a = 1;
        String res = null;
        if (a % 2 == 1) {
            res = "奇数";
        } else {
            res = "偶数";
        }
        assert "奇数".equals(res);
    }

    /**
     * switch的转换和具体系统实现有关。如果分支比较少，可能会转换为跳转指令。
     * 如果分支比较多，使用条件跳转会进行很多次的比较运算，效率比较低，可能会使用一种更为高效的方式，叫跳转表。
     * 跳转表是一个映射表，存储了可能的值以及要跳转到的地址。
     * ----------------------
     * | 条件值 | 跳转地址 |
     * ----------------------
     * |  1   |  代码块第3行 |
     * ----------------------
     * |  2   | 代码第4行 |
     * ----------------------
     *
     * 跳转表为什么会更为高效呢？
     * 因为其中的值必须为整数，且按大小顺序排序。按大小排序的整数可以使用高效的二分查找，
     * 即先与中间的值比，如果小于中间的值，则在开始和中间值之间找，否则在中间值和末尾值之间找，
     * 每找一次缩小一半查找范围。如果值是连续的，则跳转表还会进行特殊优化，优化为一个数组，
     * 连找都不用找了，值就是数组的下标索引，直接根据值就可以找到跳转的地址。
     * 即使值不是连续的，但数字比较密集，差的不多，编译器也可能会优化为一个数组型的跳转表，没有的值指向default分支。
     *
     * 程序源代码中的case值排列不要求是排序的，编译器会自动排序。switch值的类型可以是byte、short、int、char、枚举和String。
     * 其中byte/short/int本来就是整数，char本质上也是整数，而枚举类型也有对应的整数，String用于switch时也会转换为整数。
     * 不可以使用long，为什么呢？跳转表值的存储空间一般为32位，容纳不下long。
     * 简单说明下String，String是通过hashCode方法转换为整数的，但不同String的hashCode可能相同，跳转后会再次根据String的内容进行比较判断。
     */
    @Test
    public void testSwitch() {
        int a = 1;
        switch (a) {
            case 1:
                System.out.print("1");
            case 2:
                System.out.print("2");
            case 3:
                System.out.print("3");
        }
    }

    /**
     * 和if一样，循环内部也是靠条件转义和无条件转移指令实现的
     *
     * 1. int [] arr = new int[]{1, 2, 3, 4};
     * 2. int i = 0;
     * 3. 条件跳转：如果i >= arr.length，跳转到第7行
     * 4. System.out.println(arr[i]);
     * 5. i ++;
     * 6. 无条件跳转，跳转到第3行
     * 7. System.out.println("for finished");
     * 在if中，跳转只会往后面跳，而for会往前面跳，第6行就是无条件跳转指令，跳转到了前面的第3行。
     * break/continue语句也都会转换为跳转指令。
     */
    @Test
    public void testFor() {
        int [] arr = new int[]{1, 2, 3, 4};
        for (int i = 0; i < arr.length; i ++) {
            System.out.println(arr[i]);
        }
        System.out.println("for finished");
    }
}
