package Collection.Map.SortedMapDemo.TreeMap;

import java.util.SortedMap;
import java.util.TreeMap;

public class TreeMapDemo {
    public static void main(String[] args) {
        //SortedMap is an interface that extends the Map interface
        //SortedMap ensures that the entries are sorted based on the natural ordering of the keys or by specifying a comparator

        //Implementations of SortedMap are TreeMap
        //TreeMap uses a red-black tree to store the entries (self-balancing binary search tree)
        //time complexity of most of the operations is O(log n)
        SortedMap<String, Integer> studentMarks = new TreeMap<>();

        //it will sort the entries based on the natural ordering of the keys
        //in this case its string class so it will use the compareTo method to sort the entries

        studentMarks.put("Bob", 80);
        studentMarks.put("David", 60);
        studentMarks.put("Charlie", 70);
        studentMarks.put("Alice", 90);

        System.out.println(studentMarks);//{Alice=90, Bob=80, Charlie=70, David=60}

        //we can also specify a comparator to sort the entries
        //in this case we are sorting the entries based on the length of the keys
        SortedMap<String, Integer> studentMarks2 = new TreeMap<>((s1, s2) -> {
            int lengthComparison = Integer.compare(s1.length(), s2.length());
            return lengthComparison != 0 ? lengthComparison : s1.compareTo(s2);
        });
        studentMarks2.put("Bob", 80);
        studentMarks2.put("David", 60);
        studentMarks2.put("Alice", 90);
        studentMarks2.put("Charlie", 70);
        System.out.println(studentMarks2); // {Bob=80, Alice=90, David=60, Charlie=70}

        //We cloud have also used the Map reference to refer to the TreeMap object
        //Map<String, Integer> studentMarks = new TreeMap<>();
        //The entries will still be sorted based on the natural ordering of the keys

        //But sorted map provides additional methods for convenience

        //firstKey() returns the first key in the sorted map
        System.out.println(studentMarks.firstKey());//Alice
        //lastKey() returns the last key in the sorted map
        System.out.println(studentMarks.lastKey());//David
        //headMap() returns a view of the portion of the map whose keys are less than the specified key
        //bring data from head (start) to the specified key
        System.out.println(studentMarks.headMap("Charlie"));//{Alice=90, Bob=80} //excluding Charlie
        //tailMap() returns a view of the portion of the map whose keys are greater than or equal to the specified key
        //bring data from specified key to tail (end)
        System.out.println(studentMarks.tailMap("Charlie"));//{Charlie=70, David=60} //including Charlie

        //subMap() returns a view of the portion of the map whose keys are greater than or equal to the fromKey and less than the toKey
        //bring data from fromKey to toKey
        System.out.println(studentMarks.subMap("Bob", "David"));//{Bob=80, Charlie=70} //including Bob and excluding David

    }
}
