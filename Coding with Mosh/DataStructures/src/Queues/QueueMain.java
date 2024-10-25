package Queues;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class QueueMain
{
    public static void main(String[] args) {
        //Test TwoStackQueue
       TestTwoStackQueue();


        //TestPriorityQueue();
        //var y = new LinkedListQueueTests();
        //var x = new QueueExercises();
        //x.TestExercises();
    }

    private static void TestTwoStackQueue(){
        var queue = new TwoStackQueue();
        queue.push(11);
        queue.push(22);

        queue.push(33);
        queue.push(44);
        queue.push(55);

        System.out.println(queue.toString());
        System.out.println("peek " + queue.peek());
        System.out.println("dequeue " +queue.pop());
        System.out.println("peek " +queue.peek());
        System.out.println("dequeue " +queue.pop());
        queue.push(66);
        System.out.println(queue.toString());

        queue.push(77);
        System.out.println(queue.toString());

        System.out.println("dequeue " +queue.pop());
        System.out.println(queue.toString());
    }

    private static void TestPriorityQueue(){
        var queue = new PriorityQueue(5);
        queue.enqueue(20);
        queue.enqueue(50);

        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(10);

        System.out.println(queue.toString());
        System.out.println("peek " + queue.peek());
        System.out.println("dequeue " +queue.dequeue());
        System.out.println("peek " +queue.peek());
        System.out.println("dequeue " +queue.dequeue());
        queue.enqueue(60);
        System.out.println(queue.toString());

        queue.enqueue(70);
        System.out.println(queue.toString());

        System.out.println("dequeue " +queue.dequeue());
        System.out.println(queue.toString());
    }

    private static void ReverseQueue(){
        var queue = new ArrayDeque<Integer>();

        queue.add(10);
        queue.add(20);
        queue.add(30);

        reverse(queue);
    }

    public static void reverse(ArrayDeque<Integer> queue){
        var stack = new Stack<Integer>();

        while(queue.isEmpty() == false){
            stack.push(queue.remove());
        }

        while (stack.isEmpty() == false)
            queue.add(stack.pop());

        System.out.println("Reversed queue: " + queue);
    }

    private static void ArrayQueueTests(){
        var queue = new ArrayQueue(5);
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        System.out.println(queue.toString());
        System.out.println(queue.peek());
        System.out.println(queue.dequeue());
        System.out.println(queue.peek());
        System.out.println(queue.dequeue());
        queue.enqueue(60);
        System.out.println(queue.toString());

        queue.enqueue(70);
        System.out.println(queue.toString());

        System.out.println(queue.dequeue());
        System.out.println(queue.toString());

    }
}
