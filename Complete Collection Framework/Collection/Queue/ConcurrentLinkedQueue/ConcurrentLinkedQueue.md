# ConcurrentLinkedQueue in Java

## Overview

`ConcurrentLinkedQueue` is an implementation of the `Queue` interface that provides **lock-free** and **thread-safe** operations. Unlike blocking queues, which wait for elements to be added or removed, the `ConcurrentLinkedQueue` allows multiple threads to perform **non-blocking** insertions and removals simultaneously.

### Key Features:
- **Lock-Free**: The queue supports lock-free operations, meaning threads do not have to block each other when adding or removing elements.
- **Thread-Safe**: Multiple threads can interact with the queue concurrently without causing data inconsistency.
- **Non-blocking Operations**: The queue allows multiple threads to perform operations such as adding or removing elements simultaneously.
- **Compare and Swap**: The `ConcurrentLinkedQueue` uses an atomic compare-and-swap mechanism to ensure thread safety when modifying the queue.

---

## Code Example

```java
package Collection.Queue.ConcurrentLinkedQueue;

import java.util.concurrent.ConcurrentLinkedQueue;

public class ConcurrentLinkedQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        // ConcurrentLinkedQueue is a thread-safe, lock-free queue
        // Used for non-blocking, concurrent insertions and removals

        ConcurrentLinkedQueue<String> tasks = new ConcurrentLinkedQueue<>();

        // Producer thread that adds tasks to the queue
        Thread producer = new Thread(() -> {
            while (true) {
                tasks.add("Task" + System.currentTimeMillis());  // Add new task with a timestamp
            }
        });

        // Consumer thread that removes and processes tasks from the queue
        Thread consumer = new Thread(() -> {
            while (true) {
                String task = tasks.poll();  // Non-blocking poll
                if (task != null) {
                    System.out.println("Consuming " + task);  // Process the task
                }
            }
        });

        // Start producer and consumer threads
        producer.start();
        consumer.start();

        // Wait for threads to finish (they run indefinitely in this case)
        producer.join();
        consumer.join();
    }
}
```

---

## Explanation of the Code

### 1. **Producer Thread**
   - The producer continuously adds new tasks to the `ConcurrentLinkedQueue` by calling the `add()` method. 
   - The task is a string that includes the current time (`System.currentTimeMillis()`) to ensure uniqueness.

### 2. **Consumer Thread**
   - The consumer continuously attempts to remove tasks from the queue using the `poll()` method.
   - The `poll()` method retrieves and removes the head of the queue, or returns `null` if the queue is empty. It is a non-blocking operation, meaning it does not wait for an element to be available.

### 3. **Lock-Free Operations**
   - Both the `add()` and `poll()` methods in `ConcurrentLinkedQueue` are designed to be thread-safe without using locks.
   - The queue uses **compare-and-swap (CAS)** operations to ensure thread safety. When adding or removing an element, it checks if the queue is in the expected state (e.g., if the tail is still the same before adding an element) and performs the operation atomically if the state is valid.

### 4. **Thread Execution**
   - The producer thread keeps running, adding tasks indefinitely.
   - The consumer thread keeps running as well, processing tasks as they become available in the queue.
   - Both threads are running concurrently without blocking each other, which is the primary benefit of using `ConcurrentLinkedQueue`.

### 5. **Non-Blocking**
   - Since `ConcurrentLinkedQueue` supports non-blocking operations, it does not wait for the queue to become empty or full. The producer can add elements without worrying about whether the consumer has removed any, and the consumer can safely remove elements even if the producer is adding them at the same time.

---

## Use Cases for `ConcurrentLinkedQueue`

`ConcurrentLinkedQueue` is well-suited for scenarios where you need:
- **Non-blocking concurrent access**: Multiple threads need to add or remove elements without waiting for each other.
- **High-performance queues**: It provides efficient, low-latency access compared to traditional synchronized queues, especially in cases with a high volume of operations.
- **Task queues**: It is often used in task scheduling systems where tasks are produced and consumed concurrently by different threads.

---

## Conclusion

The `ConcurrentLinkedQueue` is a powerful tool for implementing high-performance, thread-safe, and non-blocking queues in concurrent applications. Its lock-free nature ensures that multiple threads can operate on the queue simultaneously without causing performance bottlenecks or blocking each other. This makes it ideal for high-concurrency scenarios where threads need to produce and consume elements concurrently without waiting for each other.

