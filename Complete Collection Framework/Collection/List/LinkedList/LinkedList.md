# Understanding `LinkedList` in Java

## Overview
The `LinkedList` class in Java is a part of the `java.util` package and implements the `List` and `Deque` interfaces. It is designed for scenarios requiring frequent insertions and deletions. Unlike `ArrayList`, which uses a dynamic array, `LinkedList` is implemented as a **doubly linked list**.

---

## Key Characteristics of `LinkedList`
1. **Order Maintenance**: Maintains the insertion order of elements.
2. **Doubly Linked List**:
   - Stores elements in nodes containing data and references to the next and previous nodes.
3. **Better for Insertions/Deletions**:
   - Efficient for operations like adding/removing elements at the beginning, middle, or end.
4. **Slower for Index-based Access**:
   - `get(index)` requires traversal from the start of the list to the specified index (O(n)).

---

## Code

```java
package Collection.List.LinkedList;

import java.util.LinkedList;
import java.util.List;

public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();

        // Adding elements
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        System.out.println(linkedList);

        // Accessing elements by index
        System.out.println(linkedList.get(2));

        // Adding element at a specific index
        linkedList.add(2, 5);

        // Adding at the start and end
        linkedList.addFirst(10); // O(1)
        linkedList.addLast(20);  // O(1)

        // Accessing the first and last elements
        System.out.println(linkedList.getFirst());
        System.out.println(linkedList.getLast());

        // Removing elements
        System.out.println(linkedList.removeFirst()); // Removes first element
        System.out.println(linkedList.remove

        // Removes last element
        System.out.println(linkedList.removeLast());

        // Removing first and last occurrences of specific elements
        System.out.println(linkedList.removeFirstOccurrence(1));
        System.out.println(linkedList.removeLastOccurrence(2));

        // Removing elements based on a condition
        linkedList.removeIf(x -> x % 2 == 0);

        // Removing all elements that exist in another collection
        List<Integer> nums = List.of(3, 4, 5);
        linkedList.removeAll(nums);

        // Iterating using a for-each loop
        for (Integer i : linkedList) {
            System.out.println(i);
        }
    }
}
```

---

## Comprehensive Notes

### Adding Elements
- **`add(E e)`**: Appends the element to the end of the list.
- **`add(int index, E element)`**: Inserts the element at the specified index.
- **`addFirst(E e)`**: Inserts the element at the beginning of the list (O(1)).
- **`addLast(E e)`**: Appends the element to the end of the list (O(1)).

### Accessing Elements
- **`get(int index)`**: Retrieves the element at the specified position (O(n)).
- **`getFirst()`**: Retrieves the first element (O(1)).
- **`getLast()`**: Retrieves the last element (O(1)).

### Removing Elements
- **`removeFirst()`**: Removes and returns the first element (O(1)).
- **`removeLast()`**: Removes and returns the last element (O(1)).
- **`removeFirstOccurrence(Object o)`**: Removes the first occurrence of the specified element.
- **`removeLastOccurrence(Object o)`**: Removes the last occurrence of the specified element.
- **`removeIf(Predicate<? super E> filter)`**: Removes all elements that satisfy the given condition.
- **`removeAll(Collection<?> c)`**: Removes all elements present in the specified collection.

### Iterating Over Elements
Use a `for-each` loop for traversal:
```java
for (Integer i : linkedList) {
    System.out.println(i);
}
```

---

## Performance Comparison: `LinkedList` vs. `ArrayList`
| Feature              | `LinkedList`             | `ArrayList`           |
|----------------------|--------------------------|-----------------------|
| **Storage**          | Doubly linked list       | Dynamic array         |
| **Insertion/Deletion** | Efficient at beginning or middle (O(1) for head/tail) | Inefficient (O(n)) at non-end positions |
| **Access by Index**  | Inefficient (O(n))       | Efficient (O(1))      |
| **Iteration**        | Slower due to traversal  | Faster                |



---

## Summary
`LinkedList` is ideal for:
1. Frequent insertions and deletions.
2. Scenarios requiring a queue or deque.

However, for frequent random access, prefer `ArrayList`. Use `LinkedList` for cases where node traversal is acceptable, and memory consumption is not a primary concern.
