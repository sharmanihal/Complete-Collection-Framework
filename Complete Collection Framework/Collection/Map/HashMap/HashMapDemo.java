package Collection.Map.HashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapDemo {
    //Map is separate interface in Collection framework
    //Map has key-value pair
    //No key can be duplicate
    //Values can be duplicate

    //Hashmap is not synchronized (not thread safe)
    public static void main(String[] args) {
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "Mike");
        hashMap.put(2, "John");
        hashMap.put(3, "David");
        hashMap.put(4, "Alice");

        System.out.println(hashMap);

        //get value by key
        System.out.println(hashMap.get(2));
        System.out.println(hashMap.get(78));//null

        //contains key
        System.out.println(hashMap.containsKey(2));//true
        System.out.println(hashMap.containsKey(78));//false

        //contains value
        System.out.println(hashMap.containsValue("Mike"));//true
        System.out.println(hashMap.containsValue("Mikee"));//false

        //loop (no order is maintained in hashmap)
        for(Integer rollNumber: hashMap.keySet()){
            System.out.println(rollNumber + " " + hashMap.get(rollNumber));
        }
        
        //map.entrySet() returns a set of key-value pairs
        Set<Map.Entry<Integer, String>> entries = hashMap.entrySet();

        for(Map.Entry<Integer, String> entry: entries){
            entry.setValue(entry.getValue().toUpperCase());
            System.out.println(entry.getKey() + " : " + entry.getValue());

        }

        //getOrDefault
        System.out.println(hashMap.getOrDefault(5, "Not Found"));//Not Found

        //key can take null value (but only one null key is allowed)
        hashMap.put(null, "Null Value");

        //putIfAbsent
        hashMap.putIfAbsent(5, "Mikee"); //it will put the value only if key is not present
        //If we try to put same key, it will replace the previous same key's value
        hashMap.put(1, "Mikee");
        System.out.println(hashMap);


        //remove key
        hashMap.remove(null);

        //remove key-value pair (it will remove only if key-value pair is matched)
        boolean mikee = hashMap.remove(3, "Mikee");//it will not remove as key-value pair is not matched
        //3 is matched with David and not with Mikee
        System.out.println(mikee);//false


        //Constant time complexity of get, put, remove

        //Internal working of hashmap

        //Hashmap has 4 key components
        //1. Key: It is the unique identifier of the value
        //2. Value: It is the value that is stored in the hashmap
        //3. HashFunction: It is a function that is used to generate a hash code for the key
        //4. Bucket: It is an array that is used to store the key-value pairs

        //The hashcode is then processed to create an index in the bucket array
        //Characteristics of a good hash function
        //1. It should be deterministic: The same key should always produce the same hash code
        //2. Fixed length output: The hash code should always be of fixed length (32 bit or 64 bit)
        //3. Efficient computation: The hash function should be fast to compute

        //How data is stored in hashmap ?
        /*
        Step 1: Hashing the key: First the key is passed to the hash function to generate a hash code.
        The hash code is an integer value that is used to generate an index in the bucket array.

        Step 2: Calculating the index: The hash code is then processed to create an index in the bucket array.
        The index is calculated by taking the modulus of the hash code with the size of the bucket array.
        (index = hashcode % bucketArray.length)
        By default, the size of the bucket array is 16.

        Step 3: Storing in the bucket: The key-value pair is then stored in the bucket at the calculated index.
        Each bucket can store multiple key-value pairs. If there are multiple key-value pairs at the same index,
         */

        //What type of data is stored in this bucket array ?

        //The bucket array stores an array of linked lists. Each element in the bucket array is a linked list that stores the key-value pairs.

        //why do we need to search in the linked list ?
        //If two keys produce the same hash code, they will be stored in the same bucket. This is known as a hash collision.

        //So hash function takes the key , generates hash code and then index is calculated by taking modulus of hash code with size of bucket array
        //insert the key-value pair in the linked list at the calculated index, when comes to searching, again the hash function is used to generate hash code
        //and then index is calculated by taking modulus of hash code with size of bucket array and then search in the linked list at the calculated index
        //it checks if the key is present in the linked list or not

        //Each index of the bucket array stores a linked list of key-value pairs. If two keys produce the same hash code, they will be stored in the same bucket(index).

        //After java8 this linked list is converted to balanced tree if the size of linked list exceeds by length 8

        //When the size of the bucket reaches 0.75 times the capacity of the hashmap (default 16 *.75=12), the hashmap is resized to double the capacity.

        //we can specify the initial capacity and load factor while creating the hashmap
        HashMap<Integer, String> hashMapEx = new HashMap<>(20, 0.5f);
        //This hashmap will be resized to double its size, when the size of the bucket reaches 20 * 0.5 = 10

        //When the size of the bucket changes, all the key-value pairs are rehashed and stored in the new bucket array.
        //Rehashed means the hash function is applied again to all the keys to generate new hash codes and new indices in the bucket array.


        //How is the equality of keys checked in hashmap ?
        //The equality of keys is checked using the equals() method. If two keys produce the same hash code, they are stored in the same bucket.
        //When searching for a key, the equals() method is used to check if the key is present in the linked list at the calculated index.

        //Lets understand how this works : Check the file HashMapDemo2.java
    }
}
