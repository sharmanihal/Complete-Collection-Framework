package Collection.List.LinkedList;

import java.util.Arrays;
import java.util.LinkedList;

//Find the Majority Element
//Write a method to find the majority element in an ArrayList of integers. The majority element is the element that appears more than half the time.
public class Question2 {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>(Arrays.asList(2, 2, 1, 1, 1, 2, 2));
        int majorityElement = findMajorityElement(list);
        //// Expected Output: 2
        System.out.println(majorityElement);
    }

    private static int findMajorityElement(LinkedList<Integer> list) {
        int majorityElement=list.getFirst();
        int count=1;
        for (Integer ele:list){
            if(ele==majorityElement){
                count+=1;
            }
            else {
                if(count==0 && ele!=majorityElement){
                    majorityElement=ele;
                    count=1;
                }else{
                    count-=1;
                }
            }
        }
        return majorityElement;
    }

}
