package Collection.List.ArrayList;

import java.util.ArrayList;
import java.util.Arrays;

public class Question3 {
    //Rotate an Array List by k positions
    //Collection.List.ArrayList<Integer> list = new Collection.List.ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
    //Collection.List.ArrayList<Integer> rotatedList = rotateList(list, 2);
    //// Expected Output: [4, 5, 1, 2, 3]

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        ArrayList<Integer> rotatedList = rotateList(list, 5);
        System.out.println(rotatedList);
    }
    public static ArrayList<Integer> rotateList(ArrayList<Integer> list, int k){
        if(k==0 || k==list.size() || list.size()%k==0){
            return list;
        }
        while(k!=0){
            int tmp = list.removeLast();
            list.addFirst(tmp);
            k--;
        }
        return list;
    }
}
