package Java8.Streams;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

public class IntermediateOpsDemo {
    public static void main(String[] args) {
        //Intermediate Operations transform the stream into another stream
        //They are lazy, meaning they don't execute until a terminal operation is invoked

        List<String> names = List.of("Ram", "Shyam", "Mohan", "Sohan",
                "Ramesh", "Suresh","Anil","Ankit","Ankur","Anshul","Anil","Anil");

        //1. filter : filter out elements based on a condition(takes a predicate)
        Stream<String> filteredStream = names.stream().filter(x -> x.startsWith("A"));

        //2. limit : limit the number of elements in the stream
        Stream<String> limited = filteredStream.limit(5);
        List<Integer> list = Stream.iterate(1, x -> x * 2).limit(10).toList();
        System.out.println(list);

        //3. map : transform each element into another element(takes a function)
        Stream<String> upperCase = limited.map(String::toUpperCase);

        //4. sorted : sort the elements in the stream
        Stream<String> sorted = upperCase.sorted();
        //custom sorting
        Stream<String> sorted1 = sorted.sorted((a, b) -> b.length() - a.length());

        //5. distinct : remove duplicates
        List<String> distinct = names.stream().distinct().toList();
        System.out.println(distinct);

        //6. skip : skip the first n elements
        List<Integer> list2 = Stream.iterate(1, x -> x + 1).skip(10).limit(10).toList();
        System.out.println(list2);

        //7. peek : peek at each element in the stream
        List<String> list7 = List.of("Hello", "World", "Java", "Python", "C++", "C#", "Ruby", "Perl");
        List<String> list8 = list7.stream().peek(System.out::println).toList();

        //8. flatMap : flatten the stream of collections
        List<List<Integer>> list9 = List.of(List.of(1, 2), List.of(3, 4), List.of(5, 6));
        //flatMap : 1,2,3,4,5,6
        List<Integer> flatMap = list9.stream().flatMap(x->x.stream()).toList();

        List<String > sentences = List.of("Hello World", "Good Morning", "Good Night");

        //flatMap : Hello, World, Good, Morning, Good, Night
        List<String> strings = sentences.stream().flatMap(sentence -> Arrays.stream(sentence.split(" ")))
                .map(String::toUpperCase).toList();
        System.out.println(strings);


    }
}



