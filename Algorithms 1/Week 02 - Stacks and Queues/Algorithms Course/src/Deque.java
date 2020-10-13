import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    
    private class Node {
        Item item;
        Node next = null;
        Node prev = null;
    }
    
    private    Node first;
    private   Node last;
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
        newNode.item = item; // create the newNode with the input item
                      
        if (first != null)
        	first.prev = newNode;
        newNode.next = first;
//        if(newNode.next !=null)
//            newNode.next.prev = newNode;
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
        if(last != null)
        	last.next = newNode;
        newNode.prev = last;
//        if(newNode.prev !=null)
//            newNode.prev.next = newNode;
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
        if(last == first) {
        	last = null;
        }
        Node oldFirst = first;
        first = first.next;
        oldFirst = null;
        if (first != null)
        	first.prev = null;
        size--;
        return returnItem;
    }
    
    // remove and return the item from the end
    public Item removeLast() {
        if (size() == 0) 
            throw new NoSuchElementException();
        
        Item returnItem = last.item;
//        last = null;
        if (first == last) {
        	first = null;
        }
        Node oldLast = last;
        last = last.prev;
        oldLast = null;
        if (last != null)
        	last.next = null;
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
    	Deque<Integer> deque = new Deque<Integer>();
    	deque.addFirst(1);
//        deque.removeLast(); 
        for(int i: deque) {
          	 System.out.println(i);	 
           }//==> 1

        System.out.println("=====");
//        deque.addFirst(1);
        deque.addLast(2);
        deque.removeLast();
        
//        deque.removeFirst(); 
        for(int i: deque) {
          	 System.out.println(i);	 
           }
        System.out.println("=====");
        deque.removeFirst();
        for(int i: deque) {
         	 System.out.println(i);	 
          }
       System.out.println("=====");
       
           // ==> 6
//        deque.addLast(8);
//        deque.addLast(9);
//        for(int i: deque) {
//       	 System.out.println(i);	 
//        }
//        System.out.println("=====");
//        deque.removeFirst();
//        for(int i: deque) {
//         	 System.out.println(i);	 
//          }
//       System.out.println("=====");

    }


}
