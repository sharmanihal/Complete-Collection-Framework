package Collection.List.LinkedList;

import java.util.Arrays;
import java.util.LinkedList;

public class Question1 {
    //Find all Pairs with a Given Sum
    //Write a method to find all pairs of integers in an LinkedList that sum up to a given target value.
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        int target = 10;
        // Expected Output: [(1, 9), (2, 8), (3, 7), (4, 6)]
        findPairs(linkedList, target);
    }

    private static void findPairs(LinkedList<Integer> linkedList, int target) {
        for (int i = 0; i < linkedList.size(); i++) {
            for (int j = i + 1; j < linkedList.size(); j++) {
                if (linkedList.get(i) + linkedList.get(j) == target) {
                    System.out.println("(" + linkedList.get(i) + ", " + linkedList.get(j) + ")");
                }
            }

        }
    }
}
