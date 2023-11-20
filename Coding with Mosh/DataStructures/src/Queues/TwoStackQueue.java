package Queues;

import java.util.Stack;
//3- Build a stack using two queues. Implement the following operations and calculate their runtime complexities.
// -push -pop  -peek -size  -isEmpty
public class TwoStackQueue {

    private Stack<Integer> firstStack;
    private Stack<Integer> secondStack;

    TwoStackQueue(){
        firstStack = new Stack<Integer>();
        secondStack = new Stack<Integer>();
    }

    //push O(n)
    public void push (Integer item){
        firstStack.push(item);
        reverseFirstStack();
    }

    private void reverseFirstStack(){
        var helperStack = firstStack;

        while (helperStack.isEmpty() == false){
            secondStack.push(helperStack.pop());
        }
    }

    //pop O(1)
    public Integer pop(){
        return secondStack.pop();
    }

    //peek O(1)
    public Integer peek(){
        return secondStack.peek();
    }

    //size O(1)
    public Integer size() {
        return secondStack.size();
    }

    //isEmpty O(1)
    public Boolean isEmpty(){
        return secondStack.isEmpty();
    }

    @Override
    public String toString() {
        return secondStack.toString();
    }
}
