package Collection.Map.Concurrent.ConcurrentSkipListMap;

import java.util.concurrent.ConcurrentSkipListMap;

public class ConcurrentSkipListMapDemo {
    //A Map that is thread-safe and sorted
    //What is skip list?
    //SkipList is a probabilistic data structure that allows fast search, insertion, and deletion operations
    //Skip list is a kind of sorted linked list(based on keys), but with multiple layer that skip over portion of the list to provide faster search times

    public static void main(String[] args) {
        /*1. What is a Skip List?
A skip list is a probabilistic data structure that allows fast search, insert, and delete operations, similar to a balanced tree.
It builds multiple levels of linked lists, where:
        The bottom level contains all the elements in sorted order.
        Higher levels contain fewer elements, acting as shortcuts (or "express lanes") to speed up search operations.
        The higher levels are created probabilistically, meaning that each element has a chance (e.g., 50%) of being added to the next higher level.
        ---
        2. ConcurrentSkipListMap Features
        Sorted Order: Keys are always stored in their natural order (or by a custom comparator if provided).
        Thread-Safe: Multiple threads can access it concurrently without needing explicit synchronization.
        Non-Blocking Reads: Reads are mostly lock-free and highly concurrent.
                Logarithmic Complexity: Average time complexity for search, insert, and delete operations is .
                ---
                3. How it Works
        a. Search Operation
        The search starts at the topmost level and moves horizontally until it finds the range containing the target key.
                If the target is not found in the current level, it drops down to the next level.
        This continues until it reaches the bottom level, where the actual key is located.
                This "skip" through levels makes searches faster compared to a simple linked list.

                b. Insertion Operation
        A new key-value pair is first inserted at the bottom level.
        Probabilistically, the new key may also be added to higher levels. This randomness ensures a balanced skip list structure over time.
        During insertion, locks are used minimally to ensure consistency across levels.

        c. Deletion Operation
        To delete a key, it is removed from all levels where it appears.
        This operation also uses minimal locking to maintain consistency.
                --
                4. Concurrency Mechanism
        The ConcurrentSkipListMap achieves thread safety through:
        Fine-Grained Locking: Only the nodes involved in an operation are locked, avoiding global locks.
        CAS (Compare-And-Swap): Some operations, like updating node pointers, use CAS to ensure atomicity without locking.
        Lock-Free Reads: Reads do not require locking, as they navigate the skip list structure directly.
                By limiting locks to small portions of the map and using CAS, ConcurrentSkipListMap allows high levels of concurrency.
                ---
                5. When to Use It
        The ConcurrentSkipListMap is ideal for scenarios where:
        You need a thread-safe map that maintains sorted order.
                Frequent reads and occasional writes occur.
                Predictable performance is required, even under heavy concurrency.
               */

                ConcurrentSkipListMap<Integer, String> map = new ConcurrentSkipListMap<>();

                // Add key-value pairs
                map.put(3, "Three");
                map.put(1, "One");
                map.put(2, "Two");

                // Retrieve keys in sorted order
                System.out.println("Sorted Keys: " + map.keySet());

                // Retrieve a specific value
                System.out.println("Value for key 2: " + map.get(2));

                // Remove a key
                map.remove(1);
                System.out.println("After removing key 1: " + map.keySet());

                //Duplicate keys will lead to modification
                //Layer 2:  1---------------->4------------------>6
                //          |(ref)            |(ref)              |(ref)
                //Layer 1:  1------->2------->4-------->5-------->6
                     //     |        |        |         |         |
               //values:   one       two     three     four      five
            }
    }

