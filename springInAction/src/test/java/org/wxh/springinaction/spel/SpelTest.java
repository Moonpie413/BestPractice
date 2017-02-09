package org.wxh.springinaction.spel;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by wangxh on 17-1-4.
 * Package org.wxh.springinaction.spel
 * DES:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ComponentScan
@ContextConfiguration(classes = SpelConfig.class)
public class SpelTest {

    @Autowired
    private Me me;

    @Test
    public void testMe() {
        System.out.println(me);
    }

}
