package Queues;

import java.util.Stack;

public class StackQueue {
    private Stack<Integer> helperStack;
    private Stack<Integer> ItemStack;

    public StackQueue(){
        helperStack = new Stack<Integer>();
        ItemStack = new Stack<Integer>();
    }

    public Integer dequeue(){
        if(ItemStack.isEmpty())
            throw new IllegalStateException();
        return ItemStack.pop();
    }
    public int peek(){
        if(ItemStack.isEmpty())
            throw new IllegalStateException();
        return ItemStack.peek();
    }

    public void enqueue(int item){
        helperStack.push(item);
        ItemStack = new Stack<Integer>();
        for (var reItem: helperStack) {
            ItemStack.push(reItem);
        }
    }


}
