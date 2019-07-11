package com.example.office_web.utils.annotion;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class TestAnnotion {

    @MethodInfo(name = "ywksg")
    public void test(){

    }

    public static void main(String[] args){
        try {
            for (Method method : TestAnnotion.class
                    .getClassLoader()
                    .loadClass(("com.example.office_web.utils.annotion.TestAnnotion"))
                    .getMethods()) {
                // checks if MethodInfo annotation is present for the method
                if (method
                        .isAnnotationPresent(MethodInfo.class)) {
                    try {
                        // iterates all the annotations available in the method
                        for (Annotation anno : method.getDeclaredAnnotations()) {
                            System.out.println("Annotation in Method '"
                                    + method + "' : " + anno);
                        }
                        MethodInfo methodAnno = method
                                .getAnnotation(MethodInfo.class);

                        System.out.println(methodAnno.name());
                        System.out.println(methodAnno.age());

                    } catch (Throwable ex) {
                        ex.printStackTrace();
                    }
                }
            }
        } catch (SecurityException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
