# Java 8 Collectors

The `Collectors` utility class in Java 8 provides various methods for transforming and gathering stream data into different types of collections. Below is a demonstration of different collectors and how they can be used to manipulate collections in Java.

---

## Code Example

```java
package Java8.Streams;

import java.util.*;
import java.util.stream.Collectors;

public class CollectorsDemo {
    public static void main(String[] args) {
        // Collectors is a utility class that provides implementations of the Collector interface

        // 1. Collection to a list
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        List<String> nameWithA = names.stream().filter(name -> name.startsWith("A")).collect(Collectors.toList());
        System.out.println(nameWithA);  // Output: [Alice]

        // 2. Collection to a set
        List<Integer> list = Arrays.asList(1, 2, 2, 3, 4, 4, 5);
        Set<Integer> unique = list.stream().filter(num -> num >= 2).collect(Collectors.toSet());
        System.out.println(unique);  // Output: [2, 3, 4, 5]

        // 3. Collecting to a specific collection
        ArrayDeque<String> collect = names.stream().collect(Collectors.toCollection(() -> new ArrayDeque<>()));
        LinkedList<String> collect1 = names.stream().collect(Collectors.toCollection(() -> new LinkedList<>()));

        // 4. Joining Strings
        String concatenatedNames = names.stream().map(x -> x.toUpperCase()).collect(Collectors.joining(", "));
        System.out.println(concatenatedNames);  // Output: ALICE, BOB, CHARLIE

        // 5. Summarizing Data (Count, Sum, Min, Average, Max)
        List<Integer> list1 = Arrays.asList(2, 3, 5, 7, 11);
        IntSummaryStatistics stats = list1.stream().collect(Collectors.summarizingInt(x -> x));
        System.out.println(stats.getMax());  // Output: 11
        System.out.println(stats.getMin());  // Output: 2
        System.out.println(stats.getSum());  // Output: 28
        System.out.println(stats.getCount());  // Output: 5
        System.out.println(stats.getAverage());  // Output: 5.6

        // 6. Calculate average
        Double avg = list1.stream().collect(Collectors.averagingInt(x -> x));
        System.out.println(avg);  // Output: 5.6

        // 7. Counting
        long count = list1.stream().collect(Collectors.counting());
        System.out.println(count);  // Output: 5

        // 8. Grouping elements based on length
        List<String> fruits = Arrays.asList("apple", "banana", "mango", "orange", "apple", "banana");
        Map<Integer, List<String>> collect2 = fruits.stream().collect(Collectors.groupingBy(x -> x.length()));
        System.out.println(collect2);  // Output: {5=[apple, mango], 6=[banana, orange], 7=[banana]}

        // Another way to group and perform a joining operation on each group
        Map<Integer, String> collected = fruits.stream().collect(Collectors.groupingBy(x -> x.length(), Collectors.joining(", ")));
        System.out.println(collected);  // Output: {5=apple, mango, 6=banana, orange, 7=banana}

        // Grouping and counting elements
        Map<Integer, Long> collect3 = fruits.stream().collect(Collectors.groupingBy(x -> x.length(), Collectors.counting()));
        System.out.println(collect3);  // Output: {5=2, 6=2, 7=1}

        // 9. Partitioning elements based on a predicate (true or false)
        Map<Boolean, List<String>> lengthMap = fruits.stream().collect(Collectors.partitioningBy(x -> x.length() > 5));
        System.out.println(lengthMap);  // Output: {false=[apple, mango, apple], true=[banana, orange, banana]}

        // 10. toMap: Convert a collection to a map
        // Example: Collection names with length
        List<String> names1 = Arrays.asList("Alice", "Bob", "Charlie", "David", "Edward", "Frank");
        Map<Integer, List<String>> ex1 = names1.stream().collect(Collectors.groupingBy(x -> x.length()));
        System.out.println(ex1);  // Output: {3=[Bob], 5=[Alice], 6=[Charlie, David, Frank], 7=[Edward]}

        // Counting word occurrences in a sentence
        String sentence = "hello world hello java world";
        Map<String, Long> ex2 = Arrays.stream(sentence.split(" ")).collect(Collectors.groupingBy(x -> x, Collectors.counting()));
        System.out.println(ex2);  // Output: {hello=2, world=2, java=1}

        // Partitioning even and odd numbers
        List<Integer> list2 = Arrays.asList(1, 2, 3, 4, 5, 6);
        Map<Boolean, List<Integer>> collect4 = list2.stream().collect(Collectors.partitioningBy(x -> x % 2 == 0));
        System.out.println(collect4);  // Output: {false=[1, 3, 5], true=[2, 4, 6]}

        // Summing values in a map
        Map<String, Integer> items = new HashMap<>();
        items.put("Apples", 10);
        items.put("Banana", 20);
        items.put("Oranges", 15);
        Integer sum = items.values().stream().collect(Collectors.summingInt(x -> x));
        System.out.println(sum);  // Output: 45

        // Create a map from stream elements with length of each string
        List<String> strings = Arrays.asList("Apple", "Banana", "Cherry");
        Map<String, Integer> collect5 = strings.stream().collect(Collectors.toMap(x -> x, x -> x.length()));
        System.out.println(collect5);  // Output: {Apple=5, Banana=6, Cherry=6}

        // Handling duplicates with merge function
        List<String> list3 = Arrays.asList("Apple", "Banana", "Cherry", "Apple", "Banana", "Apple");
        Map<String, Integer> collect6 = list3.stream().collect(Collectors.toMap(k -> k, v -> 1, (x, y) -> x + y));
        System.out.println(collect6);  // Output: {Apple=3, Banana=2, Cherry=1}
    }
}
```

---

## Explanation of Java 8 Stream Collectors

### 1. **Collection to a List** (`Collectors.toList()`)
You can collect elements from a stream into a `List`. This is often used to filter or transform data and collect it into a list.

```java
List<String> nameWithA = names.stream().filter(name -> name.startsWith("A")).collect(Collectors.toList());
```

### 2. **Collection to a Set** (`Collectors.toSet()`)
The `toSet()` collector is used to collect elements into a `Set`, which automatically removes duplicates.

```java
Set<Integer> unique = list.stream().filter(num -> num >= 2).collect(Collectors.toSet());
```

### 3. **Collecting to a Specific Collection** (`Collectors.toCollection()`)
You can collect elements into a specific collection type, such as `ArrayDeque` or `LinkedList`, using this collector.

```java
ArrayDeque<String> collect = names.stream().collect(Collectors.toCollection(() -> new ArrayDeque<>()));
```

### 4. **Joining Strings** (`Collectors.joining()`)
This collector allows you to join strings with an optional separator, prefix, and suffix.

```java
String concatenatedNames = names.stream().map(x -> x.toUpperCase()).collect(Collectors.joining(", "));
```

### 5. **Summarizing Data** (`Collectors.summarizingInt()`)
Generates statistical summaries such as `count`, `sum`, `min`, `average`, and `max` for a given stream of elements.

```java
IntSummaryStatistics stats = list1.stream().collect(Collectors.summarizingInt(x -> x));
```

### 6. **Averaging Values** (`Collectors.averagingInt()`)
Calculates the average of the integer values in the stream.

```java
Double avg = list1.stream().collect(Collectors.averagingInt(x -> x));
```

### 7. **Counting Elements** (`Collectors.counting()`)
Counts the number of elements in the stream.

```java
long count = list1.stream().collect(Collectors.counting());
```

### 8. **Grouping Elements** (`Collectors.groupingBy()`)
Groups the stream elements by a classifier function. It can be combined with other collectors like `joining()` and `counting()` for more complex operations.

```java
Map<Integer, List<String>> collect2 = fruits.stream().collect(Collectors.groupingBy(x -> x.length()));
```

### 9. **Partitioning Elements** (`Collectors.partitioningBy()`)
Partitions the stream into two groups based on a predicate.

```java
Map<Boolean, List<String>> lengthMap = fruits.stream().collect(Collectors.partitioningBy(x -> x.length() > 5));
```

### 10. **Converting to a Map** (`Collectors.toMap()`)
This collector transforms the stream into a `Map` where each element is a key

-value pair.

```java
Map<String, Integer> collect5 = strings.stream().collect(Collectors.toMap(x -> x, x -> x.length()));
```

### 11. **Handling Duplicates in a Map** (`(x, y) -> x + y`)
When the keys are duplicated, you can specify a merge function to combine values.

```java
Map<String, Integer> collect6 = list3.stream().collect(Collectors.toMap(k -> k, v -> 1, (x, y) -> x + y));
```

--- 

These are just a few examples of the powerful `Collectors` class and how it can help you work with streams more efficiently in Java 8.
