# Java 8 Features: Lambda Expressions, Functional Interfaces, and Streams

Java 8 introduced several important features aimed at improving code simplicity and readability. Some of the key features include **Lambda expressions**, **Functional interfaces**, **Streams**, and **Method references**. Below is an explanation and code example showcasing these features.

---

## Code Example

```java
package Java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.*;

public class Java8Demo {

    // Main function demonstrating Java 8 features
    public static void main(String[] args) {
        // Lambda Expressions
        MathOperations sum = (a, b) -> a + b;
        MathOperations sub = (a, b) -> a - b;
        MathOperations mul = (a, b) -> a * b;
        MathOperations div = (a, b) -> a / b;

        System.out.println(sum.operate(1, 2)); // Output: 3

        // Predicate: Functional Interface (Boolean Valued Function)
        Predicate<Integer> isEven = x -> x % 2 == 0;
        System.out.println(isEven.test(4));  // Output: true
        Predicate<String> startingWithA = x -> x.startsWith("a");
        System.out.println(startingWithA.test("anikit")); // Output: true

        // Chaining predicates (AND, OR)
        Predicate<String> endingWithA = x -> x.endsWith("a");
        Predicate<String> stringPredicate = startingWithA.and(endingWithA); // Both conditions must be true
        Predicate<String> stringPredicate1 = startingWithA.or(endingWithA);  // Either condition must be true
        System.out.println(stringPredicate.test("ankit"));  // Output: false
        System.out.println(stringPredicate1.test("Nikita")); // Output: true

        // Function: Functional Interface (T -> R)
        Function<String, String> makeUpperCase = x -> x.toUpperCase();
        System.out.println(makeUpperCase.apply("John"));  // Output: JOHN

        Function<Integer, Integer> doubleTheInteger = x -> x * 2;
        Function<Integer, Integer> divideBy10 = x -> x / 10;
        Function<Integer, Integer> doubleThenDivide = doubleTheInteger.andThen(divideBy10);

        System.out.println(doubleThenDivide.apply(10));  // Output: 2

        // Consumer: Functional Interface (void accept(T))
        Consumer<Integer> consumer = x -> System.out.println(x);
        consumer.accept(26);  // Output: 26

        // Consumer to print elements in a list
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6);
        Consumer<List<Integer>> printList = x -> x.forEach(System.out::println);
        printList.accept(list);

        // Supplier: Functional Interface (T get())
        Supplier<String> supplier = () -> "Hi";
        System.out.println(supplier.get());  // Output: Hi

        Supplier<List<Integer>> dummyArray = () -> List.of(1, 2, 3, 4, 5, 6);
        System.out.println(dummyArray.get());  // Output: [1, 2, 3, 4, 5, 6]

        // Combined Example using Predicate, Function, Consumer, and Supplier
        Predicate<Integer> predicate = x -> x % 2 == 0;
        Function<Integer, Integer> function = x -> x * x;
        Consumer<Integer> consumer1 = x -> System.out.println(x);
        Supplier<Integer> supplier1 = () -> 100;

        if (predicate.test(supplier1.get())) {
            consumer1.accept(function.apply(supplier1.get()));
        }

        // BiPredicate, BiConsumer, BiFunction

        BiPredicate<String, String> biPredicate = (x, y) -> x.length() == y.length();
        System.out.println(biPredicate.test("Talking", "Walking"));  // Output: true

        BiConsumer<String, String> biConsumer = (x, y) -> System.out.println(x + y);
        biConsumer.accept("My name is ", "John");  // Output: My name is John

        BiFunction<String, String, Integer> biFunction = (x, y) -> (x + y).length();
        System.out.println(biFunction.apply("Hi", "Tom"));  // Output: 5

        // Method Reference: Replacing lambda expressions with method references
        List<String> students = Arrays.asList("Ram", "Shyam", "Ghanshyam");
        students.forEach(System.out::println);  // Output: Ram, Shyam, Ghanshyam

        // Constructor Reference
        List<String> mobiles = Arrays.asList("A", "B", "C", "D");
        List<Mobile> collect = mobiles.stream().map(Mobile::new).collect(Collectors.toList());
    }
}

class Mobile {
    String name;
    Mobile(String name) {
        this.name = name;
    }
}

@FunctionalInterface
interface MathOperations {
    int operate(int a, int b);  // Defines a functional interface for mathematical operations
}
```

---

## Explanation of Java 8 Features:

### 1. **Lambda Expressions**
Lambda expressions allow you to pass behavior as arguments to methods and enable functional programming. The syntax is:

```java
(parameter) -> expression
```

In the code, we defined `MathOperations` as a functional interface and created lambda expressions for addition, subtraction, multiplication, and division.

### 2. **Predicate**
`Predicate` is a functional interface representing a boolean-valued function of one argument. It is used for testing a condition:

```java
Predicate<Integer> isEven = x -> x % 2 == 0;
```

We can chain multiple predicates using `and()`, `or()`, and `negate()`.

### 3. **Function**
A `Function` takes an argument of type `T` and returns a result of type `R`. In the code, we used `Function` to transform a string to uppercase and to square a number:

```java
Function<String, String> makeUpperCase = x -> x.toUpperCase();
```

Functions can be chained using `andThen()` and `compose()`.

### 4. **Consumer**
A `Consumer` is a functional interface that accepts an argument of type `T` and performs some operation without returning a result:

```java
Consumer<Integer> consumer = x -> System.out.println(x);
```

Consumers are often used for actions like printing, updating, or modifying data.

### 5. **Supplier**
A `Supplier` is a functional interface that returns a result of type `T` and takes no arguments:

```java
Supplier<String> supplier = () -> "Hi";
```

Suppliers are useful for lazy generation or fetching data.

### 6. **BiPredicate, BiConsumer, BiFunction**
These are extensions of the functional interfaces for two arguments. They are used when you need to operate on two inputs:

```java
BiPredicate<String, String> biPredicate = (x, y) -> x.length() == y.length();
```

### 7. **Method Reference**
Method references provide a way to refer to methods or constructors without invoking them directly. For example, the `forEach()` method can be simplified using a method reference:

```java
students.forEach(System.out::println);
```

### 8. **Constructor Reference**
Constructor references allow you to refer to a constructor directly. In the example, we used a constructor reference to create `Mobile` objects from a list of names:

```java
List<Mobile> collect = mobiles.stream().map(Mobile::new).collect(Collectors.toList());
```

---

## Conclusion

Java 8's features like **Lambda Expressions**, **Functional Interfaces**, **Streams**, and **Method References** revolutionize how we write code, promoting a more concise, readable, and functional style. These features enable powerful abstractions, which lead to cleaner, more maintainable code.
