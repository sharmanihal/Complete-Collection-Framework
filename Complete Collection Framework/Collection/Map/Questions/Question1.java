package Collection.Map.Questions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Question1 {
    //Two Sum
    //Given an array of integers, return indices of the two numbers such that they add up to a specific target.
    //Example:
    //int[] nums = {2, 7, 11, 15};
    //int target = 9; result = {0, 1} index

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>(List.of(2, 7, 11, 15));
        int target = 9;
        HashMap<Integer,Integer> hashmap= new HashMap<>();

        for (int i=0;i<arr.size();i++){
            hashmap.put(arr.get(i), i);
        }
        boolean found =false;
        for (int i=0;i<arr.size();i++){
            if(hashmap.containsKey(target-arr.get(i))){
                System.out.println("Two Sum Found at Indexes : " + i +" and "+ hashmap.get(target-arr.get(i)));
                found=true;
                break;
            }
        }
        if(!found) {
            System.out.println("Two Sum not found !!");
        }
    }
}
