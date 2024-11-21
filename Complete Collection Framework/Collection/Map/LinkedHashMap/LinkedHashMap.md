# LinkedHashMap in Java

## Overview
`LinkedHashMap` is a class that extends `HashMap` and implements the `Map` interface. It combines the benefits of a hash table and a linked list, allowing it to maintain the **insertion order** (or **access order** if specified) of entries. While it is not synchronized and, therefore, not thread-safe like `HashMap`, it offers predictable iteration order, which can be useful in many scenarios where order matters.

---

## Key Features of LinkedHashMap

- **Maintains Insertion Order**: The primary benefit of `LinkedHashMap` is its ability to maintain the order of entries based on their insertion sequence. This is achieved through the use of a doubly linked list.
- **Not Thread-Safe**: Like `HashMap`, `LinkedHashMap` is not synchronized. If thread safety is required, you can use `ConcurrentHashMap`.
- **Insertion and Access Order**: By default, `LinkedHashMap` maintains the **insertion order** of keys. However, you can configure it to maintain the **access order** (useful for implementing LRU caches).

---

## Code Example

```java
package Collection.Map.LinkedHashMap;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class LinkedHashMapDemo {
    public static void main(String[] args) {
        // LinkedHashMap extends HashMap and implements SequencedMap interface
        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>();

        // Using a regular HashMap (order is not maintained)
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Apple", 10);
        hashMap.put("Banana", 20);
        hashMap.put("Orange", 30);
        hashMap.put("Grapes", 40);

        // Iterating over HashMap (no order guaranteed)
        System.out.println("HashMap (No Order):");
        for (String key : hashMap.keySet()) {
            System.out.println(key + " " + hashMap.get(key));
        }

        // Using LinkedHashMap (insertion order is maintained)
        linkedHashMap.put("Apple", 10);
        linkedHashMap.put("Banana", 20);
        linkedHashMap.put("Orange", 30);
        linkedHashMap.put("Grapes", 40);

        // Iterating over LinkedHashMap (order is maintained)
        System.out.println("\nLinkedHashMap (Insertion Order):");
        for (String key : linkedHashMap.keySet()) {
            System.out.println(key + " " + linkedHashMap.get(key));
        }

        // How does LinkedHashMap maintain order?
        // It uses a doubly linked list to maintain insertion order.
        // Each entry is added to both the hash table and the linked list.
        // The list allows iteration in insertion order.

        //If we set access order to false, it will maintain insertion order (default)
        LinkedHashMap<String, Integer> linkedHashMap1 = new LinkedHashMap<>(16, 0.75f, false);

        // What happens when access order is set to true?
        // It maintains access order. The most recently accessed entry is moved to the end of the list.
        // This is useful for creating an LRU (Least Recently Used) cache.
    }
}
```

---

## Explanation of the Code

1. **HashMap**:
   - A `HashMap` is created and populated with key-value pairs (`Apple` → 10, `Banana` → 20, etc.).
   - When iterating over the `HashMap`, the order of keys is not guaranteed. `HashMap` does not maintain any order.

2. **LinkedHashMap**:
   - A `LinkedHashMap` is created with the same set of key-value pairs.
   - When iterating over the `LinkedHashMap`, the order of keys is maintained as per the insertion order. This is one of the key benefits of `LinkedHashMap`.

3. **Order Maintenance**:
   - `LinkedHashMap` maintains the order by using a **doubly linked list**. Each entry in the map is linked to the previous and next entry, allowing iteration in the order in which elements were added.
   
4. **Access Order (LRU Cache)**:
   - You can configure a `LinkedHashMap` to maintain **access order** instead of insertion order. This is achieved by setting the third constructor argument (`accessOrder`) to `true`.
   - When access order is enabled, each time an entry is accessed, it moves to the end of the list, making it the most recently used. This makes `LinkedHashMap` useful for implementing **Least Recently Used (LRU) caches**.

---

## Access Order and LRU Cache

- **Access Order**: When set to `true`, the `LinkedHashMap` maintains the order in which entries were last accessed. This is useful for cache implementations, where you want to keep the most recently used entries at the end of the map and potentially evict the least recently used entries.
  
- **LRU Cache**: This is a strategy for managing data where the least recently used entries are removed first when the cache reaches its limit. By using `LinkedHashMap` with access order set to `true`, you can implement an LRU cache that automatically evicts the least recently used entries.

---

## Use Cases

1. **Caching**: `LinkedHashMap` is ideal for implementing caching mechanisms, especially with access order (`true`) to maintain the order of usage.
2. **Maintaining Insertion Order**: When you need to maintain the order of elements as they are added to the map, `LinkedHashMap` provides a simple solution.
3. **Thread-Safe Alternatives**: If thread safety is required, consider using `ConcurrentHashMap` instead, as `LinkedHashMap` is not synchronized.

---

## Conclusion

- `LinkedHashMap` is a powerful variation of `HashMap` that maintains the order of insertion or access.
- It's useful when order matters, such as in caching, where access order can be leveraged to implement an LRU cache.
- However, it is **not thread-safe** by default, so alternatives like `ConcurrentHashMap` may be required in multi-threaded environments.
