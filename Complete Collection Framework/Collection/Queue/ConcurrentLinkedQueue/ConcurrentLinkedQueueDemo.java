package Collection.Queue.ConcurrentLinkedQueue;

import java.util.concurrent.ConcurrentLinkedQueue;

public class ConcurrentLinkedQueueDemo {
    //Blocking queue is used for communication between producer and consumer threads
    //They block the producer consumer based on the state of the queue

    //But sometimes we need a queue that is non-blocking

    //ConcurrentLinkedQueue is an implementation of the Queue interface
    //Supports lock-free thread-safe operations

    // We can perform multple put or take operations at the same time
    // We can put and take elements at the same time


    //compare and swap operation is used to add and remove elements
    // while add, it checks if the tail is still the same, if yes, it adds the element
    // while remove, it checks if the head is still the same, if yes, it removes the element
    public static void main(String[] args) throws InterruptedException {
        ConcurrentLinkedQueue<String> tasks = new ConcurrentLinkedQueue<>();
        Thread producer = new Thread(()->{
            while(true){
                tasks.add("Task" +System.currentTimeMillis());
            }
        });

        Thread consumer = new Thread(()->{
            while(true){
                String task = tasks.poll();
                System.out.println("Consuming " + task);

            }
        });

        producer.start();
        consumer.start();

        producer.join();
        consumer.join();

    }
}


