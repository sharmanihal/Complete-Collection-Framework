package Collection.List.ArrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question1 {
    //Write a program to remove all duplicates from an Collection.List.ArrayList and keep only one occurrence of each element.
    public static void main(String[] args) {
        List<Integer> numbersWithDuplicates = new ArrayList<>(Arrays.asList(1, 2, 3, 2, 4, 5, 3, 6, 7, 5, 8, 9, 6, 10));

        //Create a new Collection.List.ArrayList to store the unique elements
        List<Integer> numbersWithoutDuplicates = new ArrayList<>();

        for(Integer number: numbersWithDuplicates){
            if(!numbersWithoutDuplicates.contains(number)){
                numbersWithoutDuplicates.add(number);
            }
        }
        System.out.println(numbersWithoutDuplicates);


        //Constant Space
        for (int i =0;i<numbersWithDuplicates.size();i++){
            for(int j=i+1;j<numbersWithDuplicates.size();j++){
                if(numbersWithDuplicates.get(i) == numbersWithDuplicates.get(j)){
                    numbersWithDuplicates.remove(j);
                }
            }
        }
        System.out.println(numbersWithDuplicates);

    }

}
