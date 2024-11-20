# NavigableMap in Java

## Overview
`NavigableMap` is an interface in Java that extends `SortedMap`. It provides additional navigation methods for finding keys based on a search criterion (e.g., nearest lower or higher keys). These methods make it more versatile than `SortedMap` when you need to perform operations like retrieving keys in reverse order or finding the closest match to a given key.

In the code below, a `TreeMap` is used, which implements the `NavigableMap` interface, making it capable of performing all the navigation operations defined in `NavigableMap`.

---

## Key Methods of `NavigableMap`

- **`lowerKey(K key)`**: Returns the greatest key strictly less than the specified key.
- **`ceilingKey(K key)`**: Returns the least key greater than or equal to the specified key.
- **`higherKey(K key)`**: Returns the least key strictly greater than the specified key.
- **`descendingMap()`**: Returns a view of the map in reverse order (i.e., from the highest to the lowest key).

---

## Code Example

```java
package Collection.Map.NavigableMap;

import java.util.NavigableMap;
import java.util.TreeMap;

public class NavigableMapDemo {
    // NavigableMap is an interface that extends SortedMap
    // It provides more powerful navigation options, such as
    // finding the closest matching key or retrieving the map in reverse order.

    public static void main(String[] args) {
        NavigableMap<Integer, String> navigableMap = new TreeMap<>();
        navigableMap.put(1, "One");
        navigableMap.put(6, "Six");
        navigableMap.put(3, "Three");
        navigableMap.put(7, "Seven");

        // Printing the NavigableMap
        System.out.println("NavigableMap: " + navigableMap);

        // lowerKey - Returns the greatest lower key than 4
        System.out.println("lowerKey(4): " + navigableMap.lowerKey(4));  // Expected output: 3

        // ceilingKey - Returns the equal or next greatest key than 4
        System.out.println("ceilingKey(4): " + navigableMap.ceilingKey(4));  // Expected output: 6

        // higherEntry - Returns the entry greater than 1
        System.out.println("higherEntry(1): " + navigableMap.higherEntry(1));  // Expected output: (3, "Three")

        // descendingMap - Returns the map in reverse order
        System.out.println("Descending Map: " + navigableMap.descendingMap());
    }
}
```

---

## Explanation of the Code

1. **TreeMap as NavigableMap**:
   - `TreeMap` implements the `NavigableMap` interface, which allows you to perform various navigation operations based on the keys.
   
2. **Navigation Operations**:
   - **`lowerKey(4)`**: Finds the largest key strictly less than 4. In this case, it returns 3 since 3 is the highest key that is smaller than 4.
   - **`ceilingKey(4)`**: Finds the least key that is greater than or equal to 4. It returns 6 because 6 is the smallest key that is greater than or equal to 4.
   - **`higherEntry(1)`**: Finds the entry with the smallest key greater than 1. In this case, it returns the entry `(3, "Three")`.
   - **`descendingMap()`**: Returns a reversed view of the map, i.e., it lists the entries from the largest key to the smallest key.

---

## Use Cases for `NavigableMap`

1. **Range Queries**:
   - `NavigableMap` can be very useful when you need to retrieve a subset of entries within a certain range of keys. Methods like `subMap()`, `headMap()`, and `tailMap()` are also part of the `NavigableMap` interface.
   
2. **Navigating Closest Keys**:
   - If you need to find the nearest key above or below a specified value (such as in a search algorithm or a nearest neighbor problem), the `lowerKey()`, `ceilingKey()`, and `higherKey()` methods are extremely helpful.
   
3. **Reverse Iteration**:
   - Using the `descendingMap()` method, you can easily iterate over the map in reverse order. This is useful when you need to perform operations starting from the highest key.

---

## Conclusion

- `NavigableMap` offers more powerful navigation features than `SortedMap`, making it ideal for applications that need advanced querying capabilities.
- Methods like `lowerKey()`, `ceilingKey()`, and `higherKey()` provide efficient ways to find the closest matching keys, while `descendingMap()` allows for reverse-order iteration.
- If your use case requires sorted keys with these additional navigation features, `TreeMap` (which implements `NavigableMap`) is the right choice.
