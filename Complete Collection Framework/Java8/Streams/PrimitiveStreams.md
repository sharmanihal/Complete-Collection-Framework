# Java 8 Primitive Streams

Java 8 introduces support for primitive streams, which allow for efficient handling of primitive data types (`int`, `long`, `double`) without the overhead of boxing. This can be useful when working with large datasets of primitive values.

---

## Code Example

```java
package Java8.Streams;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class PrimitiveStreamsDemo {
    public static void main(String[] args) {
        // Creating an IntStream from an array of integers
        int nums[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        IntStream stream = Arrays.stream(nums);

        // Creating a List from a range of integers using IntStream.range()
        List<Integer> collect = IntStream.range(1, 5).boxed().collect(Collectors.toList());

        // Creating an IntStream using IntStream.of()
        IntStream.of(1, 2, 3, 4);

        // Creating a DoubleStream with random doubles
        DoubleStream doubles = new Random().doubles(5);
        System.out.println("Sum of random doubles: " + doubles.sum());
        
        // Some other useful operations on DoubleStream (commented out)
        // System.out.println(doubles.average());
        // System.out.println(doubles.max());
        // System.out.println(doubles.min());
        // System.out.println(doubles.count());
        // System.out.println(doubles.summaryStatistics());
        // System.out.println(doubles.boxed().toList());

        // Generating random integers and converting to a List
        List<Integer> list2 = new Random().ints(5).boxed().toList();
        System.out.println("List of random integers: " + list2);
    }
}
```

---

## Explanation of Primitive Streams

### `IntStream`
`IntStream` is a sequence of primitive `int` values. You can create an `IntStream` from an array of integers, a range of values, or specific values.

- **Creating from an array:**
  ```java
  IntStream stream = Arrays.stream(nums);
  ```

- **Creating from a range:**
  ```java
  List<Integer> collect = IntStream.range(1, 5).boxed().collect(Collectors.toList());
  ```

  The `range()` method generates an `IntStream` for a specified range of values.

- **Creating from specific values:**
  ```java
  IntStream.of(1, 2, 3, 4);
  ```

### `DoubleStream`
`DoubleStream` is used for handling streams of `double` values.

- **Creating a `DoubleStream` with random doubles:**
  ```java
  DoubleStream doubles = new Random().doubles(5);
  System.out.println("Sum of random doubles: " + doubles.sum());
  ```

  You can perform operations like `sum()`, `average()`, `max()`, `min()`, `count()`, and more on a `DoubleStream`.

### `Random` Number Generation
You can generate random numbers using `Random`'s `ints()` and `doubles()` methods, which return `IntStream` and `DoubleStream`, respectively.

- **Generating random integers:**
  ```java
  List<Integer> list2 = new Random().ints(5).boxed().toList();
  System.out.println("List of random integers: " + list2);
  ```

  The `ints()` method generates an `IntStream` of random integers.

---

## Key Operations

### `.boxed()`
This operation converts a primitive stream (`IntStream`, `DoubleStream`) into a stream of their corresponding wrapper classes (`Stream<Integer>`, `Stream<Double>`).

For example:
```java
IntStream.range(1, 5).boxed().collect(Collectors.toList());
```

This converts the `IntStream` into a list of `Integer` objects.

### `sum()`, `average()`, `max()`, `min()`, `count()`
These are commonly used terminal operations to collect statistics from primitive streams.

```java
System.out.println(doubles.sum()); // Sum of the doubles
```

You can also use `summaryStatistics()` for a more comprehensive statistical summary.

---

## Conclusion

- **Primitive Streams** like `IntStream`, `LongStream`, and `DoubleStream` are designed for processing primitive types efficiently.
- **Boxing** primitive types can introduce overhead, but the ability to convert them into `Stream<Integer>`, `Stream<Double>` using `.boxed()` is very useful.
- **Random Number Generation** via `Random.ints()` or `Random.doubles()` is a simple and effective way to generate streams of random numbers for use in various applications.

