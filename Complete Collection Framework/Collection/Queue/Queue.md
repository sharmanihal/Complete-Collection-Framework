# Queue in Java

## Overview

The `Queue` interface in Java is part of the `java.util` package and represents a collection designed for holding elements prior to processing. It follows the **FIFO (First In, First Out)** principle, meaning that elements are added at the end of the queue and removed from the beginning. 

### Key Operations

- **Insert**: `add(e)`, `offer(e)` — Adds elements to the end of the queue.
- **Remove**: `remove()`, `poll()` — Removes and returns the element from the front of the queue.
- **Examine**: `peek()`, `element()` — Returns the element at the front of the queue without removing it.

- **Difference Between `remove()` and `poll()`**:
  - `remove()` throws a `NoSuchElementException` if the queue is empty.
  - `poll()` returns `null` if the queue is empty.

### Types of Queue Implementations

1. **LinkedList**: Can be used as a queue (FIFO) and implements the `Queue` interface.
2. **ArrayBlockingQueue**: A bounded queue that supports a fixed-size buffer.
3. **PriorityQueue**: Elements are ordered based on their priority, not necessarily in FIFO order.

---

## Code Example

```java
package Collection.Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class QueueDemo {
    public static void main(String[] args) {
        // Queue follows the FIFO (First In First Out) order
        // Elements are added at the end of the queue and removed from the beginning of the queue

        // Queue using LinkedList
        LinkedList<Integer> integerLinkedList = new LinkedList<>();
        // Insert at the end
        // Remove from the beginning
        integerLinkedList.addLast(1); // Enqueue
        integerLinkedList.addLast(2);
        System.out.println(integerLinkedList); // [1, 2]
        integerLinkedList.removeFirst(); // Dequeue

        // Queue using Queue interface
        Queue<Integer> integerQueue = new LinkedList<>();
        integerQueue.add(1);
        integerQueue.add(2);
        System.out.println(integerQueue); // [1, 2]
        integerQueue.remove(); // Removes the first element

        // Add, remove, peek and their alternatives
        System.out.println(integerQueue.remove()); // Throws NoSuchElementException if queue is empty
        System.out.println(integerQueue.poll()); // Returns null if queue is empty

        System.out.println(integerQueue.element()); // Throws NoSuchElementException if queue is empty
        System.out.println(integerQueue.peek()); // Returns null if queue is empty

        // Queue of fixed size
        Queue<Integer> integerQueue1 = new ArrayBlockingQueue<>(2);
        System.out.println(integerQueue1.add(1)); // true
        System.out.println(integerQueue1.offer(2)); // true
        System.out.println(integerQueue1.offer(3)); // false
        System.out.println(integerQueue1.add(4)); // IllegalStateException: Queue full
    }
}
```

---

## Explanation of the Code

### 1. **Queue Using `LinkedList`**:
   - A `LinkedList` is used here to implement a queue. The `addLast()` method inserts elements at the end, and `removeFirst()` removes elements from the beginning, following the FIFO principle.

   ```java
   LinkedList<Integer> integerLinkedList = new LinkedList<>();
   integerLinkedList.addLast(1); // Enqueue
   integerLinkedList.addLast(2); // Enqueue
   integerLinkedList.removeFirst(); // Dequeue
   ```

   - `addLast()` is used to add elements, and `removeFirst()` removes the front element of the queue.

### 2. **Queue Using `Queue` Interface**:
   - A `LinkedList` can also implement the `Queue` interface, and in this example, we use the `add()` and `remove()` methods to add and remove elements from the queue.

   ```java
   Queue<Integer> integerQueue = new LinkedList<>();
   integerQueue.add(1); // Adds element to the queue
   integerQueue.remove(); // Removes the first element from the queue
   ```

   - The `poll()` method can be used instead of `remove()` to avoid throwing an exception when the queue is empty, as `poll()` returns `null` when the queue is empty.

### 3. **Add, Remove, Peek, and Alternatives**:
   - The `Queue` interface offers different methods for handling elements:
     - `add()` adds an element to the queue, throwing an exception if the queue is full.
     - `offer()` is a safer alternative to `add()` and returns `false` if the queue is full.
     - `remove()` removes the front element but throws an exception if the queue is empty.
     - `poll()` removes the front element and returns `null` if the queue is empty.
     - `element()` returns the front element but throws an exception if the queue is empty.
     - `peek()` returns the front element or `null` if the queue is empty.

   ```java
   System.out.println(integerQueue.remove()); // Throws NoSuchElementException if queue is empty
   System.out.println(integerQueue.poll()); // Returns null if queue is empty

   System.out.println(integerQueue.element()); // Throws NoSuchElementException if queue is empty
   System.out.println(integerQueue.peek()); // Returns null if queue is empty
   ```

### 4. **Queue of Fixed Size**:
   - `ArrayBlockingQueue` is a bounded queue with a fixed size, meaning it cannot grow beyond the specified size. When attempting to add an element to a full queue, `offer()` will return `false`, and `add()` will throw an exception.
   
   ```java
   Queue<Integer> integerQueue1 = new ArrayBlockingQueue<>(2);
   integerQueue1.add(1); // Returns true, element added
   integerQueue1.offer(2); // Returns true, element added
   integerQueue1.offer(3); // Returns false, queue is full
   integerQueue1.add(4); // Throws IllegalStateException, queue is full
   ```

---

## Conclusion

- **FIFO**: A `Queue` follows the **First In, First Out** principle, making it ideal for processing tasks in the order they were added.
- **Common Implementations**: The `LinkedList` and `ArrayBlockingQueue` provide practical implementations for different queueing needs.
- **Methods**: Various methods like `add()`, `remove()`, `offer()`, and `poll()` allow for flexible and safe manipulation of the queue.

Use a queue when you need to process elements in a specific order and when you need to manage task execution based on that order. For more control over queue size and thread safety, consider using `ArrayBlockingQueue`.
