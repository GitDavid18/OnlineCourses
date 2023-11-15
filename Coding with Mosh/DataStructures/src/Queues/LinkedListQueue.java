package Queues;

//2- Build a queue using a linked list from scratch. Implement the following operations and calculate their runtime complexities.
// -enqueue -dequeue -peek -size -isEmpty
public class LinkedListQueue {
    private class Item {

        Item(int itemValue) {
            value = itemValue;
        }

        int value;
        Item next;
    }

    private Item first;
    private Item last;
    private int size = 0;

    public void enqueue(int item) {
        var newItem = new Item(item);
        if (isEmpty()) {
            first = newItem;
            last = newItem;
        }
        last.next = newItem;
        last = newItem;
        size++;
    }

    public int dequeue() {
        if (isEmpty())
            throw new IllegalStateException();

        var returnItem = first.value;
        first = first.next;
        return returnItem;
    }

    public int peek() {
        return first.value;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public String toString() {
        var returnString = "[";
        var currentItem = first;
        while (currentItem.next != null) {
            returnString += currentItem.value;
            currentItem = currentItem.next;
            returnString += ", ";

            if (currentItem.next == null)
                returnString += currentItem.value;
        }

        returnString += "]";
        return returnString;
    }
}
