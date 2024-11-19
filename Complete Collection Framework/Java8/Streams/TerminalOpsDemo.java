package Java8.Streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TerminalOpsDemo {
    public static void main(String[] args) {
        //Terminal Operations are the final operations that are performed on a stream
        //Get the result of the stream

        //Stream once consumed, can't be reused i.e., once a terminal operation is performed, the stream is closed

        List<Integer> list = Arrays.asList(1, 2, 3, 4);

        //1. collect : collect the elements of the stream into a collection
        Set<Integer> collect = list.stream().skip(1).collect(Collectors.toSet());
        //Collectors.toList(), Collectors.toSet(), Collectors.toMap() etc

        //2. forEach : perform an action on each element of the stream
        list.stream().forEach(x->System.out.println(x));

        //2.1 forEachOrdered : forEachOrdered is used to perform an action on each element of the stream in the order of the stream
        List<Integer> list1 = List.of(23, 6, 34, 12, 5);
        //forEachOrdered is mainly used in parallel streams
        list1.parallelStream().forEachOrdered(x->System.out.println(x));

        //3. reduce : Combine the elements of the stream to a single value
        Optional<Integer> reduce = list.stream().reduce((a, b) -> a + b);
        System.out.println(reduce.get());

        List<String> strings = List.of("Hi", " Hello", " How", " Are", " You");
        Optional<String> reduce1 = strings.stream().reduce((x, y) -> x + y);
        System.out.println(reduce1.get());

        //4. count : count the number of elements in the stream
        long count = list.stream().count();


        //Below are short-circuiting terminal operations

        //5. anyMatch : check if any element in the stream matches the given predicate
        boolean hello = strings.stream().anyMatch(x -> x.equals(" Hello"));
        System.out.println(hello);

        //6. allMatch : check if all elements in the stream match the given predicate
        List<Integer> evenList = List.of(2, 4, 6, 8);
        boolean b = evenList.stream().allMatch(x -> x % 2 == 0);
        System.out.println(b); //if all elements are even, then true

        //7. noneMatch : check if no element in the stream matches the given predicate
        boolean b1 = evenList.stream().noneMatch(x -> x % 2 != 0);
        System.out.println(b1); //if no element is odd, then true

        //8. findFirst : find the first element in the stream
        Optional<Integer> first = list.stream().findFirst();
        System.out.println(first.get());

        //9. findAny : find any element in the stream
        Optional<Integer> any = list.stream().findAny();
        System.out.println(any.get());

        //10. toArray : convert stream to array
        Object[] array = Stream.of(1,2,3,4,5,6,7).toArray();

        //11. min and max : find the minimum and maximum element in the stream
        System.out.println("Max "+Stream.of(2,5,12,56,1,3).max(Comparator.naturalOrder()));
        System.out.println("Min "+Stream.of(2,5,12,56,1,3).min((a,c)->a-c));

        //Examples
        List<String> names = Arrays.asList("Anna", "Bob", "Alice", "John", "Alice", "Alice");
        names.stream().filter(x->x.length()>3).forEach(System.out::println);

        //Squaring and summing the elements of the list
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(numbers.stream().map(x->x*x).sorted((x,y)->x-y).toList());

        //Summing all values
        List<Integer> integers = List.of(2, 5, 7, 8, 9, 12);
        System.out.println(integers.stream().reduce((x,y)->x+y).get());

        //Counting occurrence of characters
        String sentence ="Hello world";
        long count1 = sentence.chars().filter(x -> x=='l').count();
        System.out.println(count1);

        //Stateful and Stateless Operations
        //Stateful operations, know about the state of other elements in the stream like sorted, distinct
        //Stateless operations, don't know about the state of other elements like filter, map

    }
}
