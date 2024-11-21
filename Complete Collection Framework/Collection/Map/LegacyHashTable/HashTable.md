
# Understanding HashTable in Java

## Overview
`HashTable` is a **legacy class** in Java that implements the `Map` interface. It provides a thread-safe, synchronized map for storing key-value pairs. Despite its synchronization advantages, it is generally considered less efficient compared to modern alternatives like `HashMap` or `ConcurrentHashMap`.

---

## Key Features of HashTable

- **Synchronized**: All methods of `HashTable` are synchronized, making it thread-safe. However, this synchronization can lead to performance overhead due to locking mechanisms that restrict concurrent access to the entire map. In Java's Hashtable, both read and write operations are synchronized to ensure thread safety. This means that all operations that interact with the data structure are locked to prevent concurrent access issues.
- **No Null Keys or Values**: Unlike `HashMap`, `HashTable` does not allow `null` as a key or a value. Attempting to insert a `null` key or value will throw a `NullPointerException`.
- **Thread-Safe**: Due to its synchronization, `HashTable` is considered thread-safe for multiple threads accessing it concurrently.
- **Slower than HashMap**: Since it synchronizes every operation, `HashTable` tends to be slower than `HashMap`, especially in single-threaded environments.
- **Outdated**: It has been largely replaced by `ConcurrentHashMap`, which is more efficient for multi-threaded applications.

---

## Code Example

```java
package Collection.Map.LegacyHashTable;

import java.util.Hashtable;

public class HashTableDemo {
    public static void main(String[] args) {
        // HashTable is a legacy class that implements the Map interface
        // HashTable is synchronized and thread-safe
        // Does not allow null keys or values

        // Creating a Hashtable
        Hashtable<Integer, String> hashtable = new Hashtable<>();
        hashtable.put(1, "One");
        hashtable.put(2, "Two");

        // Retrieving values from the Hashtable
        System.out.println(hashtable.get(1));  // Output: One

        // Checking if the Hashtable contains a specific key
        System.out.println(hashtable.containsKey(1));  // Output: true

        // Checking if the Hashtable contains a specific value
        System.out.println(hashtable.containsValue("One"));  // Output: true

        // Removing an entry from the Hashtable
        hashtable.remove(1);  
        System.out.println(hashtable);  // Output: {2=Two}

        // Demonstrating thread-safety with multiple threads
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                hashtable.put(i, String.valueOf(i));
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 1000; i < 2000; i++) {
                hashtable.put(i, String.valueOf(i));
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // The size of the Hashtable will be 2000 after both threads finish execution
        System.out.println(hashtable.size());  // Output: 2000
    }
}
```

---

## Explanation of the Code

1. **Creating a `HashTable`**:
   - A `Hashtable` is created and populated with key-value pairs: `1 -> "One"` and `2 -> "Two"`.
   - Methods like `get()`, `containsKey()`, `containsValue()`, and `remove()` work similarly to those in `HashMap`.

2. **Thread Safety**:
   - Two threads (`t1` and `t2`) are created to demonstrate thread safety. Each thread tries to add 1000 key-value pairs to the `Hashtable`.
   - The `join()` method ensures that the main thread waits for both threads to complete before checking the size of the `Hashtable`. Since `Hashtable` is synchronized, the final size is 2000, indicating that both threads successfully added entries.

3. **Performance Comparison**:
   - Even though `Hashtable` is thread-safe, the synchronization causes performance overhead. In scenarios where thread safety is not required, `HashMap` or `ConcurrentHashMap` is preferred.

---

## Important Notes

- **Thread Safety**: `Hashtable` locks the entire map for both read and write operations. This can cause performance issues in multi-threaded environments, as threads must wait for access to the map.
  
- **Replaced by `ConcurrentHashMap`**: For better performance and fine-grained locking, it is recommended to use `ConcurrentHashMap`, which provides thread safety without locking the entire map.

- **No Null Keys or Values**: Unlike `HashMap`, `Hashtable` does not allow `null` keys or values. Attempting to insert a `null` will throw a `NullPointerException`.

- **Legacy Class**: `Hashtable` is considered a legacy class, and its use is discouraged in favor of more modern alternatives.

