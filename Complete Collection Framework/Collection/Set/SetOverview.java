package Collection.Set;

import java.util.*;
import java.util.concurrent.ConcurrentSkipListSet;

public class SetOverview {
    //Set is collection that does not allow duplicate elements
    public static void main(String[] args) {
        //Map -> HashMap, LinkedHashMap, TreeMap, WeakHashMap, IdentityHashMap, EnumMap
        //Set -> HashSet, LinkedHashSet, TreeSet, EnumSet

        Set<Integer> set = new HashSet<>();
        //since it implements Collection interface, it has all the methods of Collection interface
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(2); //duplicate element, so it will not be added
        System.out.println(set); //unordered 2,1,3

        //Want ordered set, use LinkedHashSet
        Set<Integer> set1 = new LinkedHashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set1.add(2);
        System.out.println(set1);//ordered 2,1,3

        //Want sorted set, use TreeSet
        Set<Integer> set2 = new TreeSet<>();
        set2.add(12);
        set2.add(27);
        set2.add(33);
        set2.add(27);
        System.out.println(set2);//sorted 12,27,33

        //Similar to TreeMap, we also have NavigableSet, SortedSet here to give some more functionalities
        SortedSet<Integer> sortedSet = new TreeSet<>();
        NavigableSet<Integer> navigableSet = new TreeSet<>();

        //All these above implementations are not thread safe

        //ConcurrentSkipListSet is a thread safe set implementation
        Set<Integer> concurrentSkipListSet = new ConcurrentSkipListSet<>();
        //It is a sorted set implementation (sorted in natural order of elements)

        //unmodifiable set
        Set<Integer> unmodifiableSet = Collections.unmodifiableSet(set);
        //unmodifiableSet.add(4); //UnsupportedOperationException
        //Set.of() method can also be used to create an unmodifiable set
        Set<Integer> unmodifiableSet1 = Set.of(1, 2, 3);
        //we can add more than 10 elements using Set.of() method



    }
}
