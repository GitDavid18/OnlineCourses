package Stacks;

public class Stack {

    private int[] values;
    private int indexOfLastValue = 0;
    public Stack(){
        values = new int[1];
    }

    //push
    public void push(int newValue){
        if(values.length > indexOfLastValue)
            values[indexOfLastValue++] = newValue;
        //resize         
    }

    //pop
    public int Pop(){
        if(IsEmpty() == false) {
            //resize
            return values[indexOfLastValue - 1];
        }
        return 0;
    }

    //peek
    public int Peek(){
        if(IsEmpty() == false)
            return values[indexOfLastValue - 1];
        return 0;
    }

    //isEmpty
    public boolean IsEmpty(){
        return indexOfLastValue == 0;
    }


}
