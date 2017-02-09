package org.wxh.springinaction.helloworld;

import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by wangxh on 17-1-3.
 * Package org.wxh.springinaction.helloworld
 * DES:
 */
public class HelloImpl implements IHello {

    private Date date;

    public HelloImpl() {
    }

    public HelloImpl(Date date) {
        this.date = date;
    }

    public void sayHello() {
        System.out.println("hello world");
    }

    public void sayTime() {
        System.out.println("now is " + date);
    }
}
