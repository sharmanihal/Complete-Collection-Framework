package Collection.List.Vector;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

public class VectorDemo {
    //Vector Class came in Java 1.0 and is a legacy class, but now it is a part of the Java Collection Framework
    //Vector is thread safe
    //Since its is synchronized, it is slow as compared to ArrayList
    public static void main(String[] args) {
        // Just like ArrayList, Vector implements the List interface
        // Dynamic Array
        // Synchronized
        // Resizing mechanism: When capacity is reached, it increases the size by 2 times

        //Initial Capacity is 10
        Vector<Integer> vector = new Vector<>();
        System.out.println(vector.capacity()); //10

        //We can also specify the initial capacity of the vector and the capacity increment
        //Capacity increment is 5, so when the size of the vector exceeds 20, a new vector is created with size 25
        Vector<Integer> vector2 = new Vector<>(20, 5);
        System.out.println(vector2.capacity()); //20

        //Collection argument constructor
        Vector<Integer> vector3 = new Vector<>(Arrays.asList(1, 2, 3, 4, 5));

        //all other methods are same as ArrayList


        //ThreadSafe Example
        //ArrayList is not thread safe
        ArrayList<Integer> arrayList = new ArrayList<>();

        //We have two threads t1 and t2 which are adding elements to the arrayList
        Thread t1= new Thread(()->{
           for (int i = 0; i < 1000; i++) {
               arrayList.add(i);
           }
        });

        Thread t2= new Thread(()->{
            for (int i = 0; i < 1000; i++) {
                arrayList.add(i);
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(arrayList.size()); // < 2000

        //When we use Vector instead of ArrayList, the output will always be 2000

        Vector<Integer> threadVector = new Vector<>();

        //We have two threads t1 and t2 which are adding elements to the arrayList
        Thread t3= new Thread(()->{
            for (int i = 0; i < 1000; i++) {
                threadVector.add(i);
            }
        });

        Thread t4= new Thread(()->{
            for (int i = 0; i < 1000; i++) {
                threadVector.add(i);
            }
        });

        t3.start();
        t4.start();

        try {
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(threadVector.size());
    }
}
