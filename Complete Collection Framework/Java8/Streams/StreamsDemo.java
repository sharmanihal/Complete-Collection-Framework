package Java8.Streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

//A stream is a sequence of elements that can be processed in a pipeline of operations.
public class StreamsDemo {
    public static void main(String[] args) {
        //What is a stream?
        //A stream help us to process collections of objects in a functional and declarative way
        //Simplify data processing
        //embrace functional programming
        //enable parallel processing

        //How to use a stream?
        //We will have a source of data, intermediate operations and terminal operation
        //Source of data -> collection, array, generator function
        //Intermediate operations -> filter, map, sorted, distinct
        //Terminal operation -> forEach, collect, reduce

        //list is a source of data
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6);
        //intermediate operations
        long count = list.stream().filter(e -> e % 2 == 0).count(); //count : terminal operation
        System.out.println(count);

        //Creating Streams
        //1. From Collections : stream() and parallelStream()
        //2. Arrays : Arrays.stream()
        String[] array= {"a", "b", "c", "d"};
        Arrays.stream(array).forEach(System.out::println);

        //3. Stream.of() : Stream.of("a", "b", "c", "d")
        Stream.of(1,2,3,4,5,6);

        //4. Infinite Streams : Stream.generate()
        Stream<String> generate = Stream.generate(() -> "Hello");// will keep supplying "Hello" infinitely
        //to limit the number of elements
        generate.limit(5).forEach(System.out::println);

        //5. Stream.iterate() : Infinite stream
        Stream.iterate(0,x->x+1); //0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19....
        //Limit the number of elements
        Stream.iterate(0,x->x+1).limit(10).forEach(System.out::println);
    }
}
