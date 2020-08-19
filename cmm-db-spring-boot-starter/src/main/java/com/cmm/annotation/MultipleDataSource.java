package com.cmm.annotation;

import com.cmm.common.ComConstant;

import java.lang.annotation.*;

@Documented
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MultipleDataSource {

    String db() default ComConstant.WRITE;

    String field() default "";

    String rule() default ComConstant.MD1;
}
