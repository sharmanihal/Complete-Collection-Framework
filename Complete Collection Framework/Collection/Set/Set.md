# Set in Java

## Overview

A `Set` is a collection that does not allow duplicate elements. The `Set` interface extends the `Collection` interface and provides the basic set operations, including methods for adding, removing, and querying elements. 

### Key Properties of Set
- **No Duplicates**: A `Set` does not allow duplicate elements, which means any attempt to add a duplicate element will be ignored.
- **Unordered**: Most implementations of `Set` do not guarantee the order of elements (except in specific implementations like `LinkedHashSet` and `TreeSet`).
  
### Common Implementations of Set
- **`HashSet`**: A basic implementation of the `Set` interface. It does not guarantee any order of elements.
- **`LinkedHashSet`**: A `Set` that maintains the insertion order of elements.
- **`TreeSet`**: A `Set` that stores elements in sorted order according to their natural ordering or by a specified comparator.
- **`EnumSet`**: A `Set` designed for use with enum types.
- **`ConcurrentSkipListSet`**: A thread-safe, sorted set implementation.

### Important Methods
- **`add(e)`**: Adds an element to the set (returns `false` if the element already exists).
- **`remove(e)`**: Removes an element from the set.
- **`contains(e)`**: Checks if an element exists in the set.
- **`size()`**: Returns the number of elements in the set.
- **`isEmpty()`**: Checks if the set is empty.

---

## Code Example

```java
package Collection.Set;

import java.util.*;
import java.util.concurrent.ConcurrentSkipListSet;

public class SetOverview {
    // Set is a collection that does not allow duplicate elements
    public static void main(String[] args) {
        // Map -> HashMap, LinkedHashMap, TreeMap, WeakHashMap, IdentityHashMap, EnumMap
        // Set -> HashSet, LinkedHashSet, TreeSet, EnumSet

        // Example of HashSet (unordered Set)
        Set<Integer> set = new HashSet<>();
        // Since it implements Collection interface, it has all the methods of Collection interface
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(2); // Duplicate element, so it will not be added
        System.out.println(set); // Unordered output: [1, 2, 3]

        // Want ordered Set? Use LinkedHashSet
        Set<Integer> set1 = new LinkedHashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set1.add(2);
        System.out.println(set1); // Ordered output: [1, 2, 3]

        // Want sorted Set? Use TreeSet
        Set<Integer> set2 = new TreeSet<>();
        set2.add(12);
        set2.add(27);
        set2.add(33);
        set2.add(27); // Duplicate element, will not be added
        System.out.println(set2); // Sorted output: [12, 27, 33]

        // Similar to TreeMap, we also have NavigableSet, SortedSet here to give more functionalities
        SortedSet<Integer> sortedSet = new TreeSet<>();
        NavigableSet<Integer> navigableSet = new TreeSet<>();

        // All these above implementations are not thread-safe

        // ConcurrentSkipListSet is a thread-safe set implementation
        Set<Integer> concurrentSkipListSet = new ConcurrentSkipListSet<>();
        // It is a sorted set implementation (sorted in natural order of elements)

        // Unmodifiable set
        Set<Integer> unmodifiableSet = Collections.unmodifiableSet(set);
        // unmodifiableSet.add(4); // Throws UnsupportedOperationException
        // Set.of() method can also be used to create an unmodifiable set
        Set<Integer> unmodifiableSet1 = Set.of(1, 2, 3);
        // We can add more than 10 elements using Set.of() method
    }
}
```

---

## Explanation of the Code

### 1. **`HashSet`**:
   - A `HashSet` does not guarantee any specific order of the elements. It is ideal when you only care about uniqueness and do not require any specific ordering.
   ```java
   Set<Integer> set = new HashSet<>();
   set.add(1);
   set.add(2);
   set.add(3);
   set.add(2); // Duplicate, will not be added
   System.out.println(set); // Output: [1, 2, 3]
   ```

### 2. **`LinkedHashSet`**:
   - A `LinkedHashSet` maintains the order of elements as they are inserted (insertion order). It guarantees that elements are ordered in the sequence in which they were added.
   ```java
   Set<Integer> set1 = new LinkedHashSet<>();
   set1.add(1);
   set1.add(2);
   set1.add(3);
   set1.add(2); // Duplicate, will not be added
   System.out.println(set1); // Output: [1, 2, 3]
   ```

### 3. **`TreeSet`**:
   - A `TreeSet` stores elements in a sorted order based on their natural ordering (or a specified comparator). It eliminates duplicates and sorts the elements in ascending order.
   ```java
   Set<Integer> set2 = new TreeSet<>();
   set2.add(12);
   set2.add(27);
   set2.add(33);
   set2.add(27); // Duplicate, will not be added
   System.out.println(set2); // Output: [12, 27, 33]
   ```

### 4. **`SortedSet` and `NavigableSet`**:
   - `SortedSet` extends `Set` and provides methods to deal with sorted collections of elements. A `NavigableSet` extends `SortedSet` and adds methods to navigate the set, such as `lower()`, `higher()`, etc.
   ```java
   SortedSet<Integer> sortedSet = new TreeSet<>();
   NavigableSet<Integer> navigableSet = new TreeSet<>();
   ```

### 5. **`ConcurrentSkipListSet`**:
   - A `ConcurrentSkipListSet` is a thread-safe implementation of a `SortedSet`. It is ideal for multi-threaded environments where you need to ensure thread safety while maintaining sorted order.
   ```java
   Set<Integer> concurrentSkipListSet = new ConcurrentSkipListSet<>();
   ```

### 6. **Unmodifiable Sets**:
   - An unmodifiable set cannot be modified after creation. You can create one using `Collections.unmodifiableSet()` or the `Set.of()` method, which returns an immutable set.
   ```java
   Set<Integer> unmodifiableSet = Collections.unmodifiableSet(set);
   // unmodifiableSet.add(4); // Throws UnsupportedOperationException

   Set<Integer> unmodifiableSet1 = Set.of(1, 2, 3); // Unmodifiable set
   ```

---

## Conclusion

- **Set**: A collection that does not allow duplicate elements, making it ideal for ensuring uniqueness.
- **Implementations**:
  - `HashSet`: Unordered set.
  - `LinkedHashSet`: Ordered set (insertion order).
  - `TreeSet`: Sorted set (natural ordering or custom comparator).
  - `ConcurrentSkipListSet`: Thread-safe sorted set.
  - `EnumSet`: Set for enum types.
- **Methods**: Methods like `add()`, `remove()`, `contains()`, and `size()` provide functionality for manipulating and querying the set.

A `Set` is a powerful tool when working with unique elements and is a core part of Java’s collection framework.
