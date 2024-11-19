package Collection.Set.Questions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Question2 {
    //Longest Consecutive Sequence
    //Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
    //int[] nums = {100, 4, 200, 1, 3, 2};
    //int result = longestConsecutive(nums);
    //// Expected Output: 4

    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>(List.of(100, 4, 200, 1, 3, 2));
        int result = longestConsecutive(nums);
        //// Expected Output: 4
        System.out.println(result);

    }

    private static int longestConsecutive(ArrayList<Integer> nums) {
        Set<Integer> integerSet = new HashSet<>(nums);
        int maxCount=0;
        for (Integer i : nums){
            //If the integerSet does not contain i-1 means we can start searching for out consecutive sequence starting i .
            if (!integerSet.contains(i-1)){
                int num=i;
                int count=0;

                while (integerSet.contains(num)){
                    count+=1;
                    num+=1;
                }
                maxCount= Math.max(count,maxCount);
            }
        }
        return maxCount;
    }
}
