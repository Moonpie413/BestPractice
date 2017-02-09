package org.wxh.bestpractice.ThinkingInJava.chapter17.practice1;

import org.wxh.bestpractice.ThinkingInJava.chapter17.test1.custommap.Countries;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by wangxh on 16-11-9.
 * package org.wxh.bestpractice.ThinkingInJava.chapter17.practice1
 * des 测试shuffle方法
 */
public class Demo {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Countries.names(10));
        System.out.println("origanal list");
        System.out.println("--------------");
        System.out.println(list);
        for (int i = 0; i < 10; i++) {
            System.out.println("shuffled " + i + ": ");
            Collections.shuffle(list);
            System.out.println(list);
        }
    }

}
