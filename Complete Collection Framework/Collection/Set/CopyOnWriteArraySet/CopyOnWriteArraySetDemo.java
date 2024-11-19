package Collection.Set.CopyOnWriteArraySet;

import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArraySet;

public class CopyOnWriteArraySetDemo {
    public static void main(String[] args) {
        //ConcurrentSkipListSet is a Set that uses a SkipList for storage
        //ConcurrentSkipListSet is has a separated way of handling the concurrency and is sorted on based of keys
        //ConcurrentSkipListSet uses a lock-free algorithm


        //CopyOnWriteArraySet is a Set that uses an array for storage
        //Write and remove operations are done on a cloned copy of the array
        //During iteration, modifications won't reflect

        CopyOnWriteArraySet<Integer> integerCopyOnWriteArraySet = new CopyOnWriteArraySet<>();
        ConcurrentSkipListSet<Integer> integerConcurrentSkipListSet = new ConcurrentSkipListSet<>();

        for (int i = 0; i < 10; i++) {
            integerCopyOnWriteArraySet.add(i);
            integerConcurrentSkipListSet.add(i);
        }
        System.out.println(integerCopyOnWriteArraySet); //0,1,2,3,4,5,6,7,8,9
        System.out.println(integerConcurrentSkipListSet); //0,1,2,3,4,5,6,7,8,9

        for(Integer num: integerCopyOnWriteArraySet){
            System.out.println(num);
            integerCopyOnWriteArraySet.add(10); //no ConcurrentModificationException
        }
        System.out.println(integerCopyOnWriteArraySet); //0,1,2,3,4,5,6,7,8,9,10

        //Lets modify the ConcurrentSkipListSet
        for(Integer num: integerConcurrentSkipListSet){
            System.out.println(num);
            integerConcurrentSkipListSet.add(10); //no ConcurrentModificationException
            //10 will be added at the end and iteration will see the 10 (some times and sometimes not)
        }
        System.out.println(integerConcurrentSkipListSet); //0,1,2,3,4,5,6,7,8,9,10
    }
}
