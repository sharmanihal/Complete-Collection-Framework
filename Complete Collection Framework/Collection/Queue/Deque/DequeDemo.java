package Collection.Queue.Deque;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class DequeDemo {
    public static void main(String[] args) {
        //Deque is an interface that extends the Queue interface
        //Deque is a double-ended queue that supports element insertion and removal at both ends
        //Deque implementations are ArrayDeque and LinkedList

        /* Insertion Operations:
        addFirst(e) - Inserts the specified element at the front of the deque
        addLast(e) - Inserts the specified element at the end of the deque
        offerFirst(e) - Inserts the specified element at the front of the deque
        offerLast(e) - Inserts the specified element at the end of the deque
         */

        /* Removal Operations:
        removeFirst() - Removes and returns the first element of the deque
        removeLast() - Removes and returns the last element of the deque
        pollFirst() - Removes and returns the first element of the deque, null if deque is empty
        pollLast() - Removes and returns the last element of the deque, null if deque is empty
         */

        /* Examine Operations:
        getFirst() - Returns the first element of the deque, throws NoSuchElementException if deque is empty
        getLast() - Returns the last element of the deque, throws NoSuchElementException if deque is empty
        peekFirst() - Returns the first element of the deque, null if deque is empty
        peekLast() - Returns the last element of the deque, null if deque is empty
         */

        /* Stack Operations:
        push(e) - Pushes an element onto the stack represented by the deque
        pop() - Pops an element from the stack represented by the deque
         */

        Deque<Integer> deque1 = new ArrayDeque<>();

        deque1.add(10);
        deque1.add(20);
        System.out.println(deque1); // [10, 20]
        deque1.remove(); // removes the first element
        System.out.println(deque1); // [20]
        deque1.addFirst(1);
        deque1.addLast(2);
        System.out.println(deque1); // [1, 20, 2]
        deque1.removeFirst();
        System.out.println(deque1); // [20, 2]
        deque1.removeLast();
        System.out.println(deque1); // [20]
        deque1.add(30);
        System.out.println(deque1); // [20, 30]
        deque1.poll(); // removes the first element
        System.out.println(deque1); // [30]
        deque1.push(40);
        System.out.println(deque1); // [40, 30]
        deque1.pop(); // removes the first element
        System.out.println(deque1); // [30]

        //Deque is circular in nature, it has two pointers, one at the front and one at the end
        //When we add elements at the front or end, the pointers move
        //if pointer matches, the size of the array is increased to double
        //We can assign LinkedList to Deque, but it is recommended to use ArrayDeque

        Deque<Integer> deque2 = new LinkedList<>();
    }
}
