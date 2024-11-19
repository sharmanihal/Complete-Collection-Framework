package Collection.List.Stack;

import java.util.LinkedList;
import java.util.Stack;

public class StackDemo {
    //Stack works on the principle of Last In First Out (LIFO)
    public static void main(String[] args) {
        //Stack extends Vector class and implements List interface
        //Stack is also thread safe
        Stack<Integer> stack = new Stack<>();

        //push() method is used to add elements to the stack
        stack.push(1);
        stack.push(2);

        //remove the top element from the stack
        System.out.println(stack.pop());

        //just returns the top element from the stack and not remove it
        System.out.println(stack.peek());

        //search() method is used to search for an element in the stack
        //It returns the 1-based position of the element from the top of the stack
        //If the element is not found, it returns -1
        System.out.println(stack.search(1));



        //Since stack is thread safe , it doesn't make much sense to use it in a single threaded environment
        //In that case we can also use LinkedList as a stack

        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.push(1);
        linkedList.push(2);
        linkedList.push(3);
        linkedList.push(4);

        System.out.println("Pop : "+ linkedList.pop());
        System.out.println("Peek : "+ linkedList.peek());


    }
}
