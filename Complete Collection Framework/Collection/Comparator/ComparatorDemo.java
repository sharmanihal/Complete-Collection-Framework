package Collection.Comparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ComparatorDemo {
    public static void main(String[] args) {
        //Collection.List.ArrayList.Comparator is a functional interface that is used to compare two objects.
        //It is used to implement the comparison logic in a custom way.
        // Negative value: if the first object is less than the second object
        // Zero: if the first object is equal to the second object
        // Positive value: if the first object is greater than the second object

        List<String> words = new ArrayList<>(List.of("Apple", "Banana", "Orange", "Mango", "Pineapple", "Grapes"));
        words.sort(new StringLengthComparartor());
        System.out.println(words);

        //We can also do the same using a lambda expression
        //in this case larger length element will come first
        words.sort((o1, o2) -> o2.length()-o1.length());
        System.out.println(words);

        //say if length is same, then we can sort based on the natural order of the string
        words.sort((o1, o2) -> {
            if(o1.length()==o2.length()){
                return o1.compareTo(o2);
            }
            return o2.length()-o1.length();
        });
        System.out.println(words);
    }
}

class StringLengthComparartor implements Comparator<String> {


    //Apple length = 5
    //Banana length = 6
    //Now if we want the smalled length element to come first i.e., Apple, then we can use the following logic
    // 5-6 will give a negative value, so Apple will come first since it is o1

    //Say Apple was was o2 and o1 was banana, then 6-5 will give a positive value, means o2 will come first which is again apple.

    //What if we wanted to sort : largest length to smallest length
    //o1 Apple length = 5
    //o2 Banana length = 6

    //We want banana to come first, i.e., o2 to come first, which means a positive value should be returned.
    //so we will do o2.length()-o1.length() (6-5) which will give a positive value, so banana will come first.
    @Override
    public int compare(String o1, String o2) {
        return o1.length()-o2.length();
    }

}
