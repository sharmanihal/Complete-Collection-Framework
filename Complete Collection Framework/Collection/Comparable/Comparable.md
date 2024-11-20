# `Comparable` Interface in Java

## Overview

The `Comparable` interface in Java is used to provide a **natural ordering** for objects of a class. It defines the method `compareTo(T o)` which compares the current object (`this`) with another object (`o`). If a class implements `Comparable`, you can directly use `Collections.sort()` or `Arrays.sort()` to sort its objects without needing an external comparator.

### `Comparable` vs `Comparator`
- **`Comparable`**: Provides a natural comparison between objects. It is used when you want to define a default sorting order for objects of a class.
- **`Comparator`**: Provides a custom comparison logic. It is used when you want to sort objects in a way other than the natural order or when multiple comparison criteria are needed.

## Key Method
- **`compareTo(T o)`**: Compares the current object with the specified object (`o`).
  - Returns a **negative integer** if the current object is less than the specified object.
  - Returns **zero** if both objects are equal.
  - Returns a **positive integer** if the current object is greater than the specified object.

---

## Code Example

```java
package Collection.Comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparableDemo {
    public static void main(String[] args) {
        // Comparable is used to define a natural ordering for objects of a class

        // Create some student objects with name and age fields
        Student s1 = new Student("Mike", 20);
        Student s2 = new Student("John", 22);
        Student s3 = new Student("David", 21);
        Student s4 = new Student("Adam", 21);

        List<Student> students = new ArrayList<>(List.of(s1, s2, s3, s4));

        // Sort the students based on their names (using Comparable's compareTo method)
        Collections.sort(students);  // Will use compareTo implemented in Student class
        System.out.println("Students sorted by name: " + students);

        // Now, sort students based on age using a custom Comparator
        students.sort((o1, o2) -> o2.getAge() - o1.getAge());  // Sort by age (descending order)
        System.out.println("Students sorted by age: " + students);
    }
}

class Student implements Comparable<Student> {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Compare students based on their name
    @Override
    public int compareTo(Student o) {
        return this.name.compareTo(o.name);  // Sorting by name in ascending order
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
```

---

## Explanation of the Code

### 1. **Using `Comparable` to Sort Students by Name**

The `Student` class implements the `Comparable` interface and provides the `compareTo` method to sort students based on their **name**.
- The `compareTo` method compares the `name` field of two `Student` objects using `String.compareTo()`. This defines the **natural ordering** of `Student` objects.

```java
@Override
public int compareTo(Student o) {
    return this.name.compareTo(o.name);  // Sorting by name in ascending order
}
```

When we call `Collections.sort(students)`, the students will be sorted alphabetically by their name because of the `compareTo` method.

**Output:**
```
Students sorted by name: [Student{name='Adam', age=21}, Student{name='David', age=21}, Student{name='John', age=22}, Student{name='Mike', age=20}]
```

### 2. **Using `Comparator` to Sort Students by Age**

While `Comparable` allows sorting by one field (in this case, the name), we can also use `Comparator` for custom sorting logic. In this case, we want to sort students by **age** in **descending order**.

```java
students.sort((o1, o2) -> o2.getAge() - o1.getAge());  // Sort by age (descending order)
```

This lambda expression sorts the students based on their age in **descending order** (larger age first).

**Output:**
```
Students sorted by age: [Student{name='John', age=22}, Student{name='Mike', age=20}, Student{name='David', age=21}, Student{name='Adam', age=21}]
```

---

## Key Points about `Comparable` and `Comparator`

### 1. **`Comparable` Interface**
- Used for **natural ordering** of objects.
- Defines a **single default comparison method** (`compareTo`).
- If you only need one sorting criterion, such as sorting by name or by age, **`Comparable`** is often enough.

### 2. **`Comparator` Interface**
- Used for **custom sorting** logic.
- Allows multiple sorting criteria or sorting in different orders (e.g., ascending or descending).
- **`Comparator`** can be used in conjunction with `Collections.sort()` or `List.sort()`.

### 3. **`compareTo` Method**
- The return value of `compareTo` is used to determine the sorting order:
  - **Negative**: `this` object is less than `o`.
  - **Zero**: `this` object is equal to `o`.
  - **Positive**: `this` object is greater than `o`.

---

## Conclusion

The `Comparable` interface in Java is a powerful way to define the default sorting behavior for objects of a class. By implementing `compareTo`, you can easily control how objects are compared and sorted. When more complex sorting logic is needed, `Comparator` provides an external way to define custom comparison rules. Both `Comparable` and `Comparator` are essential tools for managing and sorting data in Java collections.
