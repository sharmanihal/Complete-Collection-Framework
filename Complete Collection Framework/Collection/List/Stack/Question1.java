package Collection.List.Stack;
import java.util.Stack;
public class Question1 {
    //Evaluate a Postfix Expression
    //Write a method to evaluate a given postfix expression (Reverse Polish notation) using a stack.
    public static void main(String[] args) {
        String expression = "231*+9-";
        int result = evaluatePostfix(expression);
        // Expected Output: -4
        System.out.println(result);
    }
    private static int evaluatePostfix(String expression) {
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<expression.length();i++){
            char c= expression.charAt(i);
            if(Character.isDigit(c)){
                //subract '0' to get the integer value of the character
                stack.push(c-'0');
            }
            else{
                int val1 = stack.pop();
                int val2 = stack.pop();
                if(c=='+'){
                    stack.push(val2+val1);
                }
                if (c=='-'){
                    stack.push(val2-val1);
                }
                if (c=='*'){
                    stack.push(val2*val1);
                }
                if (c=='/'){
                    stack.push(val2/val1);
                }
            }
        }
        return stack.pop();
    }
}
