package com.example.office_web.utils.landa;

import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

//https://www.cnblogs.com/gc65/p/10604616.html大接口
//Java8中的lambda表达式,并不是完全闭包，lambda表达式对值封闭，不对变量封闭。简单点来说就是局部变量在lambda表达式中如果要使用，必须是声明final类型或者是隐式的final例如
public class landaTest {

    /*
        该方法第二个参数接受一个function类型的行为,然后调用apply，对a执行这段行为
    */
    public static int oper(int a, Function<Integer,Integer > action){
        return action.apply(a);
    }


    /**
     * BiFunction 这个前两个泛型代表形参类型，最后一个是返回值的类型
     * @param a
     * @param action
     * @return
     */
    public static String oper1(int a, BiFunction<Integer,Integer ,String > action){
        return action.apply(a, a);
    }


    public  static void main(String[] args){
         final int c = 0;

        // 类型声明
        MathOperation addition = (int a, int b) -> {
            int d = c;
            a++;
            return a + b;
        };
        System.out.println(addition.operation(1, 2));

        Predicate<Integer> predOdd = integer -> integer % 2 == 1;
        System.out.println(predOdd.test(5));

        System.out.println(oper(5, (x) -> ++x));

        System.out.println(oper1(5, (x,y) -> {Integer a = x+y;return a+"";}));




        Test1 test = new Test1();
        test.setId("111");

        //这里是无参，所以左边使用了()
        Supplier<String> sup = () -> test.getId();
        System.out.println(sup.get());
        //这里对lambda表达式进行了省略。() -> user.getAge() == user::getAge
        Supplier<String> sup2 = test::getId;
        System.out.println(sup2.get());

        Test1 test1 = new Test1();
        test1.setName("ywk");
        Supplier<Test1> sup3 = () -> test1;
        System.out.println(sup3.get().getName()+"999999");


        //静态方法引用
        Supplier<String> sup4= () -> Test1.doHome("testYwk");//这里就是相当于把testYwk放到doHome里了，就是这个sup4的doHome方法体里就是testYwk了，不再是变量
        System.out.println(sup4.get());


    }




}
