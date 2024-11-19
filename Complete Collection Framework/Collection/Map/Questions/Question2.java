package Collection.Map.Questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Question2 {
    //Group Anagrams
    //Given an array of strings, group the anagrams together.
    //String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
    // Expected Output: [["eat","tea","ate"],["tan","nat"],["bat"]]
    public static void main(String[] args) {
        List<String> strs = new ArrayList<>(List.of("eat", "tea", "tan", "ate", "nat", "bat"));
        HashMap<String, ArrayList<String>> hashmap= new HashMap<>();

        for (String s : strs){
            int[] charCount = new int[26];
            for(int i =0;i<s.length();i++){
                charCount[s.charAt(i)-'a']++;
            }
            String key = Arrays.toString(charCount);
            if(!hashmap.containsKey(key)){
                hashmap.put(key,new ArrayList<>());
            }
            hashmap.get(key).add(s);

        }


    }
}
