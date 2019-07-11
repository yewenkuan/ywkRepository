package com.example.office_web.utils.landa;

import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


//菜鸟教程：https://www.runoob.com/java/java8-streams.html


public class StreamTest {

    public static void main(String[] args){
        List<String> list = Arrays.asList("a","b","","d");
        List<String> fiterList = list.stream().filter((x) -> {return StringUtils.isNotBlank(x);}).collect(Collectors.toList());
        System.out.println(fiterList);


       // map 方法用于映射每个元素到对应的结果，以下代码片段使用 map 输出了元素对应的平方数：

        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        // 获取对应的平方数,lanbda中，如果只有一个语句，则不用写{}，写了{}一定要写return语句
        //distinct()对结果去重
        List<Integer> squaresList = numbers.stream().map( i -> i*i).distinct().collect(Collectors.toList());
        System.out.println(squaresList);




       // Collectors 类实现了很多归约操作，例如将流转换成集合和聚合元素。Collectors 可用于返回列表或字符串：

        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");

        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        System.out.println("筛选列表: " + filtered);

        String mergedString = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
        System.out.println("合并字符串: " + mergedString);

        List<String> stringSquaresList = numbers.stream().map( i -> i*i+"hhh").distinct().collect(Collectors.toList());//这个map是可以映射成任意类型结果
        System.out.println(stringSquaresList);


        /**
         * 流转换为数值流
         mapToInt(T -> int) : return IntStream
         mapToDouble(T -> double) : return DoubleStream
         mapToLong(T -> long) : return LongStream
         */
        List<Integer> intList = Arrays.asList(1, 2);//调用转换数值流的方法，数据的类型一定要对应上
        IntStream intStream = intList.stream().mapToInt(x ->x);
        IntSummaryStatistics stats =  intStream.summaryStatistics();
        System.out.println("列表中最大的数 : " + stats.getMax());
        System.out.println("列表中最小的数 : " + stats.getMin());
        System.out.println("所有数之和 : " + stats.getSum());
        System.out.println("平均数 : " + stats.getAverage());


        System.out.println("=====================");

        List<Integer> intList1 = Arrays.asList(1, 2);//调用转换数值流的方法，数据的类型一定要对应上
        IntStream intStream1 = intList1.stream().mapToInt(Test1::getAge);// 这种只能用一个参数的（不能多也不能少，一定要有一个形参接受，就和lanbda表达式的x ->x一样，有x这样一个参数），相当于list的每个元素都充当值传到getAge的形参里面
        IntSummaryStatistics stats1 =  intStream1.summaryStatistics();
        System.out.println("列表中最大的数 : " + stats1.getMax());
        System.out.println("列表中最小的数 : " + stats1.getMin());
        System.out.println("所有数之和 : " + stats1.getSum());
        System.out.println("平均数 : " + stats1.getAverage());


        List<Test1> numberList = new ArrayList<>();
        Test1 t = new Test1();
        t.setNumber(5);
        numberList.add(t);
        Test1 t2 = new Test1();
        t2.setNumber(6);
        numberList.add(t2);

        int sum = numberList.stream().mapToInt(ob -> ob.getNumber()).sum();
        System.out.println(sum);


        List<String> strList = new ArrayList<>();
        strList.add("hello");
        strList.add("word");
        List<String[]> array = strList.stream().map(word -> word.split("")).collect(Collectors.toList());
        System.out.println(array);

        List<String> strings2 = strList.stream().flatMap(word -> Arrays.stream(word.split(""))).distinct().collect(Collectors.toList());//这给flatmap里面一个元素生成多个元素，然后又想让这多个元素处于同一个层级时，就用flatmap
        System.out.println(strings2);

        System.out.println("=====输出=====");
        strList.forEach(s -> doSoming(s));

    }

    public static void doSoming(String p){
        System.out.println(p);
    }






}
