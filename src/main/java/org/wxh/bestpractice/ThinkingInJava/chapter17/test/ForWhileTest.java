package org.wxh.bestpractice.ThinkingInJava.chapter17.test;

/**
 * Created by wangxh on 16-11-12.
 * package org.wxh.bestpractice.ThinkingInJava.chapter17.test
 * des
 */
public class ForWhileTest {
    public static void main(String[] args) {
        for (int i = 0; ;i++) {
            System.out.println(i);
            if (i == 1000) break;
        }
    }
}
