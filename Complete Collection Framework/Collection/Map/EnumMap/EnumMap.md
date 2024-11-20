# Understanding `EnumMap` in Java

## Overview
`EnumMap` is a specialized implementation of the `Map` interface for use with keys that are **enum constants**. It is highly optimized for this purpose and more efficient than general-purpose maps like `HashMap`.

---

## Features of `EnumMap`
1. **Keys are Enum Constants**:
   - The keys must all be of a single enum type.
2. **Order is Maintained**:
   - Keys are maintained in the natural order of their enum declaration.
3. **Efficiency**:
   - Since all possible keys are known in advance, `EnumMap` uses a compact array-based representation.
4. **No Hashing**:
   - Instead of generating hash codes, keys are mapped directly to their ordinal values (indexes in the enum).

---

## Key Differences Between `EnumMap` and `HashMap`
| **Feature**               | **EnumMap**                                     | **HashMap**                                    |
|---------------------------|------------------------------------------------|-----------------------------------------------|
| **Key Type**              | Only enum constants                            | Any object                                    |
| **Performance**           | Faster due to ordinal-based key mapping        | Relatively slower due to hashing             |
| **Order**                 | Maintains the natural order of enum constants  | Does not guarantee order                     |
| **Memory Efficiency**     | More compact, as it uses an array-based design | Requires more memory for hash table storage  |

---

## Code Example

```java
package Collection.Map.EnumMap;

import java.util.EnumMap;
import java.util.Map;

public class EnumMapDemo {
    public static void main(String[] args) {
        // Create an EnumMap with Days as the key type
        Map<Days, String> map = new EnumMap<>(Days.class);

        // Demonstrate ordinal value (index in the enum)
        System.out.println(Days.THURSDAY.ordinal()); // Output: 3

        // Add key-value pairs to the map
        map.put(Days.TUESDAY, "Work");
        map.put(Days.MONDAY, "Gym");

        // EnumMap maintains the order of keys as per their declaration in the enum
        System.out.println(map); // Output: {MONDAY=Gym, TUESDAY=Work}
    }
}

// Enum defining the days of the week
enum Days {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}
```

---

## Advantages of `EnumMap`
1. **Performance**:
   - Faster operations due to ordinal-based key mapping.
2. **Compact Representation**:
   - Minimal memory usage compared to `HashMap`.
3. **Order Maintenance**:
   - Keys are stored in the same order as their enum definition.

---

## Limitations of `EnumMap`
1. **Restrictive Key Type**:
   - Only works with enums as keys.
2. **Not Thread-Safe**:
   - Requires external synchronization in multithreaded environments.

---

## When to Use
- When all keys in the map are known enum constants.
- When performance and memory efficiency are critical.
- When the natural order of enum constants is required.

---

## Summary
`EnumMap` is an excellent choice for scenarios where enum constants are used as keys. It is efficient, maintains key order, and avoids collisions by directly mapping keys to their ordinal values.
