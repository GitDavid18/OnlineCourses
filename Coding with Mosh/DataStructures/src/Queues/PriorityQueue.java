package Queues;

import java.util.Arrays;

public class PriorityQueue {
private int[] items;
private int numOfItems;
    public PriorityQueue(int size){
        items = new int[size];
        numOfItems = 0;
    }

    public int dequeue (){
        if(isEmpty())
            throw new IllegalStateException();
        var returnItem = items[--numOfItems];
        items[numOfItems] = 0;
        return returnItem;
    }

    public int peek(){
        if(isEmpty())
            throw new IllegalStateException();

        return items[numOfItems - 1];
    }
    public void enqueue (int item){
        if (isFull())
            throw new IllegalArgumentException();

        var compareIndex = numOfItems - 1;
        for ( ;compareIndex >= 0; compareIndex-- ){
            if(item < items[compareIndex])
                shiftItem(compareIndex);
            else{
                break;
            }
        }
        items[compareIndex + 1] = item;
        numOfItems++;
    }

    private void shiftItem(int currentIndex){
        items[currentIndex + 1] = items[currentIndex];
    }

    private boolean isEmpty(){
        return numOfItems == 0;
    }

    private boolean isFull(){
        return items.length == numOfItems;
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }
}
