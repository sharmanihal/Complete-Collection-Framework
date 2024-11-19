package Collection.Set.Questions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Question1 {
//    Intersection of Two Arrays
//    Given two arrays, return their intersection.
//    int[] nums1 = {1, 2, 2, 1};
//    int[] nums2 = {2, 2};
//    Set<Integer> result=findIntersection(nums1, nums2);
    // Expected Output: [2]

    public static void main(String[] args) {
        ArrayList<Integer> nums1= new ArrayList<>(List.of(1, 2, 2, 1,3));
        ArrayList<Integer> nums2= new ArrayList<>(List.of(2,2,1));
        Set<Integer> result=findIntersection(nums1, nums2);
        System.out.println(result);
    }

    private static Set<Integer> findIntersection(ArrayList<Integer> nums1, ArrayList<Integer> nums2) {
        Set<Integer> uniqueFromNum1 = new HashSet<>(nums1);
        Set<Integer> ans= new HashSet<>();
        //you can use linked hashset if we need to maintain order as well
        for (Integer i : nums2){
            if(uniqueFromNum1.contains(i)){
                ans.add(i);
            }
        }
        return ans;
    }
}
