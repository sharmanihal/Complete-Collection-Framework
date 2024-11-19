package Collection.Queue.BlockingQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class SynchronousQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        //SynchronousQueue is a blocking queue that has 1 capacity
        //Each insert operation must wait for a corresponding remove operation by another thread, and vice versa

        //it cant be used to store elements
        BlockingQueue<Integer> synchronousQueue = new SynchronousQueue<>();
        Thread producer = new Thread(()->{
            try{
                while (true){
                System.out.println("Producer is waiting to insert the element");
                System.out.println("Producer has inserted the element");
                synchronousQueue.put(1);

                }
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
                System.out.println("Producer thread interrupted");
            }
        });

        Thread consumer = new Thread(()->{
            try{
                System.out.println("Consumer is waiting to take the element");
                synchronousQueue.take();
                System.out.println("Consumer has taken the element");
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
                System.out.println("Consumer thread interrupted");
            }
        });

        producer.start();
        consumer.start();

        producer.join();
        consumer.join();

    }
}
