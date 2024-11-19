package Collection.Set.Questions;

import java.util.*;

public class Question3 {
    //Two Sum - Unique Pairs
    //Given an array of integers and a target value, return all unique pairs that sum up to the target value.
    //int[] nums = {1, 1, 2, 2, 3, 3};
    //int target = 4;
    //Set<Set<Integer>> result = uniquePairs(nums, target);
    // Expected Output: [[1, 3], [2, 2]]
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>(List.of(1, 1, 2, 2, 3, 3));
        int target = 4;
        Set<ArrayList<Integer>>  result = uniquePairs(nums, target);
        // Expected Output: [[1, 3], [2, 2]]
        System.out.println(result);
    }

    private static Set<ArrayList<Integer>> uniquePairs(ArrayList<Integer> nums, int target) {
        HashMap<Integer,Integer> hashMap= new HashMap<>();
        Set<ArrayList<Integer>>   pairs= new HashSet<>();
        for (int i=0;i<nums.size();i++){
            hashMap.put(nums.get(i),i);
        }
        System.out.println(hashMap);
        for (int i=0;i<nums.size();i++){
            if(hashMap.containsKey(target-nums.get(i)) && i<hashMap.get(target-nums.get(i))) {
                ArrayList<Integer> pair= new ArrayList<>();
                pair.add(nums.get(i));
                pair.add(target - nums.get(i));

                pairs.add(pair);
            }
        }
        return pairs;
    }


}
