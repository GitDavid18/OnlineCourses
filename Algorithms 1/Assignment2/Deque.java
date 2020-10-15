import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    
    private class Node {
        Item item;
        Node next = null;
        Node prev = null;
    }
    
    private Node first;
    private Node last;
    private int size;
    
    // construct an empty deque
    public Deque() {
        size = 0;
        first = null;
        last = null;
    }
    
    // is the deque empty?
    public boolean isEmpty()   {
        return size() == 0;
    } 
    
    // return the number of items on the deque
    public int size() {
        return size;
    }
    
 // add the item to the front
    public void addFirst(Item item) {
        if (item == null)
            throw new IllegalArgumentException();
        Node newNode = new Node();
        newNode.item = item;
        newNode.next = first;
        if(newNode.next !=null)
            newNode.next.prev = newNode;
        first = newNode;
        size++;

        if (last == null)
            last = newNode;
    }
    
    // add the item to the end
    public void addLast(Item item) {
        if (item == null)
            throw new IllegalArgumentException();
        
        Node newNode = new Node();
        newNode.item = item;
        newNode.prev = last;
        if(newNode.prev !=null)
            newNode.prev.next = newNode;
        last = newNode;
        size++;
        
        if (first == null)
            first = newNode;
    }
    
    // remove and return the item from the front
    public Item removeFirst() {
        if (size() == 0)
            throw new NoSuchElementException();
        Item returnItem = first.item;
        Node oldFirst = first;
        oldFirst = null;
        first = first.next;
        size--;
        return returnItem;
    }
    
    // remove and return the item from the end
    public Item removeLast() {
        if (size() == 0) 
            throw new NoSuchElementException();
        Item returnItem = last.item;
        Node oldLast = last;
        oldLast = null;
        last = last.prev;
        size--;
        return returnItem;
    }
    
//     return an iterator over items in order from front to end
    public Iterator<Item> iterator() {
        return new ListIterator();
    }
    
    private class ListIterator implements Iterator<Item>{
        private Node current = first;
       
        @Override
        public boolean hasNext() {
            return current != null;
        }
        
        public void remove() { throw new UnsupportedOperationException();}
        @Override
        public Item next() {
            if(hasNext()) {
                Item item = current.item;
                current = current.next;
                return item;
            }else {
                throw new NoSuchElementException();
            }
                
                
        }
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }


}
