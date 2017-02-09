package org.wxh.bestpractice.java8.stream;

import java.util.Arrays;
import java.util.List;

/**
 * Created by maroon on 17-1-16.
 * DES:
 */
public class StreamLearning {
    private static List<String> strings = Arrays.asList("hello", "world", "你好");

    public static void main(String[] args) {
        System.out.println(strings.stream().filter(s -> s.length() > 3).count());
    }

}


