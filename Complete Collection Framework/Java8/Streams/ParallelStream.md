# Java 8 Parallel Streams

Parallel streams allow for parallel processing of data using multiple threads, which can significantly improve the performance of operations on large data sets. Below is an example demonstrating the usage of parallel streams in Java 8.

---

## Code Example

```java
package Java8.Streams;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class ParallelStreamDemo {
    public static void main(String[] args) {
        // Parallel Streams are a type of stream that can be used to process large amounts of data in parallel
        // Allows multiple threads to process parts of the stream simultaneously
        // This can significantly improve the performance for large data sets

        // without parallel stream
        long start = System.currentTimeMillis();
        List<Integer> list = Stream.iterate(1, x -> x + 1).limit(20000).toList();
        List<Integer> list1 = list.stream().map(ParallelStreamDemo::factorial).toList();
        long end = System.currentTimeMillis();
        System.out.println("Time taken without parallel stream: " + (end - start) + "ms");
        // Time taken without parallel stream: 210ms

        // Let's use parallel stream
        long startTime = System.currentTimeMillis();
        List<Integer> list2 = list.parallelStream().map(ParallelStreamDemo::factorial).toList();
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken with parallel stream: " + (endTime - startTime) + "ms");
        // Time taken with parallel stream: 50ms

        // Parallel streams are useful when we have a large amount of data to process and independent operations
        // Independent operations are those that do not depend on the result of other operations.
        // They may add overhead when used with small data sets or operations that are not independent

        // Cumulative Sum
        List<Integer> list3 = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // without parallel stream (correct answer)
        AtomicInteger sum = new AtomicInteger();
        List<Integer> list4 = list3.stream().map(sum::addAndGet).toList();
        System.out.println("Cumulative sum without parallel stream: " + list4);

        // with parallel stream (wrong answer)
        AtomicInteger sum1 = new AtomicInteger();
        List<Integer> list5 = list3.parallelStream().map(sum1::addAndGet).toList();
        System.out.println("Cumulative sum with parallel stream: " + list5);

        // We can also make the parallel stream sequential by using the sequential() method
        List<Integer> list6 = list.parallelStream().map(ParallelStreamDemo::factorial).sequential().toList();
        System.out.println("Sequential stream after parallel operation: " + list6);
    }

    // Method to calculate factorial
    public static int factorial(int num) {
        int fact = 1;
        for (int i = 2; i <= num; i++) {
            fact *= i;
        }
        return fact;
    }
}
```

---

## Explanation of Parallel Streams

### Parallel Streams
Parallel streams allow Java to use multiple threads to process different parts of the stream concurrently. This is useful when dealing with large datasets where independent operations can be processed in parallel.

```java
List<Integer> list2 = list.parallelStream().map(ParallelStreamDemo::factorial).toList();
```

### Performance Comparison
In this example, we first run a sequential stream to process a large number of elements (20000). The time taken for processing is measured. Then, the same stream is processed using a parallel stream, which completes the task faster.

**Without Parallel Stream:**

```java
long start = System.currentTimeMillis();
List<Integer> list1 = list.stream().map(ParallelStreamDemo::factorial).toList();
long end = System.currentTimeMillis();
System.out.println("Time taken without parallel stream: " + (end - start) + "ms");
```

**With Parallel Stream:**

```java
long startTime = System.currentTimeMillis();
List<Integer> list2 = list.parallelStream().map(ParallelStreamDemo::factorial).toList();
long endTime = System.currentTimeMillis();
System.out.println("Time taken with parallel stream: " + (endTime - startTime) + "ms");
```

### Cumulative Sum Example
Parallel streams can sometimes lead to incorrect results if the operations are not associative or if the operation modifies a shared mutable state. For example, adding values to an `AtomicInteger` might give incorrect results when processed in parallel.

```java
AtomicInteger sum = new AtomicInteger();
List<Integer> list4 = list3.stream().map(sum::addAndGet).toList();
```

In this case, the cumulative sum works correctly for sequential streams, but when using parallel streams, you might encounter issues due to concurrency problems.

```java
AtomicInteger sum1 = new AtomicInteger();
List<Integer> list5 = list3.parallelStream().map(sum1::addAndGet).toList();
```

### Making a Parallel Stream Sequential
You can switch a parallel stream back to sequential by calling the `sequential()` method. This is useful when you have a parallel stream but need to ensure that the operations are executed in the original order.

```java
List<Integer> list6 = list.parallelStream().map(ParallelStreamDemo::factorial).sequential().toList();
```

---

## Key Points

- **Parallel Streams** are beneficial for processing large datasets with independent operations.
- **Sequential Streams** execute in a single thread, while **Parallel Streams** divide the work into multiple threads, potentially speeding up processing for large datasets.
- **Potential Issues with Parallel Streams**:
  - Modifying shared mutable data in parallel streams can cause unexpected results due to thread interference.
  - Parallel streams may add overhead when used on small datasets or when operations are not independent.
- **Sequential Conversion**: You can convert a parallel stream back to a sequential one using the `sequential()` method.

