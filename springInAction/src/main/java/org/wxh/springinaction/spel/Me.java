package org.wxh.springinaction.spel;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by wangxh on 17-1-4.
 * Package org.wxh.springinaction.spel
 * DES:
 */
@Component
public class Me {
    private String name;
    private int age;

    public Me(@Value("${wxh.name}") String name, @Value("${wxh.age}") int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Me{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
