package com.example.office_web.utils.annotion;

import java.lang.annotation.*;

@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MethodInfo {

    String name() default "ywk";

    int age() default 18;
}
