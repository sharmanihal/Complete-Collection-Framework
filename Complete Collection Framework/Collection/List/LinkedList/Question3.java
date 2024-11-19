package Collection.List.LinkedList;

import java.util.Arrays;
import java.util.LinkedList;

public class Question3 {

    //Move Zeroes to the End
    //Write a method to move all zeroes in an ArrayList of integers to the end while maintaining the order of non-zero elements.
    //
    //Example:
    //ArrayList<Integer> list = new ArrayList<>(Arrays.asList(0, 1, 0, 3, 12));
    //moveZeroesToEnd(list);
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>(Arrays.asList(0, 1, 0, 3, 12));
        moveZeroesToEnd(list);
        // Expected Output: [1, 3, 12, 0, 0]
        System.out.println(list);
    }

    private static void moveZeroesToEnd(LinkedList<Integer> list) {
        //since its a LinkedList deletion and insertion is O(1)
        int countOfZeroes = 0;
        for (int i =0;i<list.size();i++){
            if(list.get(i)==0){
                list.remove(i);
                countOfZeroes+=1;
            }
        }
        //insert the zeroes at the end
        for(int i=0;i<countOfZeroes;i++){
            list.add(0);
        }
    }
}
