package Collection.List.ArrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question2 {
    // Merge two sorted list
    //Collection.List.ArrayList<Integer> list1 = new Collection.List.ArrayList<>(Arrays.asList(1, 3, 5, 7));
    // Collection.List.ArrayList<Integer> list2 = new Collection.List.ArrayList<>(Arrays.asList(2, 4, 6, 8));
    // Collection.List.ArrayList<Integer> mergedList = mergeSortedLists(list1, list2);
    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(1, 3, 5, 7));
        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(2, 4, 6, 8, 9, 10));

        ArrayList<Integer> mergedList = mergeSortedLists(list1, list2);
        System.out.println(mergedList);
    }
    public static ArrayList<Integer> mergeSortedLists(List<Integer> list1, List<Integer> list2){
        ArrayList<Integer> sortedMerge = new ArrayList<>();
        int i=0;
        int j=0;
        while(i<list1.size() && j<list2.size()){
            if(list1.get(i)<=list2.get(j)){
                sortedMerge.add(list1.get(i));
                i++;
            }
            else{
                sortedMerge.add(list2.get(j));
                j++;
            }
        }
        //list could be uneven in size
        if(i<list1.size()){
            sortedMerge.addAll(list1.subList(i, list1.size()));
        }
        if(j<list2.size()){
            sortedMerge.addAll(list2.subList(j, list2.size()));
        }
        return  sortedMerge;
    }

}

