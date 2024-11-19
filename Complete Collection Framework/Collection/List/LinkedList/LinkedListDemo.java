package Collection.List.LinkedList;

import java.util.LinkedList;
import java.util.List;

public class LinkedListDemo {
    public static void main(String[] args) {
        //Collection.List.ArrayList.LinkedList implements the List interface just like Collection.List.ArrayList
        //Order is maintained in Collection.List.ArrayList.LinkedList
        //Can get elements by index
        //A Collection.List.ArrayList.LinkedList stores its elements in nodes in a doubly linked list
        //Collection.List.ArrayList.LinkedList is better for frequent insertions and deletions
        //Collection.List.ArrayList is better for frequent access of elements
        LinkedList<Integer> linkedList = new LinkedList<>();

        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        System.out.println(linkedList);

        // We can't get elements by index in Collection.List.ArrayList.LinkedList since it is not an array
        // When we do .get(index) in Collection.List.ArrayList.LinkedList, it has to traverse the list from the start to the index
        System.out.println(linkedList.get(2));

        //add element at a specific index
        linkedList.add(2, 5);
        //addFirst and addLast methods are also available
        linkedList.addFirst(10); //O(1)
        linkedList.addLast(20); //O(1)

        // Since linked list is a doubly linked list, we can also do :
        System.out.println(linkedList.getLast());
        System.out.println(linkedList.getFirst());
        System.out.println(linkedList.removeFirst());
        System.out.println(linkedList.removeLast());
        System.out.println(linkedList.removeFirstOccurrence(1));
        System.out.println(linkedList.removeLastOccurrence(2));

        //removeIf method is also available
        linkedList.removeIf(x->x%2==0);

        //removeAll method is also available
        List<Integer> nums= List.of(3,4,5);
        linkedList.removeAll(nums);

        // We can use the for-each loop to iterate over the elements of Collection.List.ArrayList.LinkedList
        for(Integer i:linkedList){
            System.out.println(i);
        }

    }
}
