package Queues;

import java.util.Arrays;

public class ArrayQueue {
    private int addIndex = 0;
    private int returnIndex = 0;

    private int count = 0;
    private int[] queue;

    public ArrayQueue(int size){
        queue = new int[size];
    }

    public void enqueue(int item){
        if(isFull())
            throw new IllegalArgumentException();
        queue[addIndex] = item;
        addIndex = (addIndex + 1) % queue.length;
        count++;
    }

    public int dequeue(){
        if(isEmpty())
            throw new IllegalArgumentException();
        var returnvalue = queue[returnIndex];
        queue[returnIndex] = 0;
        count--;
        returnIndex = (returnIndex + 1) % queue.length;
        return returnvalue;
    }

    public int peek(){
        if(isEmpty())
            throw new IllegalArgumentException();
        return queue[returnIndex];
    }

    public boolean isEmpty(){
        return count == 0;
    }

    public boolean isFull(){
        return count == queue.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(queue);
    }
}
