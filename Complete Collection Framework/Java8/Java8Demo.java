package Java8;

import com.sun.source.tree.BreakTree;

import java.util.Arrays;
import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;

public class Java8Demo {
    //Streams
    // Java 8 introduced the concept of streams
    // Java 8 -> minimal code, functional programming
    //Java 8 -> Lambda expressions, functional interfaces, streams, default methods, method references, static methods in interfaces
    public static void main(String[] args) {
        //Lambda expressions
        //Lambda expression is an anonymous function (no name, no return type, no access modifier)
        //Lambda expression are used to implement a functional interface

        //Functional programming is a way of storing functions in a variable

        MathOperations sum = (a,b)->a+b;
        MathOperations sub = (a,b)->a-b;
        MathOperations mul = (a,b)->a*b;
        MathOperations div = (a,b)->a/b;

        System.out.println(sum.operate(1,2));


        //Predicate -> Functional Interface (Boolean Valued Function)
        //You are able to store a condition in a variable
        //boolean test(T t);
        Predicate<Integer> isEven = x -> x%2==0;
        System.out.println(isEven.test(4));
        Predicate<String> startingWithA= x->x.startsWith("a");
        System.out.println(startingWithA.test("anikit"));

        //We can also chain predicates
        Predicate<String> endingWithA = x->x.endsWith("a");
        Predicate<String> stringPredicate = startingWithA.and(endingWithA); //both should be true
        Predicate<String> stringPredicate1 = startingWithA.or(endingWithA);//either one of them should yield true
        System.out.println(stringPredicate.test("ankit"));
        System.out.println(stringPredicate1.test("Nikita"));


        //Function -> Functional Interface -> R apply(T t);
        //take an argument , do something on it and return something
        Function<String,String> makeUpperCase = x-> x.toUpperCase();
        System.out.println(makeUpperCase.apply("Jhon"));

        Function<Integer,Integer> doubleTheInteger = x->x*2;
        Function<Integer,Integer> divideBy10=x->x/10;
        Function<Integer, Integer> doubledivide = doubleTheInteger.andThen(divideBy10);

        System.out.println(doubledivide.apply(10));


        //Consumer -> Functional Interface -> void accept(T t);
        Consumer<Integer> consumer= x-> System.out.println(x);

        consumer.accept(26);

        List<Integer> list = List.of(1, 2, 3, 4, 5, 6);
        Consumer<List<Integer>> printArray = x->{
          for (Integer i :x){
              System.out.println(i);
          }
        };
        printArray.accept(list);


        //Supplier -> Functional Interface -> T get();
        Supplier<String> supplier =()-> "Hi";
        System.out.println(supplier.get());

        Supplier<List<Integer>> dummyArrayForTesting = ()->List.of(1,2,3,4,5,6);
        System.out.println(dummyArrayForTesting.get());


        //Combined Example

        Predicate<Integer> predicate = x->x%2==0;
        Function<Integer,Integer> function = x->x*x;
        Consumer<Integer> consumer1 = x-> System.out.println(x);
        Supplier<Integer> supplier1=()->100;

        if(predicate.test(supplier1.get())){
            consumer1.accept(function.apply(supplier1.get()));
        }

        //We also have BiPredicate, BiConsumer, BiFunction
        BiPredicate<String ,String> biPredicate = (x,y)->x.length()==y.length();
        System.out.println(biPredicate.test("Talking","Walking"));

        BiConsumer<String,String> twoMessage= (x,y)-> System.out.println(x+y);
        twoMessage.accept("My name is ","John");

        BiFunction<String,String, Integer> biFunction =(x,y)-> {
            return (x+y).length();
        };
        System.out.println(biFunction.apply("Hi","Tom"));


        //Method Reference -> Use method without invoking & in place of lambda expression
        List<String> students = Arrays.asList("Ram", "Shaym", "Ghanshaym");
        students.forEach(x-> System.out.println(x));
        students.forEach(System.out::println);

        //Constructor Reference
        List<String> mobiles = Arrays.asList("A", "B", "C", "D");
        List<Mobile> collect = mobiles.stream().map(x -> new Mobile(x)).toList();
        List<Mobile> collect1 = mobiles.stream().map(Mobile::new).toList();
    }
}

class Mobile{
    String name;
    Mobile(String name){
        this.name=name;
    }
}

@FunctionalInterface
interface MathOperations{
    int operate(int a ,int b);
}