package Collection.List.ArrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayListDemo {

    public static void main(String[] args) {
        //We use list when we want an ordered collection of elements and duplicates are allowed.
        //Collection.List.ArrayList is a class in Java that is used to store elements. It implements List interface.
        //Collection.List.ArrayList is not thread safe, i.e., multiple threads can't work on Collection.List.ArrayList at the same time.
        //Collection.List.ArrayList can change its size dynamically.
        //Initial size of Collection.List.ArrayList is 10. When the size of Collection.List.ArrayList exceeds 10, a new Collection.List.ArrayList is created with size 1.5 times the previous size.
        //We can also specify the initial size of Collection.List.ArrayList while creating it.
        //When ever the size of array exceed its capacity a new array is created with 1.5 times the previous size and all the elements are copied to the new array.
        ArrayList<Integer> list = new ArrayList<>();
        //Adding elements to Collection.List.ArrayList one after the other
        list.add(1);//0 index
        list.add(2);//1 index

        //Adding elements to Collection.List.ArrayList at a specific index
        list.add(0,7);

        //Adding elements of another list to Collection.List.ArrayList
        List<Integer> list2 = new ArrayList<>();
        list2.add(10);
        list2.add(20);
        list.addAll(list2);

        //Adding elements of another list to Collection.List.ArrayList at a specific index
        list.addAll(1,list2);

        //Index based access to the elements of Collection.List.ArrayList
        System.out.println(list.get(1));
        System.out.println(list.get(3));

        //Since Collection.List.ArrayList has a toString() method implementation, we can directly print the Collection.List.ArrayList
        System.out.println(list);

        //Size of an Collection.List.ArrayList means the number of elements present in the Collection.List.ArrayList.
        //Capacity of an Collection.List.ArrayList is different from size. Capacity is the maximum number of elements that can be stored in an Collection.List.ArrayList.
        System.out.println(list.size());

        //foreach loop to iterate over the elements of Collection.List.ArrayList
        for(Integer i: list){
            System.out.println(i);
        }

        //check if the list contains a specific element
        System.out.println(list.contains(1));
        System.out.println(list.contains(50));

        //remove an element from the list
        //this will remove the element at index 2
        System.out.println(list.remove(2));
        list.removeIf(x->x==10);

        //if i want to remove an element by its value, i can use remove(Object o) method
        System.out.println(list.remove(Integer.valueOf(9)));


        //Setting value at an index
        list.set(1,20);

        //Collection.List.ArrayList don't reduce its capacity automatically. If we want to reduce the capacity of Collection.List.ArrayList, we can use trimToSize() method.
        //This method reduces the capacity of Collection.List.ArrayList to the number of elements present in the Collection.List.ArrayList.
        list.trimToSize();

        //clear the Collection.List.ArrayList
        list.clear();

        //More ways to create List

        //1. Using asList , you can't add or remove elements, but you can replace the elements
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
        list1.set(1,10);
        System.out.println(list1);

        //This also returns a fixed size list and unmodifiable list. You can't even replace element in this list.
        List<String> monday = List.of("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday");


        //to make the above lists modifiable, you can use Collection.List.ArrayList constructor
        ArrayList<Integer> arrayList = new ArrayList<>(list1);
        arrayList.add(6);
        System.out.println(arrayList);

        //Converting list to array
        Integer[] arr = list1.toArray(new Integer[0]);

        //sorting a list in natural order
        Collections.sort(list1);
        list.sort(null );// sending null to comparator will sort the list in natural order
    }
}
