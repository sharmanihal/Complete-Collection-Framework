package Collection.List.CopyOnWriteArrayList;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListDemo {
    public static void main(String[] args) throws InterruptedException {
        //CopyOnWriteArrayList is a thread-safe variant of ArrayList in which all mutative operations (add, set, and so on) are implemented by making a fresh copy of the underlying array.
        //This is ordinarily too costly, but may be more efficient than alternatives when traversal operations vastly outnumber mutations, and is useful when you cannot or don't want to synchronize traversals, yet need to preclude interference among concurrent threads.


        //Why do we need CopyOnWriteArrayList when we have vector ?
        //Vector and stack make use of locks to make them thread safe. This can be a performance bottleneck when we have a large number of reads and very few writes.

        //Here’s a quick summary:
        //
        //Each write operation acquires a lock, which ensures only one thread can modify the array at any moment.
        //The modifying thread creates a new copy, applies its changes, and then updates the reference to this new copy.
        //After releasing the lock, the next thread can acquire it, work on the latest copy, and repeat the process.
        //
        //This approach ensures thread safety by isolating each write operation, but it does block reads while the write is in progress. As read operation can still access the old copy of the array, and once the write operation is complete, the reference is updated to the new copy, and the read operation will now access the new copy.



        List<String> shoppingList = new ArrayList<>();
        shoppingList.add("Milk");
        shoppingList.add("Bread");
        shoppingList.add("Butter");

        for (String item : shoppingList) {
            //Trying ot modify the list while iterating over it
            //Will throw ConcurrentModificationException
            if (item.equals("Milk")) {
                shoppingList.add("Eggs");
            }
        }
        //loop expects a stable snapshot of the list in case of ArrayList

        //CopyOnWriteArrayList doesn't throw ConcurrentModificationException
        List<String> shoppingList1 = new CopyOnWriteArrayList<>();
        shoppingList1.add("Milk");
        shoppingList1.add("Bread");
        shoppingList1.add("Butter");

        for (String item : shoppingList1) {
            //Trying ot modify the list while iterating over it
            //Will throw ConcurrentModificationException
            if (item.equals("Milk")) {
                shoppingList1.add("Eggs");
            }
        }
        //here the loop is till using the stable snapshot of the list
        //but the add operation is done on a new copy of the list
        //this copy is then made the main list at the end of the loop
        System.out.println(shoppingList1);


        //Lets take another example of reader and writer threads
        List<String> sharedList = new CopyOnWriteArrayList<>();
        sharedList.add("Item1");
        sharedList.add("Item2");
        sharedList.add("Item3");

        Thread reader = new Thread(()->{
            while(true){
                for(String item:sharedList){
                    System.out.println(item);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

        });
        Thread writer = new Thread(()->{
            try {
                Thread.sleep(500);//delay to let the reader thread start
                sharedList.add("Item4");

                Thread.sleep(500);
                sharedList.remove("Item1");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        });

        reader.start();
        writer.start();

        reader.join();
        writer.join();
    }
}
