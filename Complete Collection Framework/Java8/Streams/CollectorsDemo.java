package Java8.Streams;

import java.util.*;
import java.util.stream.Collectors;

public class CollectorsDemo {
    public static void main(String[] args) {
        //Collectors is a utility class that provides implementations of the Collector interface

        //provides a set of methods to create common collectors

        //1. Collection to a list
        List<String > names= Arrays.asList("Alice","Bob","Charlie");
        List<String> nameWithA = names.stream().filter(name -> name.startsWith("A")).collect(Collectors.toList());

        System.out.println(nameWithA);

        //2. Collection to a set
        List<Integer> list = Arrays.asList(1, 2, 2, 3, 4, 4, 5);
        Set<Integer> unique = list.stream().filter(num->num>=2).collect(Collectors.toSet());
        System.out.println(unique);

        //3. Collecting to a specific collection
        ArrayDeque<String> collect = names.stream().collect(Collectors.toCollection(() -> new ArrayDeque<>()));
        LinkedList<String> collect1 = names.stream().collect(Collectors.toCollection(() -> new LinkedList<>()));


        //4. Joining Strings
        String concatenatedNames= names.stream().map(x->x.toUpperCase()).collect(Collectors.joining(", "));
        System.out.println(concatenatedNames);

        //5. Summarizing Data
        //Generates statistical summary (count , sum, min, average, max)
        List<Integer> list1 = Arrays.asList(2, 3, 5, 7, 11);
        IntSummaryStatistics stats = list1.stream().collect(Collectors.summarizingInt(x -> x));
        System.out.println(stats.getMax());
        System.out.println(stats.getMin());
        System.out.println(stats.getSum());
        System.out.println(stats.getCount());
        System.out.println(stats.getAverage());

        //6. Calculate average
        Double avg = list1.stream().collect(Collectors.averagingInt(x -> x));
        System.out.println(avg);

        //7. Counting
        long count = list1.stream().collect(Collectors.counting());
        System.out.println(count);

        //8. Grouping elements based on length
        List<String> fruits = Arrays.asList("apple", "banana", "mango", "orange", "apple", "banana");
        Map<Integer, List<String>> collect2 = fruits.stream().collect(Collectors.groupingBy(x -> x.length()));
        System.out.println( collect2);

        //one more way : Collect based on specific criteria and do you want to do some operation on each group
        Map<Integer, String> collected = fruits.stream().collect(Collectors.groupingBy(x -> x.length(), Collectors.joining(", ")));
        System.out.println(collected);

        Map<Integer, Long> collect3 = fruits.stream().collect(Collectors.groupingBy(x -> x.length(), Collectors.counting()));
        System.out.println(collect3);

        //9. Partitioning elements based on a predicate (true or false)
        // All fruits with length > 5 in one group and rest in another group
        Map<Boolean, List<String>> lengthMap = fruits.stream().collect(Collectors.partitioningBy(x -> x.length() > 5));
        System.out.println(lengthMap);

        //10. toMap : Convert a collection to a map
//        Map<String, Integer> fruitMap = fruits.stream().collect(Collectors.toMap(x -> x, x -> x.length()));

        //Example : Collection names with length
        List<String> names1 = Arrays.asList("Alice", "Bob", "Charlie", "David", "Edward", "Frank");
        Map<Integer, List<String>> ex1 = names1.stream().collect(Collectors.groupingBy(x -> x.length()));
        System.out.println(ex1);

        //Counting word occurances
        String sentence = "hello world hello java world";
        Map<String, Long> ex2 = Arrays.stream(sentence.split(" ")).collect(Collectors.groupingBy(x -> x, Collectors.counting()));
        System.out.println(ex2);

        //Partitioning even and odd numbers
        List<Integer> list2 = Arrays.asList(1, 2, 3, 4, 5, 6);
        Map<Boolean, List<Integer>> collect4 = list2.stream().collect(Collectors.partitioningBy(x -> x % 2 == 0));
        System.out.println(collect4);

        //Summing values in a map
        Map<String,Integer> items= new HashMap<>();
        items.put("Apples",10);
        items.put("Banana",20);
        items.put("Oranges",15);
        Integer sum = items.values().stream().collect(Collectors.summingInt(x -> x));
        System.out.println(sum);

        //create a map from stream elements
        List<String> strings = Arrays.asList("Apple", "Banana", "Cherry");
        Map<String, Integer> collect5 = strings.stream().collect(Collectors.toMap(x -> x, x->x.length()));
        System.out.println(collect5);

        //How map times a work occurs in a list

        //to map with merge (x,y)->x+y , if key is duplicate, then merge the values (x is previous value, y is current value) add them

        List<String> list3 = Arrays.asList("Apple", "Banana", "Cherry", "Apple", "Banana", "Apple");
        Map<String, Integer> collect6 = list3.stream().collect(Collectors.toMap(k -> k, v -> 1,(x,y)->x+y));
        System.out.println(collect6);
    }

}


