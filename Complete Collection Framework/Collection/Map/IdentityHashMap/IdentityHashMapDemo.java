package Collection.Map.IdentityHashMap;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;

public class IdentityHashMapDemo {
    public static void main(String[] args) {
        //when we use a simple hashmap of string keys, the hashcode method of the string class is used to calculate the hashcode
        //now since the hashcode method of the string generates hashcode based on the value of the string
        //the below two keys will have the same hashcode
        //and the index of the key will also be same and instead of creating a new entry in the map, the value of the existing key will be replaced
        String key1 = new String("key");
        String key2 = new String("key");
        Map<String ,Integer> map = new HashMap<>();
        map.put(key1,1);
        map.put(key2,2);
        System.out.println(map); //{key=2}

        //what do identity hash map do?
        //Identity hash map uses the hashcode method of the object class to calculate the hashcode
        //which plays with the memory address of the object to generate the hashcode
        String key3 = new String("key");// since new keyword is used, hashcode will be different, since memory address will be different
        String key4 = new String("key");// since new keyword is used, hashcode will be different, since memory address will be different
        Map<String ,Integer> map1 = new IdentityHashMap<>();
        map1.put(key3,1);
        map1.put(key4,2);
        System.out.println(map1);//{key=1, key=2}

        //lets say somehow the different hashcode generates the same index
        //but still the second object with same index will be appended to the linked list because the equality in identity hash map is based on == operator
        //== checks the memory address of the object


        //what if we dont use new keyword?
        //if we dont use new keyword, the hashcode will be same as the memory address will be same (string pool address for both since they are the same strings) and the object hashcode is calculated using the memory address.
        //so the hashcode will be same and the index will be same
        //and the value of the existing key will be replaced
        String key5="key";
        String key6="key";
        Map<String ,Integer> map2 = new IdentityHashMap<>();
        map2.put(key5,1);
        map2.put(key6,2);
        System.out.println(map2);//{key=2}

        //we can also check the hashcdode of the object using the idenityhashcode method
        System.out.println(System.identityHashCode(key1));
        //different hashcode will be generated because new keyword is used
        System.out.println(System.identityHashCode(key2));

        System.out.println(System.identityHashCode(key5));
        //same hashcode will be generated because new keyword is not used
        System.out.println(System.identityHashCode(key6));

    }
}
