import Arrays.DynamicArray;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        DynamicArray array = new DynamicArray(3);
        array.insert(10);
        array.insert(20);
        array.insert(30);
        array.insert(40);
        array.print();

        array.removeAt(0);
        array.print();
    }
}