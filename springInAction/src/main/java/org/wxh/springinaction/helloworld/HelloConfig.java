package org.wxh.springinaction.helloworld;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.Date;

/**
 * Created by wangxh on 17-1-3.
 * Package org.wxh.springinaction.helloworld
 * DES:
 */
@Configuration
@ComponentScan
public class HelloConfig {

    @Bean
    public Date dateNow() {return new Date();}

    @Bean
    public IHello helloDate() {
        return new HelloImpl(dateNow());
    }

}
