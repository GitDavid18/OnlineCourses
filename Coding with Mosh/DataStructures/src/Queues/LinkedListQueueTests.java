package Queues;

public class LinkedListQueueTests {
    LinkedListQueueTests() {
        var queue = new LinkedListQueue();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);

        System.out.println(queue);

        System.out.println(queue.peek());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        queue.enqueue(6);
        System.out.println(queue);

    }
}
