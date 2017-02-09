package spittr.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by wangxh on 17-1-5.
 * Package spittr.config
 * DES:
 */
@Configuration
@ComponentScan(basePackages = "spittr",
    excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class)
    })
/**
 * 除了MVC的部分的配置
 */
public class RootConfig {
}
