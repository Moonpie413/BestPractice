package org.wxh.bestpractice.ThinkingInJava.practice1.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by wangxh on 16-11-16.
 * package org.wxh.bestpractice.ThinkingInJava.practice1
 * des
 */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface IntegerSQL {
    int value() default 0;
    String name() default "";
    Constraints constraints() default @Constraints;
}
