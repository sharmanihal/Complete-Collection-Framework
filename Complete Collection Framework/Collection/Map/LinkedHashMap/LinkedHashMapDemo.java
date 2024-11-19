package Collection.Map.LinkedHashMap;

import java.util.HashMap;
import java.util.LinkedHashMap;
//LinkedHashMap is not synchronized (not thread safe) just like HashMap
public class LinkedHashMapDemo {
    public static void main(String[] args) {
        //Linked hashmap map extends hashmap and implements SequencedMap interface
        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>();

        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Apple", 10);
        hashMap.put("Banana", 20);
        hashMap.put("Orange", 30);
        hashMap.put("Grapes", 40);
        //No order is maintained in hashmap
        for (String key : hashMap.keySet()) {
            System.out.println(key + " " + hashMap.get(key));
        }

        //Let's do the same with linked hashmap
        linkedHashMap.put("Apple", 10);
        linkedHashMap.put("Banana", 20);
        linkedHashMap.put("Orange", 30);
        linkedHashMap.put("Grapes", 40);

        //Order is maintained in linked hashmap
        for (String key : linkedHashMap.keySet()) {
            System.out.println(key + " " + linkedHashMap.get(key));
        }

        //How does linked hashmap maintain order?
        //It maintains order by maintaining a doubly linked list of entries
        //The linked hash map keep two data structures, a hash table and a linked list
        //when we add an entry to the linked hash map, it adds the entry to the hash table and also adds the entry to the linked list
        //When we iterate over the linked hash map, it iterates over the linked list and pull the entry from the hash table
        //There is something called access order in linked hashmap, that we can provide while creating linked hashmap
        //If we set access order to false, it will maintain insertion order (default)
        LinkedHashMap<String, Integer> linkedHashMap1 = new LinkedHashMap<>(16, 0.75f, false);

        //What if we set access order to true?
        //If we set access order to true, it will maintain access order
        //When we access an entry in the linked hash map, it moves the entry to the end of the linked list
        //You might be wondering why it adds the entry to the end of the linked list, why not to the beginning?
        //There is concept called LRU (Least Recently Used) cache, where we want to remove the least recently used entry
        //So the least recently used entry will be at the beginning of the linked list
    }
}
