package Collection.List.Stack;

import java.util.Stack;

public class Question2 {
    //Check for Balanced Parentheses
    //Write a method to check if a given string containing parentheses (and other characters) has balanced parentheses using a stack.
    public static void main(String[] args) {
        String input = "((())())";
        boolean isBalanced = checkBalancedParentheses(input);
        // Expected Output: true
        System.out.println(isBalanced);
    }

    private static boolean checkBalancedParentheses(String input) {
        Stack<Character> stack = new Stack<>();

        for(int i = 0;i<input.length();i++){
            if(stack.isEmpty() && input.charAt(i)==')'){
                return false;
            }
            if(input.charAt(i)=='('){
                stack.push('(');
            }else{
                if(stack.peek()=='('){
                    stack.pop();
                }else {
                    return false;
                }
            }
        }
        //if stack is empty then all the parentheses are balanced else they are not balanced
        return stack.isEmpty();
    }
}
