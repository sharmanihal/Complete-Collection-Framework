# Java 8 Stream Intermediate Operations

In Java 8, intermediate operations allow you to transform a stream into another stream. These operations are lazy, meaning they are not executed until a terminal operation is invoked. Below is an example demonstrating the various intermediate operations you can use in streams.

---

## Code Example

```java
package Java8.Streams;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

public class IntermediateOpsDemo {
    public static void main(String[] args) {
        // Intermediate Operations transform the stream into another stream
        // They are lazy, meaning they don't execute until a terminal operation is invoked

        List<String> names = List.of("Ram", "Shyam", "Mohan", "Sohan",
                "Ramesh", "Suresh", "Anil", "Ankit", "Ankur", "Anshul", "Anil", "Anil");

        // 1. filter: filter out elements based on a condition (takes a predicate)
        Stream<String> filteredStream = names.stream().filter(x -> x.startsWith("A"));

        // 2. limit: limit the number of elements in the stream
        Stream<String> limited = filteredStream.limit(5);
        List<Integer> list = Stream.iterate(1, x -> x * 2).limit(10).toList();
        System.out.println(list);  // Output: [1, 2, 4, 8, 16, 32, 64, 128, 256, 512]

        // 3. map: transform each element into another element (takes a function)
        Stream<String> upperCase = limited.map(String::toUpperCase);

        // 4. sorted: sort the elements in the stream
        Stream<String> sorted = upperCase.sorted();
        // custom sorting
        Stream<String> sorted1 = sorted.sorted((a, b) -> b.length() - a.length());

        // 5. distinct: remove duplicates
        List<String> distinct = names.stream().distinct().toList();
        System.out.println(distinct);  // Output: [Ram, Shyam, Mohan, Sohan, Ramesh, Suresh, Anil, Ankit, Ankur, Anshul]

        // 6. skip: skip the first n elements
        List<Integer> list2 = Stream.iterate(1, x -> x + 1).skip(10).limit(10).toList();
        System.out.println(list2);  // Output: [11, 12, 13, 14, 15, 16, 17, 18, 19, 20]

        // 7. peek: peek at each element in the stream (useful for debugging)
        List<String> list7 = List.of("Hello", "World", "Java", "Python", "C++", "C#", "Ruby", "Perl");
        List<String> list8 = list7.stream().peek(System.out::println).toList();  // Prints each element

        // 8. flatMap: flatten the stream of collections
        List<List<Integer>> list9 = List.of(List.of(1, 2), List.of(3, 4), List.of(5, 6));
        // flatMap: 1, 2, 3, 4, 5, 6
        List<Integer> flatMap = list9.stream().flatMap(x -> x.stream()).toList();
        System.out.println(flatMap);  // Output: [1, 2, 3, 4, 5, 6]

        // flatMap with sentences: Hello, World, Good, Morning, Good, Night
        List<String> sentences = List.of("Hello World", "Good Morning", "Good Night");
        List<String> strings = sentences.stream().flatMap(sentence -> Arrays.stream(sentence.split(" ")))
                .map(String::toUpperCase).toList();
        System.out.println(strings);  // Output: [HELLO, WORLD, GOOD, MORNING, GOOD, NIGHT]
    }
}
```

---

## Explanation of Intermediate Stream Operations

### 1. **filter**: Filters elements based on a predicate.
The `filter` operation allows you to keep only elements that satisfy a given condition.

```java
Stream<String> filteredStream = names.stream().filter(x -> x.startsWith("A"));
```

### 2. **limit**: Limits the number of elements in the stream.
The `limit` operation restricts the stream to a given number of elements.

```java
Stream<String> limited = filteredStream.limit(5);
```

### 3. **map**: Transforms each element into another element.
The `map` operation applies a function to each element in the stream and returns a new stream with the transformed elements.

```java
Stream<String> upperCase = limited.map(String::toUpperCase);
```

### 4. **sorted**: Sorts the elements in the stream.
The `sorted` operation sorts the elements in their natural order, and you can also provide a custom comparator for custom sorting.

```java
Stream<String> sorted = upperCase.sorted();
Stream<String> sorted1 = sorted.sorted((a, b) -> b.length() - a.length());
```

### 5. **distinct**: Removes duplicate elements.
The `distinct` operation filters out duplicate elements from the stream.

```java
List<String> distinct = names.stream().distinct().toList();
```

### 6. **skip**: Skips the first n elements.
The `skip` operation skips the first `n` elements of the stream and returns the remaining elements.

```java
List<Integer> list2 = Stream.iterate(1, x -> x + 1).skip(10).limit(10).toList();
```

### 7. **peek**: Allows you to inspect each element in the stream without modifying the stream.
The `peek` operation is mainly used for debugging, as it performs an action for each element without modifying the stream.

```java
List<String> list7 = list7.stream().peek(System.out::println).toList();  // Prints each element
```

### 8. **flatMap**: Flattens a stream of collections into a single stream.
The `flatMap` operation allows you to flatten a stream of collections into a single stream of elements.

```java
List<List<Integer>> list9 = List.of(List.of(1, 2), List.of(3, 4), List.of(5, 6));
List<Integer> flatMap = list9.stream().flatMap(x -> x.stream()).toList();
```

---

These intermediate operations are powerful tools for transforming data in Java streams. By chaining multiple operations together, you can create complex data processing pipelines that are efficient and readable.
