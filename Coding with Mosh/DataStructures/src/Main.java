import Arrays.DynamicArray;
import LinkedList.LinkedList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        LinkedList list = new LinkedList();
        list.AddLast(10);
        list.PrintMiddle();
        list.AddLast(20);
        list.PrintMiddle();
        list.AddLast(30);
        list.PrintMiddle();
        list.AddLast(40);
        list.PrintMiddle();

//        list.Reverse();

        System.out.println(list.GetKthFromEnd(1));
        System.out.println(list.GetKthFromEnd(2));
        System.out.println(list.GetKthFromEnd(3));

        list.PrintMiddle();
    }
}