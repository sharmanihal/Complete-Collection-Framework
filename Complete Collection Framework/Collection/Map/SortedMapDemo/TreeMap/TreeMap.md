# SortedMap and TreeMap in Java

## Overview

`SortedMap` is an interface that extends the `Map` interface, which ensures that the entries in the map are sorted according to the natural ordering of the keys or by a custom comparator. The most common implementation of `SortedMap` is `TreeMap`, which is based on a red-black tree—a self-balancing binary search tree. The operations of `TreeMap` have a time complexity of `O(log n)`.

---

## Key Methods of `SortedMap`

- **`firstKey()`**: Returns the first (lowest) key in the map.
- **`lastKey()`**: Returns the last (highest) key in the map.
- **`headMap(K toKey)`**: Returns a view of the portion of the map whose keys are less than the specified `toKey`.
- **`tailMap(K fromKey)`**: Returns a view of the portion of the map whose keys are greater than or equal to the specified `fromKey`.
- **`subMap(K fromKey, K toKey)`**: Returns a view of the portion of the map whose keys are greater than or equal to `fromKey` and less than `toKey`.

---

## Code Example

```java
package Collection.Map.SortedMapDemo.TreeMap;

import java.util.SortedMap;
import java.util.TreeMap;

public class TreeMapDemo {
    public static void main(String[] args) {
        // SortedMap is an interface that extends the Map interface
        // SortedMap ensures that the entries are sorted based on the natural ordering of the keys or by specifying a comparator

        // Implementations of SortedMap are TreeMap
        // TreeMap uses a red-black tree to store the entries (self-balancing binary search tree)
        // time complexity of most of the operations is O(log n)
        SortedMap<String, Integer> studentMarks = new TreeMap<>();

        // it will sort the entries based on the natural ordering of the keys
        // in this case, it's the String class so it will use the compareTo method to sort the entries
        studentMarks.put("Bob", 80);
        studentMarks.put("David", 60);
        studentMarks.put("Charlie", 70);
        studentMarks.put("Alice", 90);

        // Printing the sorted map (sorted by natural ordering of the keys)
        System.out.println("Sorted Map (natural order): " + studentMarks); // {Alice=90, Bob=80, Charlie=70, David=60}

        // Custom sorting using a comparator (sort by string length)
        SortedMap<String, Integer> studentMarks2 = new TreeMap<>((s1, s2) -> {
            int lengthComparison = Integer.compare(s1.length(), s2.length());
            return lengthComparison != 0 ? lengthComparison : s1.compareTo(s2);
        });
        studentMarks2.put("Bob", 80);
        studentMarks2.put("David", 60);
        studentMarks2.put("Alice", 90);
        studentMarks2.put("Charlie", 70);

        // Printing the custom sorted map (sorted by the length of the keys)
        System.out.println("Sorted Map (custom order by length): " + studentMarks2); // {Bob=80, Alice=90, David=60, Charlie=70}

        // We could have also used the Map reference to refer to the TreeMap object
        // Map<String, Integer> studentMarks = new TreeMap<>();
        // The entries will still be sorted based on the natural ordering of the keys

        // SortedMap provides additional methods for convenience

        // firstKey() returns the first key in the sorted map
        System.out.println("First Key: " + studentMarks.firstKey()); // Alice
        // lastKey() returns the last key in the sorted map
        System.out.println("Last Key: " + studentMarks.lastKey()); // David
        // headMap() returns a view of the portion of the map whose keys are less than the specified key
        System.out.println("Head Map (less than 'Charlie'): " + studentMarks.headMap("Charlie")); // {Alice=90, Bob=80}
        // tailMap() returns a view of the portion of the map whose keys are greater than or equal to the specified key
        System.out.println("Tail Map (greater than or equal to 'Charlie'): " + studentMarks.tailMap("Charlie")); // {Charlie=70, David=60}
        // subMap() returns a view of the portion of the map whose keys are greater than or equal to the fromKey and less than the toKey
        System.out.println("Sub Map (from 'Bob' to 'David'): " + studentMarks.subMap("Bob", "David")); // {Bob=80, Charlie=70}
    }
}
```

---

## Explanation of the Code

### TreeMap and SortedMap

1. **TreeMap**:
   - `TreeMap` implements `SortedMap` and is backed by a red-black tree, which ensures that the map is always sorted based on the natural ordering of keys or a specified comparator.

2. **Sorting with Natural Ordering**:
   - In the first example, the keys (names of students) are sorted using their natural ordering (alphabetically in this case).

3. **Custom Sorting with Comparator**:
   - In the second example, the map is sorted based on the length of the keys (names of students). If two keys have the same length, they are sorted alphabetically.

### SortedMap Methods

- **`firstKey()`**: Returns the first (smallest) key in the map. In the example, "Alice" is the first key in alphabetical order.
- **`lastKey()`**: Returns the last (largest) key in the map. Here, "David" is the last key in alphabetical order.
- **`headMap(K toKey)`**: Returns a view of the portion of the map whose keys are less than the specified `toKey`. For example, `headMap("Charlie")` returns all entries before "Charlie" (excluding "Charlie").
- **`tailMap(K fromKey)`**: Returns a view of the portion of the map whose keys are greater than or equal to the specified `fromKey`. For example, `tailMap("Charlie")` returns "Charlie" and all entries after it.
- **`subMap(K fromKey, K toKey)`**: Returns a view of the portion of the map whose keys are greater than or equal to `fromKey` and less than `toKey`. In the example, `subMap("Bob", "David")` includes the entries for "Bob" and "Charlie", excluding "David".

---

## Use Cases for `SortedMap`

1. **Maintaining Sorted Data**:
   - `TreeMap` is ideal when you need to maintain a collection of entries sorted based on the natural order of keys or a custom order.

2. **Efficient Range Queries**:
   - Methods like `headMap()`, `tailMap()`, and `subMap()` provide convenient ways to access portions of the map based on key ranges.

3. **Custom Sorting**:
   - `TreeMap` allows for custom sorting with a comparator, making it versatile for use cases where the default natural ordering of keys is not sufficient.

---

## Conclusion

- `SortedMap` provides an easy way to keep the entries of a map sorted according to the keys, either naturally or by a custom comparator.
- `TreeMap`, a common implementation of `SortedMap`, supports fast lookups and operations like finding the first or last key, subsetting the map, and more.
- This makes `TreeMap` an excellent choice for applications that require sorted data or efficient range queries.
