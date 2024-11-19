package Collection.Iterator;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class IteratorDemo {
    public static void main(String[] args) {

        //Any class the implements the Iterable interface can be used in a for-each loop
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        for (Integer i : list) {
            System.out.println(i);
        }
        //The above code gets converted into the following code
        Iterator<Integer> itr = list.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }



        //one benefit of using the iterator is that we can remove elements from the list while iterating
        ListIterator <Integer> listIterator = list.listIterator();
        while (listIterator.hasNext()){
            Integer i = listIterator.next();
            if(i == 2 ){
                listIterator.remove();
            }
        }
        System.out.println(list);

        while(listIterator.hasPrevious()){
            System.out.println(listIterator.previous());
        }

        //we can also use the iterator to replace elements in the list
        while(listIterator.hasNext()){
            Integer i = listIterator.next();
            if(i == 3){
                listIterator.set(5);
            }
        }
        System.out.println(list);
    }
}