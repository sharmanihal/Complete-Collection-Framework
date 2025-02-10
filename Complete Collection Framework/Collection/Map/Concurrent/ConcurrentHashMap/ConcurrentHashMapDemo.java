package Collection.Map.Concurrent.ConcurrentHashMap;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapDemo {
    //ConcurrentHashMap is a thread-safe implementation of the Map interface
    //It implements the ConcurrentMap interface
    public static void main(String[] args) {
        ConcurrentHashMap<String, Integer> concurrentHashMap = new ConcurrentHashMap<>();
        //Before and till Java7 -> Segment based locking
        //16 Segments by default i.e., smaller hashmaps
        /*
        Before Java 8, ConcurrentHashMap in Java was implemented using segment-based locking, where the map was divided into smaller sub-maps called segments to allow finer-grained locking for better concurrency. Here's how it worked:
1. Segments as smaller HashMaps: Each segment was like an independent HashMap with its own bucket array. This means each segment maintained its own hash buckets for storing key-value pairs.
2. Number of segments: By default, there were sixteen segments. The number of segments could be specified during the map's creation (through initialCapacity and concurrencyLevel parameters).
3. Determining the segment: When adding or retrieving an entry, the key's hash code was used to determine which segment to access. This was done by using the high-order bits of the hash code to select a segment. Within the chosen segment, the hash code was then used again to determine the bucket index.
4. Locking per segment: When multiple threads accessed the ConcurrentHashMap, only the relevant segment containing the affected bucket was locked. This allowed other threads to access or modify data in different segments concurrently, improving performance.
5. Default bucket array size: The default initial size of the bucket array (within a segment) was 16. It started with a default capacity of sixteen buckets in each segment, but this could grow as entries were added (subject to the loadFactor).
         */
    //only the segment being written to or read from locked
        //read : do not require any locking unless there is a write operation happening on the same segment
        //write : lock only the segment being written to

        //From Java 8 -> Tree based locking and no segmentations
        //Disadvantages of segment based locking
        //1. If one thread is writing to one segment, other threads cannot read or write to that segments
        //2. If one thread is writing to one segment, other threads cannot write to the same segment
        //3. If one thread is writing to one segment, other threads cannot read from the same segment

        //To overcome these disadvantages, Java 8 introduced a new approach to locking in ConcurrentHashMap called tree-based locking.
        // This approach eliminated the need for segment-based locking and improved the performance of the map. Here's how it worked:
        //Comparing and Swapping Approach: No locking except when resizing or collision
        //Say we have multiple threads trying to write to the same bucket
        //One thread before making the swap of value , it will check if the value is same as the one it read
        //If yes, then it will swap the value
        //If no, then it will retry the operation
        //This is called as CAS (Compare and Swap)
        //This prevents the need of locking the whole map

    }
}
