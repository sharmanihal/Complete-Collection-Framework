package Collection.Map.LegacyHashTable;

import java.util.Hashtable;

public class HashTableDemo {
    public static void main(String[] args) {
        //HashTable is a legacy class that implements the Map interface
        //HashTable is synchronized
        //HashTable does not allow null keys or values
        //HashTable is thread-safe
        //HashTable is slower than HashMap
        //HashTable is not recommended for use
        //It locks the whole map for both read and write operations
        //It can be replaced by ConcurrentHashMap

        //Only Linked list in case of collision
        Hashtable<Integer, String> hashtable = new Hashtable<>();
        hashtable.put(1, "One");
        hashtable.put(2, "Two");

        //get
        System.out.println(hashtable.get(1));

        //containsKey
        System.out.println(hashtable.containsKey(1));

        //containsValue
        System.out.println(hashtable.containsValue("One"));

        //remove
        hashtable.remove(1);

        //All other methods are same as HashMap

        //Even the read methods are synchronized
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
        System.out.println(hashtable.size()); //2000

        //Hashmap is not thread safe, output will be less than 2000
    }
}
