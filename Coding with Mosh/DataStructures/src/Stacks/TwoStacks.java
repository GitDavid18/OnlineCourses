package Stacks;

import java.lang.reflect.Array;
import java.util.Arrays;

public class TwoStacks {

    private int index1;
    private int index2;
    private int[] items;
    public TwoStacks(int capacity){
        if (capacity <= 0)
            throw new IllegalArgumentException("capacity must be 1 or greater.");

        items = new int[capacity];
        index1 = -1;
        index2 = capacity;
    }

    public void push1(int item)  {
        if(isFull1())
            throw new IllegalStateException();

        items[++index1] = item;
    }

    private boolean isFull1(){
        return index2 == index1 + 1;
    }

    public int pop1() {
        if(isEmpty1())
            throw new IllegalStateException();

        return items[index1--];
    }

    private boolean isEmpty1(){
        return index1 == -1;
    }

    public void push2(int item){
        if (isFull2())
            throw new IllegalStateException();

        items[--index2] = item;
    }

    private boolean isFull2(){
        return index1 == index2 -1;
    }

    public int pop2(){
        if(isEmpty2())
            throw new IllegalStateException();

        return items[index2++];
    }

    private boolean isEmpty2(){
        return index2 == items.length + 1;
    }

    @Override
    public String toString() {
        return Arrays.toString( items);
    }
}