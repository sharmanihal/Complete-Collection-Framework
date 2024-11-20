# PriorityQueue in Java

## Overview

`PriorityQueue` in Java is part of the `java.util` package and implements the `Queue` interface. It is a data structure that orders elements based on their natural ordering (for comparable types) or by a specified `Comparator` provided at the time of queue creation. Elements with higher priority (lower values, depending on the ordering) are dequeued first.

### Key Characteristics

- **Natural Ordering or Custom Ordering**: By default, the elements are ordered using their natural ordering (for comparable elements), but a custom `Comparator` can be used to define the ordering.
- **Min-Heap Implementation**: Internally, `PriorityQueue` is implemented as a **min-heap**, meaning the smallest element is at the root. It is structured as a tree where the root element is always smaller than its children.
- **No Null Elements**: `PriorityQueue` does not allow null elements.
- **Not Thread-Safe**: `PriorityQueue` is not thread-safe. If concurrent access is required, external synchronization or other thread-safe alternatives should be used.

### Key Operations

- **Insertion**: `add(e)`, `offer(e)` — Inserts elements into the queue.
- **Removal**: `poll()` — Removes and returns the element with the highest priority (smallest element, by default).
- **Examination**: `peek()` — Returns the element with the highest priority without removing it.
- **Sorting**: The elements are sorted based on their natural order or a custom `Comparator` provided at the time of queue creation.

---

## Code Example

```java
package Collection.Queue.PriorityQueue;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueDemo {
    // Part of Queue interface

    // It can act as a nominal queue or a priority queue
    // Orders elements based on their natural ordering (lowest first for primitives) or by a specified comparator
    public static void main(String[] args) {
        // Default PriorityQueue - Natural Ordering (Min-Heap)
        Queue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(2);
        priorityQueue.add(1);
        priorityQueue.add(4);
        priorityQueue.add(3);

        System.out.println(priorityQueue); // Priority will be given to the lowest element (but not sorted)

        // String example - Natural Ordering
        Queue<String> stringPriorityQueue = new PriorityQueue<>();
        stringPriorityQueue.add("Banana");
        stringPriorityQueue.add("Apple");
        stringPriorityQueue.add("Pineapple");
        stringPriorityQueue.add("Mango");

        // The first element will be polled based on the natural ordering of the elements
        System.out.println(stringPriorityQueue); // Priority is based on natural ordering of the elements
        System.out.println(stringPriorityQueue.poll()); // Apple
        System.out.println(stringPriorityQueue.poll()); // Banana
        System.out.println(stringPriorityQueue.poll()); // Mango
        System.out.println(stringPriorityQueue.poll()); // Pineapple

        // Custom Comparator Example - Reverse Order (Max-Heap)
        PriorityQueue<Integer> customPriorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        customPriorityQueue.add(2);
        customPriorityQueue.add(1);
        customPriorityQueue.add(4);
        customPriorityQueue.add(3);

        while (!customPriorityQueue.isEmpty()) {
            System.out.println(customPriorityQueue.poll()); // Dequeues in reverse order (Max-Heap)
        }

        // Custom String Comparator - Sorting by String Length (Longest First)
        Comparator<String> stringComparator = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s2.length() - s1.length(); // Longer strings come first
            }
        };
        PriorityQueue<String> customStringPriorityQueue = new PriorityQueue<>(stringComparator);
        customStringPriorityQueue.add("Banana");
        customStringPriorityQueue.add("Apple");
        customStringPriorityQueue.add("Pineapple");
        customStringPriorityQueue.add("Mango");

        while (!customStringPriorityQueue.isEmpty()) {
            System.out.println(customStringPriorityQueue.poll()); // Elements are dequeued based on string length
        }
    }
}
```

---

## Explanation of the Code

### 1. **Default PriorityQueue (Natural Ordering)**:
   - `Queue<Integer> priorityQueue = new PriorityQueue<>();`: This creates a `PriorityQueue` where the elements are sorted by their natural ordering (smallest element first for integers).
   - `priorityQueue.add(2);`: Adds elements to the queue.
   - When the queue is printed, it shows the elements in an unsorted order, but when we `poll()`, it dequeues the smallest element (i.e., the element with the highest priority).

### 2. **String Example with Natural Ordering**:
   - The elements are ordered by their lexicographical (alphabetical) order.
   - `poll()` retrieves and removes elements based on their natural ordering. For instance, "Apple" comes before "Banana" because it is lexicographically smaller.

### 3. **Custom Comparator (Reverse Order)**:
   - `PriorityQueue<Integer> customPriorityQueue = new PriorityQueue<>(Comparator.reverseOrder());`: This creates a priority queue that orders elements in reverse (i.e., largest element first, implementing a max-heap).
   - The elements are dequeued in descending order: `4`, `3`, `2`, `1`.

### 4. **Custom Comparator (String Length)**:
   - A custom `Comparator` is defined to order strings by their length in descending order.
   - The strings are dequeued based on their length, with the longest string coming first.

---

## Internal Implementation: Min-Heap

- `PriorityQueue` is implemented using a **min-heap**. In a min-heap, the smallest element is always at the root, and every parent node is smaller than its child nodes.
- **Insertion** into the queue takes **O(log n)** time because we need to maintain the heap property (the tree must remain balanced).
- **Removal** of the smallest element also takes **O(log n)** time because after the removal, the heap must be re-adjusted to maintain the heap structure.

---

## When to Use `PriorityQueue`?

- **When you need elements ordered by priority**: `PriorityQueue` is useful when you need to process elements based on priority (e.g., smallest/largest first).
- **For task scheduling**: It is often used in scheduling algorithms, where tasks are processed in order of priority.
- **For stream processing**: It can be used to process streams of data in a prioritized order.

---

## Conclusion

`PriorityQueue` is a versatile and powerful class in Java's collection framework, offering both natural ordering and the flexibility of custom comparators for sorting elements. Whether you need a simple queue with priority ordering or a custom ordering scheme, `PriorityQueue` provides an efficient way to manage your elements with automatic sorting. Keep in mind that it is **not thread-safe**; if you need concurrency support, consider using alternatives like `PriorityBlockingQueue`.
