package Collection.Map.LinkedHashMap;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K,V> extends LinkedHashMap<K,V> {
    private int capacity;
    LRUCache(int capacity){
        super(capacity,0.75f,true);
        this.capacity=capacity;
    }
    public static void main(String[] args) {
        LRUCache<String,Integer> studentCache = new LRUCache<>(3);
        studentCache.put("Alice",1);
        studentCache.put("Bob",2);
        studentCache.put("Charlie",3);
        studentCache.put("David",4);

        //After each put operation the eldest entry is removed if the size of the map is greater than the capacity
        //Since the capacity is 3, the eldest entry should be removed which is Alice
        System.out.println(studentCache);

    }

    //This method is called after the put method to check if the eldest entry needs to be removed based on some condition
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        //if the size of the map is greater than the capacity then remove the eldest entry
        return size()>capacity;
    }
}
