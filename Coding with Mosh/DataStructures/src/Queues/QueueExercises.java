package Queues;


import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

//3- Build a stack using two queues. Implement the following operations and calculate their runtime complexities.
// -push -pop  -peek -size  -isEmpty
public class QueueExercises {

    public void TestExercises(){
        var queue = new ArrayDeque<Integer>();
        queue.add(1);
        queue.add(5);
        queue.add(8);
        queue.add(2);
        queue.add(3);
        queue.add(0);
        System.out.println(queue);

        queue = ReverseQueue(queue, 3);
        System.out.println(queue);
    }

    //1 Given an integer K and a queue of integers, write code to reverse the order of the first K elements of the queue.
    // Input:  Q = [10, 20, 30, 40, 50], K = 3
    // Output: Q = [30, 20, 10, 40, 50]
    public ArrayDeque<Integer> ReverseQueue(Queue<Integer> queue, int amountOfElements){
        var stack = new Stack<Integer>();
        for (int i =0; i< amountOfElements; i++){
            stack.push(queue.poll());
        }

        var returnQueue = new ArrayDeque<Integer>();
        while (stack.empty() == false)
            returnQueue.add(stack.pop());

        for (var item : queue) {
            returnQueue.add(item);
        }

        return returnQueue;
    }



}
