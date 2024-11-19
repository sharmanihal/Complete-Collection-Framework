package Collection.Queue.BlockingQueue;

import java.util.Comparator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class PriorityBlockingQueueDemo {
    //Unbounded BlockingQueue
    public static void main(String[] args) {
        //We can either give the capacity or not (default capacity is 11)
        BlockingQueue<Integer> queue = new PriorityBlockingQueue<>();

        //Same as priority queue but it is thread safe
        //Elements are ordered based on their natural ordering or by a comparator
        //So when a consumer consumes, the element with the highest priority is consumed first

        //Since it is unbounded, put method will never block


        //Custom comparator
        Comparator comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        };
        BlockingQueue<String> queue2 = new PriorityBlockingQueue<>(11,comparator);
        queue2.add("Apple");
        queue2.add("Banana");
        queue2.add("Pineapple");
        queue2.add("Mango");

        while (!queue2.isEmpty()){
            System.out.println(queue2.poll());
        }
    }
}
