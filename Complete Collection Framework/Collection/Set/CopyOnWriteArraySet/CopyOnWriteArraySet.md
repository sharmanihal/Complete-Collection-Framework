# `CopyOnWriteArraySet` and `ConcurrentSkipListSet` in Java

## Overview

- **`CopyOnWriteArraySet`**: A thread-safe set that uses an array for storage. It is part of the `java.util.concurrent` package. This implementation follows the copy-on-write strategy, which means:
  - **Write/Remove Operations**: These operations create a cloned copy of the underlying array and apply modifications to that copy. This ensures that iterations over the set are not affected by concurrent modifications.
  - **Iteration**: During iteration, modifications (like add/remove) do not affect the ongoing iteration, so no `ConcurrentModificationException` is thrown.
  
- **`ConcurrentSkipListSet`**: A thread-safe set based on a skip list. A skip list is a data structure that allows fast search, insertion, and deletion. 
  - **Concurrency Handling**: `ConcurrentSkipListSet` uses a lock-free algorithm to handle concurrency, allowing multiple threads to safely modify the set simultaneously.
  - **Sorted**: It maintains the elements in a sorted order.

### Key Properties

- **Thread Safety**: Both `CopyOnWriteArraySet` and `ConcurrentSkipListSet` are thread-safe, designed for use in concurrent environments.
- **Iteration**: 
  - `CopyOnWriteArraySet` avoids concurrent modification exceptions by making a copy of the underlying array during write operations.
  - `ConcurrentSkipListSet` ensures thread safety without locking by using a lock-free algorithm.
  
### Performance Considerations

- **`CopyOnWriteArraySet`**:
  - Best suited for cases where reads are far more frequent than writes, as it incurs overhead during write operations due to the array cloning process.
  - Efficient for scenarios where iteration is a frequent operation and the set's contents rarely change.
  
- **`ConcurrentSkipListSet`**:
  - Suitable for situations where you need sorted data with thread safety and frequent concurrent modifications.

---

## Code Example

```java
package Collection.Set.CopyOnWriteArraySet;

import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArraySet;

public class CopyOnWriteArraySetDemo {
    public static void main(String[] args) {
        // ConcurrentSkipListSet is a Set that uses a SkipList for storage
        // ConcurrentSkipListSet has a separate way of handling concurrency and is sorted based on keys
        // It uses a lock-free algorithm for concurrency handling

        // CopyOnWriteArraySet is a Set that uses an array for storage
        // Write and remove operations are done on a cloned copy of the array
        // During iteration, modifications won't reflect immediately

        CopyOnWriteArraySet<Integer> integerCopyOnWriteArraySet = new CopyOnWriteArraySet<>();
        ConcurrentSkipListSet<Integer> integerConcurrentSkipListSet = new ConcurrentSkipListSet<>();

        // Adding elements to both sets
        for (int i = 0; i < 10; i++) {
            integerCopyOnWriteArraySet.add(i);
            integerConcurrentSkipListSet.add(i);
        }

        // Displaying both sets
        System.out.println(integerCopyOnWriteArraySet); // Output: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
        System.out.println(integerConcurrentSkipListSet); // Output: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]

        // Modifying CopyOnWriteArraySet during iteration
        for (Integer num : integerCopyOnWriteArraySet) {
            System.out.println(num);
            integerCopyOnWriteArraySet.add(10); // No ConcurrentModificationException
        }

        // Displaying CopyOnWriteArraySet after modification
        System.out.println(integerCopyOnWriteArraySet); // Output: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

        // Modifying ConcurrentSkipListSet during iteration
        for (Integer num : integerConcurrentSkipListSet) {
            System.out.println(num);
            integerConcurrentSkipListSet.add(10); // No ConcurrentModificationException
            // 10 will be added at the end and iteration will see the 10 sometimes and sometimes not
        }

        // Displaying ConcurrentSkipListSet after modification
        System.out.println(integerConcurrentSkipListSet); // Output: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
    }
}
```

---

## Explanation of the Code

### 1. **CopyOnWriteArraySet**:
   - **Write Operations**: When an element is added or removed, a new copy of the array is created. This ensures that other threads can continue reading the set without interference, even if the set is being modified.
   - **Iteration**: Modifications (like adding an element) do not affect the ongoing iteration, so no `ConcurrentModificationException` occurs.
   
   ```java
   CopyOnWriteArraySet<Integer> integerCopyOnWriteArraySet = new CopyOnWriteArraySet<>();
   for (int i = 0; i < 10; i++) {
       integerCopyOnWriteArraySet.add(i);
   }
   System.out.println(integerCopyOnWriteArraySet); // Output: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]

   for (Integer num : integerCopyOnWriteArraySet) {
       System.out.println(num);
       integerCopyOnWriteArraySet.add(10); // No ConcurrentModificationException
   }

   System.out.println(integerCopyOnWriteArraySet); // Output: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
   ```

### 2. **ConcurrentSkipListSet**:
   - **Concurrency**: This set uses a lock-free algorithm, making it ideal for highly concurrent environments.
   - **Iteration**: Although modifications (like adding 10) happen during iteration, you might see the added element `10` depending on the timing of the modification. This demonstrates the concurrency feature of the set.
   
   ```java
   ConcurrentSkipListSet<Integer> integerConcurrentSkipListSet = new ConcurrentSkipListSet<>();
   for (int i = 0; i < 10; i++) {
       integerConcurrentSkipListSet.add(i);
   }
   System.out.println(integerConcurrentSkipListSet); // Output: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]

   for (Integer num : integerConcurrentSkipListSet) {
       System.out.println(num);
       integerConcurrentSkipListSet.add(10); // No ConcurrentModificationException
   }

   System.out.println(integerConcurrentSkipListSet); // Output: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
   ```

---

## Key Points:
- No Hashing: Unlike HashSet, which uses a hash table to store elements and handle collisions, CopyOnWriteArraySet does not involve any hash calculations or linked lists for collision resolution.

- Underlying Array: CopyOnWriteArraySet is backed by a CopyOnWriteArrayList. When you add an element, it checks if the element already exists in the list using the contains method, which uses the equals method to determine equality.

- Copy on Write: When a modification is made (such as adding or removing an element), a new copy of the underlying array is created, ensuring thread safety. This means every time you modify the set, a new array is created that includes the change

---
## Conclusion

- **`CopyOnWriteArraySet`**: Ideal for situations where iterations are more frequent than modifications. It avoids `ConcurrentModificationException` by copying the array for every modification.
- **`ConcurrentSkipListSet`**: Best for concurrent environments where thread safety is critical and you need sorted data. It handles concurrent modifications without locking and maintains a sorted order of elements.

Both of these sets are thread-safe and suitable for different use cases, depending on whether you need sorted order or a copy-on-write strategy for concurrent modification.
