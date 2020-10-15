import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdRandom;
public class RandomizedQueue<Item> implements Iterable<Item> {
    
    private Item[] content;
    
    private int size;
    
    private void resize(int capacity) {
        Item[] copy = (Item[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            if(content[i] != null) {
                copy [i]= content [i];    
            }
        }
        content = copy;
    }
    
//    construct an empty randomized queue
    public RandomizedQueue() {
        size = 0;
        content = (Item[]) new Object[1];
        
    }
    
    // is the randomized queue empty?
    public boolean isEmpty() {
        return size() == 0;
    }
    
    // return the number of items on the randomized queue
    public int size() {
        return size;
    }
    
    // add the item
    public void enqueue(Item item)  {
        if(item == null) {
            throw new IllegalArgumentException();
        }
            
        if (size >= content.length) {
            resize(2 * size);
        }
         
        content[size] = item;
        size++;
    }
    
    // remove and return a random item
    public Item dequeue() {
        if(size == 0) {
            throw new NoSuchElementException();
        }
        int randNum = StdRandom.uniform(0, size);
        Item returnItem = content [randNum];
        content[randNum] = null;
        if(--size <= content.length / 4) {
            resize(content.length/2);
        }
        return returnItem;
    }
    
    // return a random item (but do not remove it)
    public Item sample() {
        if(size == 0) {
            throw new NoSuchElementException();
        }
        return content[StdRandom.uniform(0,size)];
    }
    
    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }
    
    private class ReverseArrayIterator implements Iterator<Item>
    {
    private int i = size;
    public boolean hasNext() { return i > 0; }
    public void remove() { throw new UnsupportedOperationException();}
    public Item next() {
        if (i<0) 
            throw new NoSuchElementException();
        return content[--i]; }
    }
    
    public static void main(String[] args)  {
        // unit testing (optional)
    }
}
