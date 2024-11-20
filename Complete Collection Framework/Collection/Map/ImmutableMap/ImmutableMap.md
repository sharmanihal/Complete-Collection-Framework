# Understanding Immutable Maps in Java

## Overview
In Java, an **immutable map** refers to a map whose contents cannot be modified once it is created. This means that after construction, you cannot add, remove, or update the entries in the map. Immutable maps are often used when you want to ensure that the map's contents remain constant throughout the application's lifecycle.

---

## Key Methods to Create Immutable Maps

1. **Using `Collections.unmodifiableMap()`**:
   - This method allows you to create an unmodifiable (immutable) version of an existing map. Any attempt to modify the map (like adding or removing entries) will result in an `UnsupportedOperationException`.

2. **Using `Map.of()`**:
   - `Map.of()` is used to create a map with up to 10 key-value pairs. The map is immutable, and attempts to modify it will throw an exception.

3. **Using `Map.ofEntries()`**:
   - If you need to create an immutable map with more than 10 key-value pairs, `Map.ofEntries()` allows you to do so. This method takes `Map.Entry` pairs as arguments.

---

## Code Example

```java
package Collection.Map.ImmutableMap;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ImmutableMapDemo {
    public static void main(String[] args) {
        // ImmutableMap is a map that once constructed, cannot be modified.
        
        // Creating a modifiable map
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("a", 1);
        map1.put("b", 2);

        // Creating an unmodifiable copy of the map
        Map<String, Integer> stringIntegerMap = Collections.unmodifiableMap(map1);

        // Uncommenting the following line will throw an UnsupportedOperationException
        // stringIntegerMap.put("c", 3);  // UnsupportedOperationException

        // Creating an immutable map using Map.of() with up to 10 key-value pairs
        Map<String, Integer> stringIntegerMap1 = Map.of("a", 1, "b", 2);
        
        // Uncommenting the following line will throw an UnsupportedOperationException
        // stringIntegerMap1.put("c", 3);  // UnsupportedOperationException

        // Creating an immutable map with more than 10 entries using Map.ofEntries()
        Map<String, Integer> stringIntegerMap2 = Map.ofEntries(
            Map.entry("a", 1), 
            Map.entry("b", 2), 
            Map.entry("c", 3)
        );

        // Attempting to modify any of the maps will throw UnsupportedOperationException
        // stringIntegerMap2.put("d", 4);  // UnsupportedOperationException
    }
}
```

---

## Explanation of the Code

1. **Using `Collections.unmodifiableMap()`**:
   - A `HashMap` (`map1`) is created and populated with key-value pairs. 
   - `Collections.unmodifiableMap(map1)` creates an unmodifiable copy of `map1`. Any attempt to modify the map after it has been created will throw an `UnsupportedOperationException`.

2. **Using `Map.of()`**:
   - `Map.of()` is used to create an immutable map with two entries: `"a" -> 1` and `"b" -> 2`. 
   - The map is immutable, and attempting to modify it (e.g., by adding a new key-value pair) will throw an exception.

3. **Using `Map.ofEntries()`**:
   - This method allows you to create a map with more than 10 entries. In this case, it creates a map with three entries (`"a" -> 1`, `"b" -> 2`, `"c" -> 3`).
   - The map created by `Map.ofEntries()` is immutable and cannot be modified.

---

## Summary

- **Immutable Maps** are useful when you want to ensure that the map's data remains constant throughout the application's lifetime.
- **`Collections.unmodifiableMap()`** creates an unmodifiable view of an existing map.
- **`Map.of()`** is convenient for creating immutable maps with up to 10 entries.
- **`Map.ofEntries()`** allows you to create immutable maps with more than 10 entries.
