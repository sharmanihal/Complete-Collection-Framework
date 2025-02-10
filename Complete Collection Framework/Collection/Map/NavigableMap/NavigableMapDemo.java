package Collection.Map.NavigableMap;

import java.util.NavigableMap;
import java.util.TreeMap;

public class NavigableMapDemo {
    //Navigable map is an interface
    //NavigableMap extends SortedMap,
    //providing more powerful navigation option such as
    // finding the closest matching key or retrieving the map in reverse order.
    public static void main(String[] args) {
        NavigableMap<Integer,String> navigableMap = new TreeMap<>();
        navigableMap.put(1,"One");
        navigableMap.put(6,"Six");
        navigableMap.put(3,"Three");
        navigableMap.put(7,"Seven");

        System.out.println(navigableMap);

        //lowerKey
        System.out.println(navigableMap.lowerKey(4)); // will return the greatest lower key than 4 i.e., 3 in this case

        //ceilingKey
        System.out.println(navigableMap.ceilingKey(4));// will return the equal(if any) or next greatest key than specified key

        //higherEntry
        System.out.println(navigableMap.higherEntry(1));//return entry greater than 1

        //decendingMap
        System.out.println(navigableMap.descendingMap());


        //So you can say that TreeMap can have various uses
        //1. If you want just sorted feature of treemap use Map ref
        //2. If you want navigation features along with sorted map features enabled , use NavigableMap ref (since Navigable Map interface extends Sorted map interface and tree map implements navigable map)
        //3. If you want features of sortedMap like first key ,last key etc. use SortedMap Ref
        //4. If you want to use all features just use TreeMap ref.
    }
}
