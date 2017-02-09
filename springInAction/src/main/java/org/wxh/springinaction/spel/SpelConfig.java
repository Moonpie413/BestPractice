package org.wxh.springinaction.spel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

/**
 * Created by wangxh on 17-1-4.
 * Package org.wxh.springinaction.spel
 * DES:
 */
@Configuration
@ComponentScan
@PropertySource(value = "classpath:props/myprops.properties")
public class SpelConfig {

    @Bean
    public PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
