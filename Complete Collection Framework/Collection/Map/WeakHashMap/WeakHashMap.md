# WeakHashMap in Java

## Overview

`WeakHashMap` is a special kind of map that uses weak references for its keys. This means that if a key is no longer in use by any other part of the program (except for the `WeakHashMap`), it can be garbage collected. `WeakHashMap` is particularly useful for caching scenarios where you want the keys (and their associated values) to be garbage collected when they are no longer in use.

- **Keys**: Weak references are used for the keys, meaning they are subject to garbage collection when there are no strong references to them.
- **Values**: The values in a `WeakHashMap` are strongly referenced, meaning they will not be garbage collected unless explicitly removed.

---

## Use Case Example

One common use case for `WeakHashMap` is caching, where you want to cache some objects but allow them to be cleared when no longer referenced elsewhere in the program. For instance, in this example, the `WeakHashMap` is used to store images in a video editing application where images are repeatedly used, and once they are no longer needed, they can be garbage collected.

---

## Code Example

```java
package Collection.Map.WeakHashMap;

import java.util.WeakHashMap;

public class WeakHashMapDemo {
    // WeakHashMap is a class that implements the Map interface and is a part of java.util package.
    public static void main(String[] args) {

        // Example: we are editing a video and using an image multiple times in the video
        // We can store that image in the cache so that we don't have to load it from the disk every time we need it
        // and when we are done and need other images we can remove the image from the cache and load the new image

        WeakHashMap<String, Image> imageCache = new WeakHashMap<>();
        imageCache.put("image1", new Image("image1"));
        imageCache.put("image2", new Image("image2"));

        // Display the current cache
        System.out.println("Cache before GC: " + imageCache);
        simulateMethodRunning();

        // These keys will be treated as weak references and JVM will remove them when garbage collection occurs
        // One issue here is that we are using string literals as keys, which are stored in the string pool
        // so they have a strong reference and will not be removed by the garbage collector.

        // To ensure the keys are removed by the garbage collector, we can use new String("image1") instead of "image1"
        System.out.println("Cache after some time (some entries may have been cleared): " + imageCache);
    }

    private static void simulateMethodRunning() {
        try {
            System.out.println("Simulating some work...");
            Thread.sleep(5000);  // Simulate some time passing
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class Image {
    private String name;

    public Image(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Image{" +
                "name='" + name + '\'' +
                '}';
    }
}
```

---

## Explanation of the Code

### WeakHashMap Behavior
- **`WeakHashMap<String, Image>`**:
  - In this example, the `WeakHashMap` stores images, where the keys are image names (e.g., "image1", "image2"), and the values are `Image` objects.
  - The key-value pairs in `WeakHashMap` use weak references for the keys, meaning the keys can be garbage collected when there are no strong references to them elsewhere in the program.

### Issue with String Literals
- **String literals**: In the example, `"image1"` and `"image2"` are string literals, which are stored in the string pool. String literals have a strong reference, meaning they are not eligible for garbage collection and won't be removed from the cache even when they are no longer in use.
  
### Simulating Garbage Collection
- The method `simulateMethodRunning()` simulates some work being done by sleeping for 5 seconds. After this period, we print the state of the cache again.
- If the keys were weak references and there were no strong references to them elsewhere in the program, the garbage collector would remove them, and the cache might be empty after the method finishes.

### Making Keys Eligible for Garbage Collection
- To ensure that the keys in the `WeakHashMap` are eligible for garbage collection, we can create keys using `new String("image1")` instead of the string literals `"image1"`. This way, the keys won't be in the string pool, and they will be weak references, allowing the garbage collector to clear them when no longer in use.

---

## When to Use `WeakHashMap`
1. **Caching**: When you need a cache where the cache entries (keys) can be removed when no longer in use.
2. **Memory Management**: When you want the garbage collector to remove keys automatically when they are no longer strongly referenced elsewhere in the program.

---

## Conclusion

`WeakHashMap` is useful in scenarios where the keys should be garbage collected automatically when they are no longer in use. It is commonly used in caching systems where the application needs to store objects temporarily and release them when no longer needed, without manual intervention. However, care must be taken with how keys are stored, especially with string literals, to ensure they are weakly referenced and eligible for garbage collection.
