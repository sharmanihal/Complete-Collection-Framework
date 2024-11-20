# Understanding `IdentityHashMap` in Java

## Overview
`IdentityHashMap` is a variant of `HashMap` that compares keys based on their **memory addresses** (using the `==` operator) instead of their `equals()` method. This makes it different from regular hash-based maps, where key comparison is done using the `equals()` method.

---

## Key Differences Between `HashMap` and `IdentityHashMap`
| **Feature**               | **HashMap**                                       | **IdentityHashMap**                                |
|---------------------------|--------------------------------------------------|---------------------------------------------------|
| **Key Comparison**         | Uses `equals()` method to compare keys           | Uses `==` (memory address comparison)             |
| **HashCode Calculation**   | Uses the `hashCode()` method of the key object   | Uses `System.identityHashCode()` (based on memory address) |
| **Equality**               | Based on content (logical equality)              | Based on identity (reference equality)            |

---

## How `IdentityHashMap` Works

- **Memory Address-Based Hashing**:
  - `IdentityHashMap` uses the `System.identityHashCode()` method, which generates a hash code based on the memory address of the object rather than its content.
- **Key Comparison Using `==`**:
  - In `IdentityHashMap`, keys are considered equal only if they refer to the same object in memory (reference equality), unlike `HashMap` that checks for logical equality (via `equals()`).

---

## Code Example

```java
package Collection.Map.IdentityHashMap;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;

public class IdentityHashMapDemo {
    public static void main(String[] args) {
        // HashMap Example with String Keys
        // The hash code of the string is based on the value, so key1 and key2 will be considered the same
        String key1 = new String("key");
        String key2 = new String("key");
        Map<String, Integer> map = new HashMap<>();
        map.put(key1, 1);
        map.put(key2, 2);
        System.out.println(map); // Output: {key=2}

        // IdentityHashMap Example with String Keys
        // IdentityHashMap uses memory address-based hashcode generation, so key3 and key4 are treated as different keys
        String key3 = new String("key");
        String key4 = new String("key");
        Map<String, Integer> map1 = new IdentityHashMap<>();
        map1.put(key3, 1);
        map1.put(key4, 2);
        System.out.println(map1); // Output: {key=1, key=2}

        // When we use the same key reference, only one entry is stored
        String key5 = "key";
        String key6 = "key";
        Map<String, Integer> map2 = new IdentityHashMap<>();
        map2.put(key5, 1);
        map2.put(key6, 2);
        System.out.println(map2); // Output: {key=2}

        // Identity hash codes based on memory address
        System.out.println(System.identityHashCode(key1)); // Unique hashcode
        System.out.println(System.identityHashCode(key2)); // Unique hashcode, different from key1

        System.out.println(System.identityHashCode(key5)); // Same hashcode as key6 because they refer to the same object
        System.out.println(System.identityHashCode(key6)); // Same hashcode as key5
    }
}
```

---

## Explanation of the Code

1. **HashMap Behavior**:
   - `key1` and `key2` are two different `String` objects with the same content ("key"), so when used as keys in a regular `HashMap`, the value for `key1` is replaced by the value of `key2` (since `equals()` considers the content the same).
   
2. **IdentityHashMap Behavior**:
   - `key3` and `key4` are two different `String` objects with the same content but are treated as different keys by `IdentityHashMap` because it compares memory addresses (reference equality). As a result, both `key3` and `key4` are added as separate entries in the map.
   
3. **Reference Equality in IdentityHashMap**:
   - When `key5` and `key6` refer to the same object (literal `"key"`), `IdentityHashMap` considers them the same and updates the value to the second entry.

4. **Hash Codes**:
   - The `System.identityHashCode()` method returns a unique hash code based on the memory address of the object, showing the difference between objects created using `new` (which will have different hash codes) and those using string literals (which will share the same memory address).

---

## Use Cases of `IdentityHashMap`

- **When Reference Equality is Needed**:
   - Useful when you need to distinguish objects based on their references (memory addresses) rather than their content (logical equality).
   
- **Cache Management or Identity-based Data Structures**:
   - Ideal for scenarios where data must be managed based on object identity (e.g., reference-based caching).

---

## Summary
`IdentityHashMap` offers a unique way to handle key comparisons based on the memory address of objects. It is particularly useful when you need to distinguish between objects that may appear equal based on their content but are actually distinct objects in memory.
