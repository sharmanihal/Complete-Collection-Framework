# Understanding `Vector` in Java

## Overview
`Vector` is a **legacy class** that is part of the Java Collection Framework and implements the `List` interface. It is a **thread-safe** alternative to `ArrayList` but is generally slower due to synchronization. 

---

## Key Characteristics of `Vector`
1. **Thread-Safe**:
   - Synchronization ensures thread safety, but it can lead to slower performance compared to `ArrayList`.
2. **Dynamic Array**:
   - Like `ArrayList`, `Vector` dynamically resizes itself as elements are added.
3. **Resizing Mechanism**:
   - By default, the capacity doubles when the existing capacity is exceeded.
   - Custom initial capacity and capacity increment can be specified.
4. **Legacy Class**:
   - Introduced in Java 1.0, `Vector` is now considered less desirable compared to newer alternatives like `CopyOnWriteArrayList`.

---

## Code

```java
package Collection.List.Vector;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

public class VectorDemo {
    public static void main(String[] args) {
        // Default initial capacity is 10
        Vector<Integer> vector = new Vector<>();
        System.out.println(vector.capacity()); // Output: 10

        // Specifying initial capacity and capacity increment
        Vector<Integer> vector2 = new Vector<>(20, 5);
        System.out.println(vector2.capacity()); // Output: 20

        // Creating a Vector from a collection
        Vector<Integer> vector3 = new Vector<>(Arrays.asList(1, 2, 3, 4, 5));

        // Thread-Safe Example: Using ArrayList
        ArrayList<Integer> arrayList = new ArrayList<>();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                arrayList.add(i);
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                arrayList.add(i);
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(arrayList.size()); // Output: <2000 (due to lack of synchronization)

        // Thread-Safe Example: Using Vector
        Vector<Integer> threadVector = new Vector<>();

        Thread t3 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                threadVector.add(i);
            }
        });

        Thread t4 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                threadVector.add(i);
            }
        });

        t3.start();
        t4.start();

        try {
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(threadVector.size()); // Output: 2000
    }
}
```

---

## Comprehensive Notes

### Key Features of `Vector`
1. **Capacity Management**:
   - Default initial capacity: 10.
   - Resizes dynamically by **doubling its size** when capacity is exceeded.
   - Custom initial capacity and increment can be specified during instantiation.
2. **Thread-Safe**:
   - Synchronized methods ensure safe access by multiple threads but reduce performance compared to unsynchronized alternatives.
3. **Implements `List` Interface**:
   - Like `ArrayList`, `Vector` maintains the order of elements and allows indexed access.

---

### Thread-Safety Example

#### Using `ArrayList`:
```java
ArrayList<Integer> arrayList = new ArrayList<>();
Thread t1 = new Thread(() -> {
    for (int i = 0; i < 1000; i++) {
        arrayList.add(i);
    }
});
Thread t2 = new Thread(() -> {
    for (int i = 0; i < 1000; i++) {
        arrayList.add(i);
    }
});
t1.start();
t2.start();
t1.join();
t2.join();
System.out.println(arrayList.size()); // Output: <2000
```
- **Why?**:
  - `ArrayList` is not thread-safe, leading to race conditions.

#### Using `Vector`:
```java
Vector<Integer> vector = new Vector<>();
Thread t3 = new Thread(() -> {
    for (int i = 0; i < 1000; i++) {
        vector.add(i);
    }
});
Thread t4 = new Thread(() -> {
    for (int i = 0; i < 1000; i++) {
        vector.add(i);
    }
});
t3.start();
t4.start();
t3.join();
t4.join();
System.out.println(vector.size()); // Output: 2000
```
- **Why?**:
  - Synchronization in `Vector` ensures thread safety.

---

### Performance Comparison

| Feature                   | `Vector`               | `ArrayList`             |
|---------------------------|------------------------|--------------------------|
| **Thread Safety**         | Synchronized          | Not thread-safe         |
| **Performance (Read)**    | Slower due to locks   | Faster                  |
| **Performance (Write)**   | Slower due to locks   | Faster                  |
| **Resizing Mechanism**    | Doubles capacity      | Increases by 50%        |
| **Use Case**              | Multi-threaded        | Single-threaded         |

---

## Summary
1. **When to Use `Vector`**:
   - Use in multi-threaded environments with shared lists where synchronization is essential.
2. **Drawbacks**:
   - Slower performance compared to modern alternatives (`ArrayList`, `CopyOnWriteArrayList`).
   - Largely considered outdated; `ArrayList` with external synchronization or `CopyOnWriteArrayList` is preferred.
3. **Key Takeaway**:
   - Though synchronized, the legacy nature of `Vector` makes it less ideal for modern use cases.
