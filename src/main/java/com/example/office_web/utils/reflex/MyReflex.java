package com.example.office_web.utils.reflex;

import sun.rmi.runtime.Log;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;


//连接https://www.jianshu.com/p/9be58ee20dee
public class MyReflex {

    public static void main(String[] args){
        reflectNewInstance();
        reflectPrivateConstructor();
        reflectPrivateMethod();
        reflectPrivateField();
        getSupperClass();
    }



    // 创建对象
    public static void reflectNewInstance() {
        try {
            Class<?> classBook = Class.forName("com.example.office_web.utils.reflex.Book");
            Object objectBook = classBook.newInstance();//这个是默认调用无参数构造方法
            Book book = (Book) objectBook;
            book.setName("Android进阶之光");
            System.out.println(book.getName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }



    // 反射私有的构造方法
    public static void reflectPrivateConstructor() {
        try {
            Class<?> classBook = Class.forName("com.example.office_web.utils.reflex.Book");
            Constructor<?> declaredConstructorBook = classBook.getDeclaredConstructor(String.class,String.class);
            declaredConstructorBook.setAccessible(true);
            Object objectBook = declaredConstructorBook.newInstance("Android开发艺术探索","任玉刚");
            Book book = (Book) objectBook;
            System.out.println(book.getName());

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }



    // 反射私有方法
    public static void reflectPrivateMethod() {
        try {
            Class<?> classBook = Class.forName("com.example.office_web.utils.reflex.Book");
            Method methodBook = classBook.getDeclaredMethod("test", int.class);
            methodBook.setAccessible(true);
            Object objectBook = classBook.newInstance();
            int ii = (int) methodBook.invoke(objectBook,0);
            System.out.println(ii);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    // 反射私有属性
    public static void reflectPrivateField() {
        try {
            Class<?> classBook = Class.forName("com.example.office_web.utils.reflex.Book");
            Object objectBook = classBook.newInstance();
            Field fieldTag = classBook.getDeclaredField("name");
            ((Book)objectBook).setName("uuuu");
            fieldTag.setAccessible(true);
            String tag = (String) fieldTag.get(objectBook);
            System.out.println(tag);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    // 反射私有属性
    public static void getSupperClass() {
        try {
            Class<?> classBook = Class.forName("com.example.office_web.utils.reflex.Book");
            System.out.println(classBook.getSuperclass());
            System.out.println(classBook.getInterfaces().length);
            System.out.println(classBook.getInterfaces()[0]);

            Book ob = (Book) classBook.newInstance();
            System.out.println(ob.getClass().getInterfaces()[0]);//Class 因为没重写toString，所以输出地址

            List list = new ArrayList();
            list.add("a");
            System.out.println(list);//list输出[‘a’]这种，是因为list重写了toString的方法
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
