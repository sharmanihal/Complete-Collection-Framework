# Deque in Java

## Overview

`Deque` (short for **Double-Ended Queue**) is an interface that extends the `Queue` interface. It allows for the insertion and removal of elements from both ends, providing flexibility in queue operations. It supports stack-like and queue-like operations, making it versatile for various data structure needs.

- **Double-Ended Queue**: Supports both front and rear operations.
- **Stack-like Operations**: Can be used as a stack with `push()` and `pop()` methods.
- **Queue-like Operations**: Can function as a standard queue with `offer()`, `poll()`, and other methods.

### Key Operations

- **Insertion**:
  - `addFirst(e)`: Adds the element at the front.
  - `addLast(e)`: Adds the element at the end.
  - `offerFirst(e)`: Inserts at the front, similar to `addFirst`.
  - `offerLast(e)`: Inserts at the end, similar to `addLast`.

- **Removal**:
  - `removeFirst()`: Removes and returns the first element.
  - `removeLast()`: Removes and returns the last element.
  - `pollFirst()`: Removes the first element, or returns `null` if empty.
  - `pollLast()`: Removes the last element, or returns `null` if empty.

- **Examine**:
  - `getFirst()`: Returns the first element, throws an exception if empty.
  - `getLast()`: Returns the last element, throws an exception if empty.
  - `peekFirst()`: Returns the first element, or `null` if empty.
  - `peekLast()`: Returns the last element, or `null` if empty.

- **Stack Operations**:
  - `push(e)`: Adds the element to the front (acting like a stack's push).
  - `pop()`: Removes the first element (acting like a stack's pop).

### Common Implementations:
- **ArrayDeque**: A resizable array implementation that does not allow `null` elements and is more efficient in terms of memory and performance for most use cases.
- **LinkedList**: A doubly linked list implementation that allows for more flexible resizing, but is typically slower than `ArrayDeque` for most queue operations.

---

## Code Example

```java
package Collection.Queue.Deque;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class DequeDemo {
    public static void main(String[] args) {
        // Deque is a double-ended queue supporting element insertion and removal at both ends
        // Implemented using ArrayDeque or LinkedList

        // Creating a Deque using ArrayDeque
        Deque<Integer> deque1 = new ArrayDeque<>();

        // Insertion operations
        deque1.add(10);
        deque1.add(20);
        System.out.println(deque1); // [10, 20]

        // Removing the first element
        deque1.remove(); // removes the first element
        System.out.println(deque1); // [20]

        // Add elements at the front and end
        deque1.addFirst(1); 
        deque1.addLast(2);
        System.out.println(deque1); // [1, 20, 2]

        // Removing the first and last elements
        deque1.removeFirst();
        System.out.println(deque1); // [20, 2]
        deque1.removeLast();
        System.out.println(deque1); // [20]

        // Add a new element and remove the first element
        deque1.add(30);
        System.out.println(deque1); // [20, 30]
        deque1.poll(); // removes the first element
        System.out.println(deque1); // [30]

        // Stack operations
        deque1.push(40);
        System.out.println(deque1); // [40, 30]
        deque1.pop(); // removes the first element
        System.out.println(deque1); // [30]

        // ArrayDeque is circular in nature with two pointers (front and end)
        // When an element is added at the front or end, the pointers adjust
        // If the capacity is exceeded, the array is resized (typically doubled)

        // Creating a Deque using LinkedList (though ArrayDeque is typically recommended)
        Deque<Integer> deque2 = new LinkedList<>();
    }
}
```

---

## Explanation of the Code

### 1. **Creating Deque**:
   - `Deque<Integer> deque1 = new ArrayDeque<>();`: Creates an empty `Deque` using `ArrayDeque`, which is backed by an array.
   - `Deque<Integer> deque2 = new LinkedList<>();`: Creates a `Deque` using `LinkedList`, which is backed by a doubly linked list (not recommended for typical use cases when performance is critical).

### 2. **Insertion Operations**:
   - **`add(e)`**: Adds an element at the end of the deque.
   - **`addFirst(e)`**: Adds an element to the front.
   - **`addLast(e)`**: Adds an element to the end (same as `add()`).
   
### 3. **Removal Operations**:
   - **`remove()`**: Removes and returns the first element from the deque.
   - **`removeFirst()`**: Removes the first element explicitly.
   - **`removeLast()`**: Removes the last element.
   - **`poll()`**: Removes the first element and returns it (returns `null` if empty).

### 4. **Stack Operations**:
   - **`push(e)`**: Adds an element to the front, like a stack's push.
   - **`pop()`**: Removes the front element, like a stack's pop.

### 5. **Circular Nature**:
   - `ArrayDeque` behaves like a circular buffer: the internal array is resized (typically doubled) when the capacity is exceeded.
   - When elements are added to the front or end, pointers are adjusted accordingly.

---

## When to Use `Deque`?

- **When you need a queue with flexible operations**:
  - If you need operations that allow inserting and removing from both ends of the queue.
  - For implementing both **FIFO** (First In, First Out) and **LIFO** (Last In, First Out) behaviors.
  
- **When you need stack-like behavior**:
  - If you need to perform `push()` and `pop()` operations with stack-like semantics, `Deque` provides an efficient way to do so.
  
- **For performance**:
  - `ArrayDeque` is generally preferred over `LinkedList` for most deque use cases due to better memory and performance efficiency (faster access times and lower overhead).

---

## Conclusion

`Deque` is a highly versatile data structure in Java, allowing for both queue and stack-like operations. It supports insertion and removal of elements from both ends and is implemented by both `ArrayDeque` and `LinkedList`. `ArrayDeque` is the preferred implementation for performance reasons, especially when the queue size is dynamic and the insertion/removal operations are frequent.
