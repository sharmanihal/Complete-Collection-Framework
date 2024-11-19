package Collection.Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class QueueDemo {
    public static void main(String[] args) {
        //Queue follows the FIFO (First In First Out) order

        //Elements are added at the end of the queue and removed from the beginning of the queue

        //Queue using LinkedList
        LinkedList<Integer> integerLinkedList = new LinkedList<>();
        //insert at the end
        //remove from the beginning
        integerLinkedList.addLast(1);//enqueue
        integerLinkedList.addLast(2);
        System.out.println(integerLinkedList); //[1, 2]
        integerLinkedList.removeFirst();//dequeue

        //Queue using Queue interface
        Queue<Integer> integerQueue = new LinkedList<>();
        integerQueue.add(1);
        integerQueue.add(2);
        System.out.println(integerQueue); //[1, 2]
        integerQueue.remove(); //removes the first element

        //add, remove , peek and their alternatives
        System.out.println(integerQueue.remove()); //throws NoSuchElementException if queue is empty'
        System.out.println(integerQueue.poll()); //returns null if queue is empty

        System.out.println(integerQueue.element()); //throws NoSuchElementException if queue is empty
        System.out.println(integerQueue.peek()); //returns null if queue is empty


        //Queue of fixed size
        Queue<Integer> integerQueue1 = new ArrayBlockingQueue<>(2);
        System.out.println(integerQueue1.add(1));//true
        System.out.println(integerQueue1.offer(2));//true
        System.out.println(integerQueue1.offer(3));//false
        System.out.println(integerQueue1.add(4)); //IllegalStateException: Queue full


    }
}
