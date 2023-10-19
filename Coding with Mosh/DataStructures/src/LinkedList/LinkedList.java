package LinkedList;

import java.util.NoSuchElementException;

public class LinkedList {
    private Node first;
    private Node last;

    private int size;

    public int Size(){
        return size;
    }

    //addFirst
    public void AddFirst(int value){
        var newNode = new Node();
        newNode.value = value;
        if(first == null) {
            last = newNode;
            first = newNode;
        }
        else {
            newNode.next = first;

            first = newNode;
        }
        size++;
    }

    //addLast
    public void AddLast(int value){
        var newNode = new Node();
        newNode.value = value;
        if(last == null) {
            last = newNode;
            first = newNode;
        }
        else {
            last.next = newNode;
            last = newNode;
        }
        size++;
    }

    //deleteFirst
    public void DeleteFirst(){
        if (first == null)
            throw new NoSuchElementException();
        if(first == last )
            first = last = null;
        else {
            var newFirst = first.next;
            var oldFirst = first;

            first = newFirst;
            oldFirst = null;
        }

        size--;
    }

    //deleteLast
    public void DeleteLast(){
        if (last == null)
            throw new NoSuchElementException();
        if(first == last )
            first = last = null;
        else{
            var curNode = first;
            var prevNode = first;

            while (curNode.next != null){
                prevNode = curNode;
                curNode = curNode.next;
            }
            last = prevNode;
            curNode = null;
        }

        size--;
    }

    //contains
    public boolean Contains(int value){
        var curNode = first;

        while (curNode.next != null){
            if(curNode.value == value){
                return true;
            }
            curNode = curNode.next;
        }

        return false;
    }

    //indexOf
    public int IndexOf(int value){
        var curNode = first;
        var index = 0;

        while (curNode.next != null){
            if(curNode.value == value){
                return index;
            }
            curNode = curNode.next;
            index++;
        }

        return -1;
    }

    public void Reverse(){
        if(size == 0){
            return;
        }

        var previous = first; //1
        var current = first.next; //2

        while(current != null){
            var next = current.next; //3
            current.next = previous;

            previous = current;
            current = next;
        }

        last = first;
        last.next = null;
        first = previous;
    }

    public int GetKthFromEnd(int k){
        if(first == null)
            throw new NoSuchElementException();

        if(k < 1)
            throw new IllegalArgumentException();
        if(k == 1)
            return last.value;

        var distance = k - 1;
        var current = first;

        for (int i = 0; i < distance; i++){
            current = current.next;
            if(current == null)
                throw new IllegalArgumentException();
        }

        var target = first;
        while(current != last){
            target = target.next;
            current = current.next;
        }
        return target.value;
    }

    public void PrintMiddle(){
        if(first == null)
            throw new IllegalArgumentException("List is empty");

        var fastNode = first;
        var slowNode = first;
        var numOfNodes = 1;

        while(fastNode != last){
            fastNode = fastNode.next;
            numOfNodes++;
            if(numOfNodes % 2 == 1){
                slowNode = slowNode.next;
            }
        }

        System.out.println("There are " + numOfNodes + " nodes.");
        if(numOfNodes % 2 == 0){
            System.out.println("There are 2 middle nodes: " + slowNode.value + " and " + slowNode.next.value);
        }
        else{
            System.out.println("There middle node is: " + slowNode.value);
        }

    }

    public Boolean HasLoop(){
        var fastNode = first;
        var slowNode = first;

        if(first == null)
            return false;

        if(first == last)
            return false;

        var curNum = 1;
        while (fastNode.next != null){
            fastNode = fastNode.next;
            curNum++;

            if(curNum % 2 == 1)
                slowNode = slowNode.next;

            if(fastNode == slowNode)
                return true;
        }
        return false;
    }
}
