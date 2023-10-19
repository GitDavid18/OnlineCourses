package Stacks;

import java.util.Stack;

public class StringReverser {
    public String reverse(String input){
        if(input == null)
            throw new IllegalArgumentException();

        var stack = new Stack<Character>();
        for (int i =0; i < input.length(); i++) {
            stack.push(input.charAt(i));
        }

        // continously adding a character to a string creates a new string every time.
        StringBuffer reversed = new StringBuffer();
        while (stack.empty() == false){
            reversed.append(stack.pop());
        }

        return reversed.toString();
    }
}
