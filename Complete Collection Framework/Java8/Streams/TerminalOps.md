# Java 8 Streams - Terminal Operations

Terminal operations in Java Streams are the final operations that produce a result or a side effect. Once a terminal operation is invoked on a stream, the stream is consumed and can no longer be used again. These operations can either return a result (e.g., count, collect) or perform an action on each element (e.g., forEach, forEachOrdered).

---

## Code Example

```java
package Java8.Streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TerminalOpsDemo {
    public static void main(String[] args) {
        // Terminal Operations are the final operations that are performed on a stream
        // Once consumed, the stream can't be reused i.e., once a terminal operation is performed, the stream is closed.

        List<Integer> list = Arrays.asList(1, 2, 3, 4);

        // 1. collect: Collect elements of the stream into a collection (e.g., List, Set, Map)
        Set<Integer> collect = list.stream().skip(1).collect(Collectors.toSet());
        System.out.println(collect); // Output: [2, 3, 4]

        // 2. forEach: Perform an action on each element of the stream
        list.stream().forEach(x -> System.out.println(x)); // Prints: 1 2 3 4

        // 2.1 forEachOrdered: Perform an action in the encounter order (mainly used in parallel streams)
        List<Integer> list1 = List.of(23, 6, 34, 12, 5);
        list1.parallelStream().forEachOrdered(x -> System.out.println(x)); // Prints elements in order

        // 3. reduce: Combine elements of the stream to a single value
        Optional<Integer> reduce = list.stream().reduce((a, b) -> a + b);
        System.out.println(reduce.get()); // Output: 10 (1+2+3+4)

        List<String> strings = List.of("Hi", " Hello", " How", " Are", " You");
        Optional<String> reduce1 = strings.stream().reduce((x, y) -> x + y);
        System.out.println(reduce1.get()); // Output: "Hi Hello How Are You"

        // 4. count: Count the number of elements in the stream
        long count = list.stream().count();
        System.out.println(count); // Output: 4

        // Short-circuiting terminal operations:

        // 5. anyMatch: Check if any element matches the given predicate
        boolean hello = strings.stream().anyMatch(x -> x.equals(" Hello"));
        System.out.println(hello); // Output: true

        // 6. allMatch: Check if all elements match the given predicate
        List<Integer> evenList = List.of(2, 4, 6, 8);
        boolean b = evenList.stream().allMatch(x -> x % 2 == 0);
        System.out.println(b); // Output: true

        // 7. noneMatch: Check if no element matches the given predicate
        boolean b1 = evenList.stream().noneMatch(x -> x % 2 != 0);
        System.out.println(b1); // Output: true

        // 8. findFirst: Find the first element in the stream
        Optional<Integer> first = list.stream().findFirst();
        System.out.println(first.get()); // Output: 1

        // 9. findAny: Find any element in the stream
        Optional<Integer> any = list.stream().findAny();
        System.out.println(any.get()); // Output: 1 (may vary)

        // 10. toArray: Convert stream to array
        Object[] array = Stream.of(1, 2, 3, 4, 5, 6, 7).toArray();
        System.out.println(Arrays.toString(array)); // Output: [1, 2, 3, 4, 5, 6, 7]

        // 11. min and max: Find the minimum and maximum element in the stream
        System.out.println("Max: " + Stream.of(2, 5, 12, 56, 1, 3).max(Comparator.naturalOrder()).get()); // Output: 56
        System.out.println("Min: " + Stream.of(2, 5, 12, 56, 1, 3).min((a, c) -> a - c).get()); // Output: 1

        // Examples of using stream operations:
        List<String> names = Arrays.asList("Anna", "Bob", "Alice", "John", "Alice", "Alice");
        names.stream().filter(x -> x.length() > 3).forEach(System.out::println); // Output: Anna, Alice, Alice, Alice

        // Squaring and sorting the elements of the list
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(numbers.stream().map(x -> x * x).sorted((x, y) -> x - y).toList()); // Output: [1, 4, 9, 16, 25]

        // Summing all values using reduce
        List<Integer> integers = List.of(2, 5, 7, 8, 9, 12);
        System.out.println(integers.stream().reduce((x, y) -> x + y).get()); // Output: 43

        // Counting occurrences of a character in a string
        String sentence = "Hello world";
        long count1 = sentence.chars().filter(x -> x == 'l').count();
        System.out.println(count1); // Output: 3

        // Stateful vs Stateless Operations:
        // - Stateful operations: Require knowledge of the state of other elements (e.g., sorted, distinct).
        // - Stateless operations: Do not require knowledge of the state of other elements (e.g., filter, map).
    }
}
```

---

## Key Concepts and Features

### **Terminal Operations:**
- **Terminal operations** are operations that produce a result or perform a side-effect and mark the end of the stream pipeline. Once a terminal operation is invoked, the stream is consumed and can no longer be used.
- Examples include operations like `collect()`, `forEach()`, `reduce()`, `count()`, and `findFirst()`.

### **Short-circuiting Terminal Operations:**
These operations can complete without having to process the entire stream:
- **anyMatch()**: Returns `true` if any element matches the given predicate.
- **allMatch()**: Returns `true` if all elements match the given predicate.
- **noneMatch()**: Returns `true` if no elements match the given predicate.
- **findFirst()**: Returns the first element in the stream (if present).
- **findAny()**: Returns any element in the stream (it may be any, not necessarily the first).

### **Other Terminal Operations:**
- **collect()**: Collects the elements of the stream into a collection such as a list, set, or map.
- **forEach()**: Performs an action on each element of the stream.
- **reduce()**: Reduces the elements to a single value by repeatedly applying a binary operator.
- **toArray()**: Converts the stream into an array.
- **min() / max()**: Finds the minimum or maximum element in the stream.
- **count()**: Counts the number of elements in the stream.

### **Stateful vs Stateless Operations:**
- **Stateful operations** require knowledge about the state of other elements in the stream (e.g., `sorted()`, `distinct()`).
- **Stateless operations** do not depend on the state of other elements (e.g., `filter()`, `map()`).

---

## Conclusion

Terminal operations in Java Streams allow us to perform actions that return a result or cause a side effect, such as collecting, reducing, or finding specific elements. Understanding when and how to use these operations can significantly improve the performance and readability of data processing tasks.
