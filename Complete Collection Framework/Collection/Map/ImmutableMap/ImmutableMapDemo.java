package Collection.Map.ImmutableMap;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ImmutableMapDemo {
    public static void main(String[] args) {
        //ImmutableMap is a map that once constructed, cannot be modified
        //Let's say we have a HashMap and we wnat to create a copy of it which is unmodifiable
        Map<String,Integer> map1= new HashMap<>();
        map1.put("a",1);
        map1.put("b",2);

        //To create a copy of the map that is unmodifiable
        Map<String, Integer> stringIntegerMap = Collections.unmodifiableMap(map1);
        stringIntegerMap.put("c",3); //UnsupportedOperationException

        //We can also use the Map.of() method to create an immutable map
        Map<String, Integer> stringIntegerMap1 = Map.of("a", 1, "b", 2);
        //But the limitation is that we can only add upto 10 key-value pairs

        //If we want to add more than 10 key-value pairs, we can use the Map.ofEntries() method
        Map<String, Integer> stringIntegerMap2 = Map.ofEntries(Map.entry("a", 1), Map.entry("b", 2), Map.entry("c", 3));

    }
}
