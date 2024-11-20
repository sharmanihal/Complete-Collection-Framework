# Java 8 Streams Overview

Streams in Java provide a powerful way to process collections of data in a functional and declarative style. The main advantage of streams is their ability to allow complex data processing without the need for explicit loops, and they support operations that can be executed in parallel, enabling better performance with large datasets.

---

## Code Example

```java
package Java8.Streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamsDemo {
    public static void main(String[] args) {
        // What is a stream?
        // A stream helps us process collections of objects in a functional and declarative way
        // Simplifies data processing, embraces functional programming, and enables parallel processing.

        // Stream Pipeline:
        // Source -> Intermediate Operations -> Terminal Operation

        // Data Source: A list in this case
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6);

        // Intermediate operation: filter, terminal operation: count
        long count = list.stream().filter(e -> e % 2 == 0).count(); // count: terminal operation
        System.out.println("Count of even numbers: " + count);

        // Creating Streams:

        // 1. From Collections: stream() and parallelStream()
        // Example: stream() - for sequential stream, parallelStream() - for parallel processing

        // 2. From Arrays: Arrays.stream()
        String[] array = {"a", "b", "c", "d"};
        Arrays.stream(array).forEach(System.out::println); // Prints each element of the array

        // 3. Using Stream.of() for creating a stream from multiple elements
        Stream.of(1, 2, 3, 4, 5, 6).forEach(System.out::println); // Prints each number

        // 4. Infinite Streams using Stream.generate()
        Stream<String> generate = Stream.generate(() -> "Hello"); // Infinite stream of "Hello"
        // Limit the stream to 5 elements and print
        generate.limit(5).forEach(System.out::println); // Prints "Hello" five times

        // 5. Infinite Streams using Stream.iterate()
        // Creating an infinite stream that generates numbers: 0, 1, 2, 3, ...
        Stream.iterate(0, x -> x + 1).limit(10).forEach(System.out::println); // Prints numbers 0 to 9
    }
}
```

---

## Key Concepts and Features

### **What is a Stream?**
- A **stream** is a sequence of elements that can be processed in a pipeline of operations.
- It allows you to process data in a functional and declarative way, which means you can write code that focuses on what needs to be done rather than how to do it (e.g., avoiding explicit loops).

### **How Streams Work**

- **Source of data:** Streams can be generated from collections, arrays, or other data sources like `Stream.generate()` or `Stream.iterate()`.
- **Intermediate operations:** These are operations that transform the stream into another stream (e.g., `filter`, `map`, `sorted`, `distinct`).
- **Terminal operations:** These operations trigger the processing of the stream and produce a result or a side-effect (e.g., `forEach`, `collect`, `reduce`).

### **Creating Streams**

1. **From Collections:**
   You can create a stream from a collection (e.g., `List`, `Set`) using the `stream()` method for a sequential stream or `parallelStream()` for a parallel stream.

   Example:
   ```java
   List<Integer> list = List.of(1, 2, 3, 4, 5, 6);
   list.stream().filter(e -> e % 2 == 0).count(); // Count even numbers
   ```

2. **From Arrays:**
   You can use `Arrays.stream()` to create a stream from an array.

   Example:
   ```java
   String[] array = {"a", "b", "c", "d"};
   Arrays.stream(array).forEach(System.out::println); // Prints "a", "b", "c", "d"
   ```

3. **Using `Stream.of()` for multiple elements:**
   You can create a stream by passing multiple elements directly to `Stream.of()`. 

   Example:
   ```java
   Stream.of(1, 2, 3, 4, 5, 6).forEach(System.out::println);
   ```

4. **Infinite Streams:**
   - **`Stream.generate()`** generates an infinite stream based on a provided supplier.
   - **`Stream.iterate()`** generates an infinite stream by repeatedly applying a function.

   Example (generate "Hello" infinitely):
   ```java
   Stream.generate(() -> "Hello").limit(5).forEach(System.out::println);
   ```

   Example (generate numbers starting from 0):
   ```java
   Stream.iterate(0, x -> x + 1).limit(10).forEach(System.out::println); // Prints 0 to 9
   ```

---

## Stream Pipeline Example
A typical stream operation follows this structure:
1. **Source**: A collection, array, or generator.
2. **Intermediate Operations**: Operations that transform or filter data (e.g., `filter`, `map`).
3. **Terminal Operation**: An operation that consumes the stream (e.g., `count`, `collect`, `forEach`).

```java
long count = list.stream()
                 .filter(e -> e % 2 == 0) // Intermediate operation: filter
                 .count(); // Terminal operation: count
```

### **Benefits of Streams**
- **Declarative approach**: Express data processing in a more readable and concise way.
- **Parallelism**: Easy to implement parallel processing using `parallelStream()`.
- **Functional style**: Leverages functional programming concepts like `map`, `filter`, and `reduce`.

---

## Conclusion

Java 8 Streams provide a powerful abstraction for processing sequences of data in a more functional style. By enabling operations like filtering, mapping, sorting, and reducing, they allow developers to focus on "what" needs to be done rather than "how".
