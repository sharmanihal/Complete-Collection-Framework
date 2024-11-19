package Collection.Queue.PriorityQueue;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueDemo {
    //Part of Queue interface

    //It can act as a nominal queue or a priority queue
    //Orders elements based on their natural ordering(lowest first for primitives) or by a specified comparator
    public static void main(String[] args) {
        Queue<Integer> proirityQueue = new PriorityQueue<>();
        proirityQueue.add(2);
        proirityQueue.add(1);
        proirityQueue.add(4);
        proirityQueue.add(3);

        System.out.println(proirityQueue); // Priority will be given to the lowest element //not sorted

        //String example
        Queue<String> stringPriorityQueue = new PriorityQueue<>();
        stringPriorityQueue.add("Banana");
        stringPriorityQueue.add("Apple");
        stringPriorityQueue.add("Pineapple");
        stringPriorityQueue.add("Mango");

        //The first element will be polled based on the natural ordering of the elements
        //Rets of the element if we print they can be in any order
        //But when the next poll comes, the first element will then again be based on the natural ordering
        System.out.println(stringPriorityQueue); //  Priority will be given to natural ordering of the elements

        //[Apple, Banana, Pineapple, Mango]
        //You see first processed element is Apple, even though Mango should come before pipneapple
        //But when we actually poll the element, mon ago will come before pineapple
        System.out.println(stringPriorityQueue.poll()); //Apple
        System.out.println(stringPriorityQueue.poll()); //Banana
        System.out.println(stringPriorityQueue.poll()); //Mango
        System.out.println(stringPriorityQueue.poll()); //Pineapple


        //PriorityQueue does not allow null elements

        //Internal implementation of PriorityQueue

        //It is implemented as s min heap by default (for natural ordering)
        //Min heap is a tree where the root is the smaller element than its children
        //The smallest element is at the root
        //Take the smallest element out, the tree rearranges itself to make the next smallest element as the root again

        //Insertion takes O(log n) time
        //Deletion of smallest element takes O(log n) time


        //Custom comparator
        PriorityQueue<Integer> customPriorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        customPriorityQueue.add(2);
        customPriorityQueue.add(1);
        customPriorityQueue.add(4);
        customPriorityQueue.add(3);

        while (!customPriorityQueue.isEmpty()) {
            System.out.println(customPriorityQueue.poll());
        }

        //Our own comparator

        Comparator<String> comparator = new Comparator<>() {
            @Override
            public int compare(String s1, String s2) {
                return s2.length() - s1.length();
            }
        };
        PriorityQueue<String> customStringPriorityQueue = new PriorityQueue<>(comparator);
        customStringPriorityQueue.add("Banana");
        customStringPriorityQueue.add("Apple");
        customStringPriorityQueue.add("Pineapple");
        customStringPriorityQueue.add("Mango");

        while (!customStringPriorityQueue.isEmpty()) {
            System.out.println(customStringPriorityQueue.poll());
            //Elements will pe pulled based on the length of the string
    }
    }

}
