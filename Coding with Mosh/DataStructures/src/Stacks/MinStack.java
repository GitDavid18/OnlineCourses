package Stacks;

public class MinStack {
    private int[] items;
    private int curIndex = 0;
    private int min;

    public MinStack(int size){
        items = new int[size];
    }

    public void push(int item){
        if(curIndex == items.length)
            throw new ArrayIndexOutOfBoundsException();
        items[curIndex++] = item;

        if(item < min)
            min = item;
    }

    public int pop()
    {
        if(curIndex == 0)
            throw new ArrayIndexOutOfBoundsException();

        var popItem = items[--curIndex];

        if(curIndex == 0)
            min = popItem;

        if(popItem == min && curIndex != 0) {
            var min = items[0];
            for (var item:items) {
                if (item < min)
                    min = item;
            }
        }

        return popItem;
    }

    public int min(){
        return min;
    }
}
