package org.wxh.bestpractice.nkw;

import java.util.concurrent.TimeUnit;

/**
 * 作者: wangxh
 * 创建日期: 17-2-3
 */
public class Fibonacci {


    public static int Fibonacci(int n) throws InterruptedException {
        int a = 0, b = 1;
        int result = 0;
        for (int i = 0; i <= n; i++) {
            int next = a + b;
            result = a;
            a = b;
            b = next;
        }
        return result;
    }


    public static void main(String[] args) throws InterruptedException {
        System.out.println(Fibonacci(6));
    }
}
