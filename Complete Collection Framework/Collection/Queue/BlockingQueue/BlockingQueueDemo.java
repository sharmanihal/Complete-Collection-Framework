package Collection.Queue.BlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingQueueDemo {
    //BlockingQueue is an interface that extends the Queue interface
    //Thread-safe queue
    // Supports operations that wait for the queue to become non-empty when retrieving an element,
    // and wait for space to become available in the queue when storing an element

    //Insertion will wait for space to become available if the queue is full
    //Removal will wait for an element to become available if the queue is empty
    //Simplify concurrency issues like producer-consumer problem

    //Standard queue operations are performed immediately (no waiting)
    //If we try to remove an element from an empty queue, it will throw an exception
    //If we try to add an element to a full queue, it will throw an exception

    //Blocking Queue:
    //put(e) - Inserts the specified element into this queue, waiting if necessary for space to become available
    //take() - Retrieves and removes the head of this queue, waiting if necessary until an element becomes available
    //offer(e) - Inserts the specified element into this queue, waiting up to the specified wait time if necessary for space to become available
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(5);
        //ArrayBlockingQueue is a bounded blocking queue backed by an array (circle buffer)
        //low memory overhead
        //uses a single lock for insertion and removal (enqueuing and dequeuing)
        //more theads can create problems
        Thread producer = new Thread(new Producer(blockingQueue));
        Thread consumer = new Thread(new Consumer(blockingQueue));
        producer.start();
        consumer.start();

        producer.join();
        consumer.join();

        //we also LinkedBlcokingQueue, similar to ArrayBlockingQueue but backed by a linked list
        //We dont need to specify the size of the queue, if we dont specify the size, it will be Integer.MAX_VALUE
        BlockingQueue<Integer> linkedBlockingQueue = new LinkedBlockingQueue<>(20);
        //Uses two separate locks for insertion and removal (enqueuing and dequeuing)
        //if multiple threads are inserting, they will share the same lock, so only one thread can insert at a time
        //if multiple threads are removing, they will share the same lock, so only one thread can remove at a time

        //In LinkedBlockingQueue, the consumer can continue consuming elements from the queue even while a producer is adding elements to it, as long as there are already elements in the queue to consume.
        // The consumer won't block unless the queue is empty, and the producer won't block unless the queue is full.
    }
}

class Producer implements Runnable{
    private BlockingQueue<Integer> blockingQueue;
    private int value=0;

    Producer(BlockingQueue<Integer> blockingQueue){
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        while(true){
            try {
                System.out.println("Produced: "+value);
                blockingQueue.put(value++);
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        }

    }
}

class Consumer implements Runnable{
    private BlockingQueue<Integer> blockingQueue;
    Consumer(BlockingQueue<Integer> blockingQueue){
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        while(true){
            try {
                Integer value = blockingQueue.take();
                System.out.println("Consumer: "+value);
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        }

    }
}