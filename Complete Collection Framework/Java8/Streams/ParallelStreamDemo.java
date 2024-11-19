package Java8.Streams;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class ParallelStreamDemo {
    public static void main(String[] args) {
        //Parallel Streams are a type of stream that can be used to process large amounts of data in parallel
        //Allows multiple threads to process parts of the stream simultaneously
        //This can significantly improve the performance fot large data sets

        //without parallel stream
        long start = System.currentTimeMillis();
        List<Integer> list = Stream.iterate(1, x -> x + 1).limit(20000).toList();
        List<Integer> list1 = list.stream().map(ParallelStreamDemo::factorial).toList();
        long end = System.currentTimeMillis();
        System.out.println("Time taken : " + (end - start) + "ms");
        //Time taken : 210ms

        //Lets use parallel stream
        long startTime = System.currentTimeMillis();
        List<Integer> list2 = list.parallelStream().map(ParallelStreamDemo::factorial).toList();
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken : " + (endTime - startTime) + "ms");
        //Time taken : 50ms

        //Parallel streams are useful when we have a large amount of data to process and independent operations
        //Independent operations are those that do not depend on the result of other operations.
        //They may add overhead when used with small data sets or operations that are not independent


        //Cummalative Sum
        List<Integer> list3 = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        //without parallel stream(correct answer)
        AtomicInteger sum= new AtomicInteger();
        List<Integer> list4 = list3.stream().map(sum::addAndGet).toList();
        System.out.println(list4);

        //with parallel stream (wrong answer)
        AtomicInteger sum1= new AtomicInteger();
        List<Integer> list5 = list3.parallelStream().map(sum1::addAndGet).toList();
        System.out.println(list5);

        //We can also make the parallel stream sequential by using sequential() method
        List<Integer> list6 = list.parallelStream().map(ParallelStreamDemo::factorial).sequential().toList();
        System.out.println(list6);
    }




    public static int factorial(int num) {
        int fact = 1;
        for (int i = 2; i <= num; i++) {
            fact *= i;
        }
        return fact;
    }
}
