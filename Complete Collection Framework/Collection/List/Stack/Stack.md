# Understanding `Stack` in Java

## Overview
`Stack` is a **legacy class** that extends `Vector` and implements the `List` interface. It follows the **Last In First Out (LIFO)** principle. Though thread-safe, `Stack` is not commonly used in modern development, as there are more efficient alternatives such as `Deque` (via `LinkedList`).

---

## Key Characteristics of `Stack`
1. **Thread-Safe**:
   - Inherits synchronization from the `Vector` class.
2. **LIFO Principle**:
   - Elements are added and removed from the top of the stack.
3. **Legacy Class**:
   - Introduced in Java 1.0 and is now considered less suitable for single-threaded environments.

---

## Code

```java
package Collection.List.Stack;

import java.util.LinkedList;
import java.util.Stack;

public class StackDemo {
    public static void main(String[] args) {
        // Stack extends Vector and implements List interface
        // Thread-safe but slower due to synchronization
        Stack<Integer> stack = new Stack<>();

        // push() method to add elements
        stack.push(1);
        stack.push(2);

        // pop() method removes the top element
        System.out.println(stack.pop()); // Output: 2

        // peek() method retrieves the top element without removing it
        System.out.println(stack.peek()); // Output: 1

        // search() method returns the 1-based position of an element
        System.out.println(stack.search(1)); // Output: 1
        System.out.println(stack.search(3)); // Output: -1

        // Using LinkedList as a stack in single-threaded environments
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.push(1);
        linkedList.push(2);
        linkedList.push(3);
        linkedList.push(4);

        // LinkedList methods
        System.out.println("Pop : " + linkedList.pop()); // Output: 4
        System.out.println("Peek : " + linkedList.peek()); // Output: 3
    }
}
```

---

## Comprehensive Notes

### Key Features of `Stack`
1. **Core Methods**:
   - **`push(E element)`**:
     - Adds an element to the top of the stack.
   - **`pop()`**:
     - Removes and returns the top element.
   - **`peek()`**:
     - Retrieves the top element without removing it.
   - **`search(Object element)`**:
     - Searches for an element and returns its 1-based position from the top of the stack.
     - Returns `-1` if the element is not found.
2. **Thread-Safe**:
   - Synchronization ensures safe access in multi-threaded environments but adds overhead.
3. **Legacy Class**:
   - Part of Java since version 1.0 and now largely replaced by `Deque` in `java.util`.

---

### Comparison: `Stack` vs `LinkedList` as a Stack

| Feature                | `Stack`                 | `LinkedList`            |
|------------------------|-------------------------|-------------------------|
| **Thread Safety**      | Synchronized           | Not thread-safe         |
| **Performance**        | Slower due to locks    | Faster for single-threaded environments |
| **Flexibility**        | Limited functionality  | More general-purpose as it supports queue operations too |
| **Preferred Use Case** | Multi-threaded         | Single-threaded         |

---

### Using `LinkedList` as a Stack

#### Example:
```java
LinkedList<Integer> linkedList = new LinkedList<>();
linkedList.push(1);
linkedList.push(2);
linkedList.push(3);

// Stack-like operations
System.out.println("Pop : " + linkedList.pop()); // Output: 3
System.out.println("Peek : " + linkedList.peek()); // Output: 2
```

#### Why Use `LinkedList`?
- **Performance**:
  - Faster in single-threaded environments as it avoids synchronization.
- **Flexibility**:
  - Can be used as both a stack and a queue.

---

## Summary
1. **When to Use `Stack`**:
   - Use in multi-threaded environments where thread safety is essential.
2. **When to Use `LinkedList`**:
   - Use in single-threaded environments for better performance.
3. **Modern Alternative**:
   - Prefer `Deque` over `Stack` as it is more efficient and versatile.

---

## Key Takeaway
While `Stack` provides thread safety, it is generally outdated for most use cases. In modern Java, `Deque` (via `LinkedList` or `ArrayDeque`) is the preferred choice for implementing stack-like behavior.
