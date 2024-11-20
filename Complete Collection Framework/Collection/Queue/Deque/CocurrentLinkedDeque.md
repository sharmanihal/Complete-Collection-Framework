# ConcurrentLinkedDeque in Java

## Overview

`ConcurrentLinkedDeque` is a thread-safe, non-blocking double-ended queue implementation in Java. It is part of the `java.util.concurrent` package and provides high-performance concurrent access to a deque (double-ended queue), which allows for inserting and removing elements from both ends. It is designed to be used in concurrent programming environments where multiple threads need to safely access and modify the deque.

### Key Characteristics

- **Non-blocking**: `ConcurrentLinkedDeque` operates using **Compare-And-Swap (CAS)** operations to ensure that elements are added and removed atomically, without the need for locks. This enables lock-free, thread-safe operations.
- **Double-Ended Queue**: It allows insertion and removal of elements from both the front and rear, just like a standard deque.
- **Thread-Safe**: It ensures thread safety without blocking, meaning multiple threads can concurrently add or remove elements without blocking each other.
- **Lock-Free**: Uses atomic operations to ensure safe concurrent access without traditional synchronization mechanisms like `synchronized` blocks or locks.

### Key Operations

- **Insertion**:
  - `addFirst(e)`: Inserts an element at the front.
  - `addLast(e)`: Inserts an element at the end.
  - `offerFirst(e)`: Inserts the element at the front, similar to `addFirst`.
  - `offerLast(e)`: Inserts the element at the end, similar to `addLast`.
  
- **Removal**:
  - `removeFirst()`: Removes and returns the first element.
  - `removeLast()`: Removes and returns the last element.
  - `pollFirst()`: Removes and returns the first element, or returns `null` if the deque is empty.
  - `pollLast()`: Removes and returns the last element, or returns `null` if the deque is empty.

- **Examine**:
  - `getFirst()`: Returns the first element, or throws `NoSuchElementException` if the deque is empty.
  - `getLast()`: Returns the last element, or throws `NoSuchElementException` if the deque is empty.
  - `peekFirst()`: Returns the first element, or `null` if empty.
  - `peekLast()`: Returns the last element, or `null` if empty.

### When to Use `ConcurrentLinkedDeque`?

- **In concurrent applications**: If your application involves multiple threads accessing and modifying the deque concurrently, `ConcurrentLinkedDeque` ensures thread safety and avoids the overhead of locks.
- **For lock-free operations**: When you need non-blocking, high-performance concurrent deque operations.
- **When using a double-ended queue**: For operations that require adding and removing elements from both ends in a thread-safe manner.

---

## Code Example

```java
package Collection.Queue.Deque;

import java.util.concurrent.ConcurrentLinkedDeque;

public class ConcurrentLinkedDequeDemo {
    public static void main(String[] args) {
        // ConcurrentLinkedDeque is a thread-safe, non-blocking double-ended queue

        // Using ConcurrentLinkedDeque to create a thread-safe deque
        ConcurrentLinkedDeque<String> concurrentLinkedDeque = new ConcurrentLinkedDeque<>();

        // Inserting elements at both ends
        concurrentLinkedDeque.addFirst("Task 1");   // Adds "Task 1" to the front
        concurrentLinkedDeque.addLast("Task 2");    // Adds "Task 2" to the end

        // Polling elements from both ends
        System.out.println("First Element (pollFirst): " + concurrentLinkedDeque.pollFirst());  // Removes and prints "Task 1"
        System.out.println("Last Element (pollLast): " + concurrentLinkedDeque.pollLast());    // Removes and prints "Task 2"

        // Adding elements to the front and back
        concurrentLinkedDeque.offerFirst("Task 3");  // Adds "Task 3" to the front
        concurrentLinkedDeque.offerLast("Task 4");   // Adds "Task 4" to the end

        // Inspecting elements
        System.out.println("First Element (peekFirst): " + concurrentLinkedDeque.peekFirst());  // Prints "Task 3"
        System.out.println("Last Element (peekLast): " + concurrentLinkedDeque.peekLast());    // Prints "Task 4"
    }
}
```

---

## Explanation of the Code

### 1. **Creating the ConcurrentLinkedDeque**:
   - `ConcurrentLinkedDeque<String> concurrentLinkedDeque = new ConcurrentLinkedDeque<>();`: Creates an empty `ConcurrentLinkedDeque` to store `String` elements in a thread-safe manner.

### 2. **Insertion Operations**:
   - `addFirst("Task 1")`: Adds an element ("Task 1") at the front of the deque.
   - `addLast("Task 2")`: Adds an element ("Task 2") at the end of the deque.
   - `offerFirst("Task 3")`: Offers an element at the front.
   - `offerLast("Task 4")`: Offers an element at the end.

### 3. **Removal Operations**:
   - `pollFirst()`: Removes and returns the first element of the deque. If the deque is empty, it returns `null`.
   - `pollLast()`: Removes and returns the last element of the deque. If the deque is empty, it returns `null`.

### 4. **Examine Operations**:
   - `peekFirst()`: Returns the first element without removing it. If the deque is empty, it returns `null`.
   - `peekLast()`: Returns the last element without removing it. If the deque is empty, it returns `null`.

---

## When to Choose `ConcurrentLinkedDeque`?

- **For Thread Safety**: It is ideal for scenarios where multiple threads need to concurrently access and modify the deque without blocking each other.
- **For High Performance**: It provides better performance than using synchronized blocks or locks, as it operates in a lock-free manner using CAS operations.
- **For Double-Ended Queue**: It is particularly useful when you need to perform both front and back operations (insertions and removals) in a concurrent setting.

---

## Conclusion

`ConcurrentLinkedDeque` is a highly efficient and thread-safe implementation of a double-ended queue that supports non-blocking, lock-free operations. It is ideal for concurrent applications where multiple threads access and modify the queue. Its use of **CAS (Compare-And-Swap)** ensures atomic, thread-safe operations without the need for locks, providing high performance in multi-threaded environments.
