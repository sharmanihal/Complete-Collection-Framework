# `Comparator` Interface in Java

## Overview

In Java, the `Comparator` interface is used to define custom comparison logic for objects. It is a functional interface, meaning it has only one abstract method `compare(T o1, T o2)` that compares two objects. This interface is used to sort or order objects based on user-defined criteria.

### `Comparator` Methods
- **`compare(T o1, T o2)`**: Compares two objects (`o1` and `o2`).
  - Returns a **negative integer** if `o1` is less than `o2`.
  - Returns **zero** if `o1` is equal to `o2`.
  - Returns a **positive integer** if `o1` is greater than `o2`.
  
Additionally, `Comparator` provides default methods like:
- **`reversed()`**: Returns a comparator that imposes the reverse order of the original comparator.
- **`thenComparing()`**: Allows chaining multiple comparisons for tie-breaking.

---

## Code Example

```java
package Collection.Comparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ComparatorDemo {
    public static void main(String[] args) {
        // Collection.List.ArrayList.Comparator is a functional interface used to compare two objects
        // Custom comparison logic can be implemented to control sorting

        List<String> words = new ArrayList<>(List.of("Apple", "Banana", "Orange", "Mango", "Pineapple", "Grapes"));
        
        // Sorting based on the length of strings (using custom Comparator)
        words.sort(new StringLengthComparator());
        System.out.println(words);

        // Using a lambda expression to sort by string length (larger length first)
        words.sort((o1, o2) -> o2.length() - o1.length());
        System.out.println(words);

        // Sorting first by length, then by natural order (if lengths are equal)
        words.sort((o1, o2) -> {
            if (o1.length() == o2.length()) {
                return o1.compareTo(o2);  // Compare alphabetically if lengths are equal
            }
            return o2.length() - o1.length();  // Compare by length in descending order
        });
        System.out.println(words);
    }
}

class StringLengthComparator implements Comparator<String> {
    // Sorting logic based on string length
    @Override
    public int compare(String o1, String o2) {
        return o1.length() - o2.length();  // Ascending order by length
    }
}
```

---

## Explanation of the Code

### 1. **Using `Comparator` to Sort by Length (Custom Comparator)**

- The class `StringLengthComparator` implements the `Comparator` interface, which compares two strings based on their length.
  - If the length of `o1` is smaller than `o2`, the result is negative, and `o1` will come before `o2`.
  - If the length is the same, we use the natural string order (`compareTo`).
  
   ```java
   class StringLengthComparator implements Comparator<String> {
       @Override
       public int compare(String o1, String o2) {
           return o1.length() - o2.length();  // Sort by length (ascending)
       }
   }
   ```

   **Output:**
   ```
   [Apple, Mango, Banana, Orange, Grapes, Pineapple]
   ```

### 2. **Using Lambda Expression to Sort by Length (Descending Order)**

- A more concise way to sort is using a lambda expression.
- The lambda expression `(o1, o2) -> o2.length() - o1.length()` sorts the strings by their length in descending order.
  
   ```java
   words.sort((o1, o2) -> o2.length() - o1.length());  // Larger length first
   ```

   **Output:**
   ```
   [Pineapple, Banana, Orange, Grapes, Mango, Apple]
   ```

### 3. **Chaining Comparisons (Length First, then Alphabetical Order)**

- To handle cases where two strings have the same length, you can chain comparisons. The first comparison is based on string length, and if the lengths are equal, we fall back to comparing alphabetically using `compareTo`.
  
   ```java
   words.sort((o1, o2) -> {
       if (o1.length() == o2.length()) {
           return o1.compareTo(o2);  // Alphabetical comparison if lengths are equal
       }
       return o2.length() - o1.length();  // Sort by length (descending)
   });
   ```

   **Output:**
   ```
   [Pineapple, Banana, Orange, Grapes, Mango, Apple]
   ```

---

## Custom Sorting Using `Comparator`
- **Using a `Comparator`** allows for flexible and custom sorting logic that isn't based on the natural ordering of objects. It is particularly useful when you need multiple sorting criteria or need to sort in a specific order.
  
  - **Example 1**: Sorting by string length.
  - **Example 2**: Sorting by multiple criteria (e.g., length, then alphabetically).
  - **Example 3**: Using `Comparator` with lambda expressions for more concise code.

## Benefits of Using `Comparator`
- Allows sorting objects based on custom rules.
- Can handle complex sorting logic, including multiple criteria.
- Supports both ascending and descending order sorting.
- Works seamlessly with Java Collections like `List`, `Set`, and `Map` that need sorting.

## Conclusion
The `Comparator` interface in Java is an essential tool for sorting objects in custom ways. By implementing custom sorting logic, either via a dedicated `Comparator` class or lambda expressions, you can easily control how objects are ordered in collections.
