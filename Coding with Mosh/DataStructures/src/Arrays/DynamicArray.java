package Arrays;

public class DynamicArray {
    private int[] _array;
    private int _length;
    public DynamicArray(int size){
        _length = 0;
        _array = new int[size];
    }

    public void insert(int value){
        if (_length >= _array.length)
            resizeArray(_array.length + 1);
        _array[_length] = value;
        _length++;
    }

    private void resizeArray(int newLength){
        int[] newArray = new int[newLength];
        for(int i = 0; i < Math.min(_array.length, newLength); i++){
            newArray[i] = _array[i];
        }

        _array = newArray;
    }

    public int getIndexOf(int value){
        for(int i = 0; i < _array.length; i++) {
            if (_array[i] == value){
                return i;
            }
        }
        return -1;
    }

    public int removeAt(int index){
        int value = _array[index];

        for(int i = index; i < _array.length - 1; i++) {
            _array[i] = _array[i + 1];
        }

        resizeArray(_array.length - 1);
        return value;
    }

    public void print(){
        for(int i = 0; i < _array.length; i++) {
            System.out.println(_array[i]);
        }
    }
}