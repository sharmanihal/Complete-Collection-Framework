# Understanding `HashMap` in Java

## Overview
`HashMap` is part of the Java Collections Framework and implements the `Map` interface. It stores key-value pairs where keys are unique, but values can be duplicated. It is widely used because of its efficient constant time operations for `get()`, `put()`, and `remove()` methods. However, it is not synchronized, which means it is **not thread-safe**.

---

## Key Features of `HashMap`
1. **No Duplicate Keys**: Keys must be unique. If a key already exists, its associated value will be replaced.
2. **Allows Null Keys and Values**: You can have one null key and any number of null values.
3. **Order**: `HashMap` does not maintain the order of its elements. It uses a hash-based approach.
4. **Efficiency**: The average time complexity of `get()`, `put()`, and `remove()` operations is O(1), making `HashMap` fast for lookups and updates.

---

## Code Example

```java
package Collection.Map.HashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapDemo {
    public static void main(String[] args) {
        // Creating a HashMap to store Integer keys and String values
        HashMap<Integer, String> hashMap = new HashMap<>();
        
        // Adding key-value pairs to the HashMap
        hashMap.put(1, "Mike");
        hashMap.put(2, "John");
        hashMap.put(3, "David");
        hashMap.put(4, "Alice");

        // Printing the entire map
        System.out.println(hashMap); // Output: {1=Mike, 2=John, 3=David, 4=Alice}

        // Retrieving a value by key
        System.out.println(hashMap.get(2)); // Output: John
        System.out.println(hashMap.get(78)); // Output: null (key doesn't exist)

        // Checking if a key exists
        System.out.println(hashMap.containsKey(2)); // Output: true
        System.out.println(hashMap.containsKey(78)); // Output: false

        // Checking if a value exists
        System.out.println(hashMap.containsValue("Mike")); // Output: true
        System.out.println(hashMap.containsValue("Mikee")); // Output: false

        // Iterating through the map using keySet() method
        for (Integer rollNumber : hashMap.keySet()) {
            System.out.println(rollNumber + " " + hashMap.get(rollNumber));
        }

        // Using entrySet() to get key-value pairs
        Set<Map.Entry<Integer, String>> entries = hashMap.entrySet();
        for (Map.Entry<Integer, String> entry : entries) {
            // Modifying the values in the map
            entry.setValue(entry.getValue().toUpperCase());
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        // Using getOrDefault() to get a value or default if key doesn't exist
        System.out.println(hashMap.getOrDefault(5, "Not Found")); // Output: Not Found

        // Adding a null key
        hashMap.put(null, "Null Value");

        // Using putIfAbsent() to add a value only if key doesn't exist
        hashMap.putIfAbsent(5, "Mikee"); // Only adds if key 5 is absent
        // Replacing value for existing key
        hashMap.put(1, "Mikee");
        System.out.println(hashMap);

        // Removing a key-value pair by key
        hashMap.remove(null);

        // Remove key-value pair only if the value matches
        boolean removed = hashMap.remove(3, "Mikee"); // Output: false (no match)
        System.out.println(removed); // Output: false
    }
}
```

### **Internal Working of `HashMap`**

1. **Hashing the Key**: 
   - The key is passed through a hash function to generate a hash code.
2. **Index Calculation**: 
   - The hash code is used to calculate an index in the internal bucket array.
   - `index = hashcode % bucketArray.length`
3. **Bucket Array**:
   - The bucket array stores linked lists of key-value pairs. If two keys have the same hash code, they are stored in the same bucket (hash collision).
   - Since Java 8, if a bucket's list grows large (exceeds length 8), it is converted into a balanced tree structure for efficient lookups.

4. **Resizing**:
   - When the load factor exceeds a threshold (default 0.75), the `HashMap` resizes by doubling its capacity.

5. **Rehashing**:
   - When resizing occurs, all existing key-value pairs are rehashed to the new bucket array.

---

### **When to Use `HashMap`**
- When you need fast access to key-value pairs.
- When the order of the elements is not important.
- When thread safety is not a concern (since `HashMap` is not synchronized).

---

## Equality of Keys and `hashCode()` in `HashMap`

In `HashMap`, the keys' uniqueness is determined by two methods:
1. **`hashCode()`**: Determines the hash bucket for the key.
2. **`equals()`**: If two keys have the same hash code, their equality is checked using the `equals()` method.

---

### Code Example: `Custom Objects` with `hashCode()` and `equals()`

```java
package Collection.Map.HashMap;

import java.util.HashMap;
import java.util.Objects;

public class HashCodeDemo2 {
    public static void main(String[] args) {
        // Creating a HashMap with custom objects as keys
        HashMap<Person, String> map = new HashMap<>();
        
        // Creating Person objects
        Person p1 = new Person("Mike", 1);
        Person p2 = new Person("John", 2);
        Person p3 = new Person("David", 3);
        Person p4 = new Person("David", 3); // Same as p3
        
        // Adding the Person objects to the HashMap
        map.put(p1, "Engineer");
        map.put(p2, "Doctor");
        map.put(p3, "Teacher");
        map.put(p4, "Manager"); // Same as p3, so this will replace "Teacher"
        
        // Testing hashCode and equals for custom objects
        System.out.println(map.get(p3)); // Output: Manager (since p3 and p4 are considered equal)
        System.out.println(map.size()); // Output: 3 (p3 and p4 are considered the same key)
    }
}

class Person {
    private String name;
    private int id;

    // Constructor
    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    // Overriding hashCode to use name and id for hashing
    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.id);
    }

    // Overriding equals to compare Person objects based on name and id
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        Person p = (Person) obj;
        return this.id == p.id && this.name.equals(p.name);
    }

    // Overriding toString for better output readability
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
```

### Explanation of `hashCode()` and `equals()` in Custom Objects:
- **`hashCode()`**: Ensures that two `Person` objects with the same `name` and `id` return the same hash code, ensuring they are stored in the same bucket.
- **`equals()`**: Ensures that two `Person` objects with the same `name` and `id` are considered equal and will replace each other in the `HashMap`.

---

## Summary of `HashMap`:
- `HashMap` provides fast access to key-value pairs and allows null keys and values.
- It uses `hashCode()` and `equals()` to determine key uniqueness.
- Custom objects can be used as keys by overriding these methods.
- It is not synchronized, so thread safety should be handled externally if needed.
