package Stacks;

import java.util.Stack;

public class ExpressionChecker {
    public boolean IsBalanced(String input){
        if (input == null)
            throw new IllegalArgumentException();

        var brackets = new Stack<Character>();

        for(var c: input.toCharArray()){
            if(c == '(' ||c == '['||c == '{'||c == '<')
                brackets.push(c);

            if (c == ')')
                if (brackets.empty() || brackets.pop() != '(')
                    return false;

            if (c == ']')
                if (brackets.empty() || brackets.pop() != '[')
                    return false;

            if (c == '}')
                if (brackets.empty() || brackets.pop() != '{')
                    return false;

            if (c == '>')
                if (brackets.empty() || brackets.pop() != '<')
                    return false;

            }

        return brackets.empty();
    }
}
