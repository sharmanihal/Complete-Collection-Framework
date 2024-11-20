# PriorityBlockingQueue in Java

## Overview

`PriorityBlockingQueue` is a thread-safe, unbounded queue that extends `BlockingQueue`. It is similar to `PriorityQueue`, but with the added benefit of being thread-safe. Elements in a `PriorityBlockingQueue` are ordered according to their natural ordering or based on a custom comparator. This allows elements with higher priority to be consumed first, even in a multi-threaded environment.

- **Unbounded**: Unlike other `BlockingQueue` implementations, `PriorityBlockingQueue` does not have a fixed capacity, which means it will never block the producer when adding elements.
- **Thread-Safe**: It allows multiple threads to safely access and modify the queue.
- **Custom Ordering**: You can provide a custom comparator to determine the priority of elements.

### Key Features:
- **Thread-Safety**: It is designed to be used in multithreaded environments where multiple threads might be adding or removing elements concurrently.
- **Unbounded**: The queue does not block on insertion even when it reaches a high number of elements.
- **Priority Ordering**: Elements are ordered based on their priority, which can be defined by the natural ordering or a custom comparator.

---

## Code Example

```java
package Collection.Queue.BlockingQueue;

import java.util.Comparator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class PriorityBlockingQueueDemo {
    // Unbounded BlockingQueue that uses priority-based ordering

    public static void main(String[] args) {
        // Create an unbounded PriorityBlockingQueue
        BlockingQueue<Integer> queue = new PriorityBlockingQueue<>();

        // PriorityBlockingQueue orders elements based on their natural ordering
        queue.put(10);
        queue.put(5);
        queue.put(20);
        queue.put(1);
        
        // Since it is unbounded, put method will never block
        
        // The elements will be retrieved in order of their priority (lowest to highest)
        while (!queue.isEmpty()) {
            System.out.println(queue.take());
        }

        // Custom comparator to order strings based on their length
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        };
        
        // Create a PriorityBlockingQueue for Strings with a custom comparator
        BlockingQueue<String> queue2 = new PriorityBlockingQueue<>(11, comparator);
        queue2.add("Apple");
        queue2.add("Banana");
        queue2.add("Pineapple");
        queue2.add("Mango");

        // The elements will be ordered based on the length of the strings
        while (!queue2.isEmpty()) {
            System.out.println(queue2.poll());
        }
    }
}
```

---

## Explanation of the Code

### 1. **`PriorityBlockingQueue` with Integer Elements**
   - A `PriorityBlockingQueue` is created without specifying the comparator, so the elements are ordered according to their natural ordering (i.e., integers in ascending order).
   - The `put()` method is used to add elements to the queue, and `take()` retrieves and removes elements in the order of their priority (lowest first in this case).
   - Since the queue is unbounded, the `put()` method will never block regardless of how many elements are added.

### 2. **`PriorityBlockingQueue` with String Elements**
   - A custom comparator is provided to order the strings based on their length. The comparator compares two strings by subtracting the length of the second string from the length of the first string.
   - A `PriorityBlockingQueue` for strings is created, and strings are added to the queue.
   - The elements are retrieved based on their length (shortest string first).

### 3. **Thread-Safety**
   - The `PriorityBlockingQueue` is thread-safe, meaning it can be safely used by multiple threads for concurrent insertion and removal of elements.

### 4. **Unbounded Queue**
   - Since the queue is unbounded, it will not block the producer when adding elements. It can grow as needed.

---

## When to Use `PriorityBlockingQueue`

`PriorityBlockingQueue` is ideal when you need a thread-safe, unbounded queue that allows elements to be processed in priority order. Some typical use cases include:
- **Task Scheduling**: In scenarios where tasks have different priorities and need to be processed in priority order.
- **Event Handling**: For managing events that must be processed in a specific order based on urgency or priority.
- **Producer-Consumer Problem**: When producers generate items with different priorities, and consumers must process higher-priority items first.

---

## Conclusion

`PriorityBlockingQueue` is a powerful and flexible data structure for managing elements in priority order in a thread-safe and unbounded manner. It is commonly used in multi-threaded applications that require prioritization, such as task scheduling and event handling. With support for custom comparators, it offers great flexibility in defining the priority of elements based on your application's needs.
