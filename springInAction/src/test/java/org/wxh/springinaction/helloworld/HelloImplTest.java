package org.wxh.springinaction.helloworld;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

/**
 * Created by wangxh on 17-1-3.
 * Package org.wxh.springinaction.helloworld
 * DES:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class HelloImplTest {

    @Autowired
    private IHello hello;

    @Test
    public void sayHello() throws Exception {
        hello.sayHello();
        hello.sayTime();
    }

}