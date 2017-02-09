package org.wxh.bestpractice.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by wangxh on 16-12-19.
 * Package org.wxh.bestpractice.lambda
 * DES:
 */
public class LambdaTest {
    @Test
    public void testList() {
        Integer[] listData = new Integer[]{1, 2, 3, 4};
        List list = Arrays.asList(listData);
        System.out.println(list);
        list.forEach(System.out::println);
    }
}
