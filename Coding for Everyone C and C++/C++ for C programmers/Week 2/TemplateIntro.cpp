#include <iostream>

using namespace std;

template <class T>
T sum (const T data[], int size, T s = 0){
    for (int i = 0; i < size; i++){
        s += data[i];
    }
    return s;
}

template <class T>
T substract(const T data[], int size, T s = 0){
    for (int i = 0; i < size; i++){
        s -= data[i];
    }
    return s;
}

template <class T>
T printT(const T data[], int size){
    for (int i = 0; i < size; i++){
        if (i != 0){
            cout << ", ";
        }
        cout << data[i];
    }
    cout << endl;
}

int main(){
    double a[10];
    int b[5];
    for (int i = 0; i < 10; i++){
        a[i] = i * 2.0;
    }
    for (int i = 0; i < 5; i++){
        b[i] = (i + 1) * 3;
    }

    cout << "Content of double a: ";
    printT(a, 10);
    cout << "Sum of double a: " << sum(a, 10) << endl;
    cout << "100 - sum of double a: " << substract(a, 10, 100.0) << endl;
    cout << "Content of int b: ";
    printT(b, 5);
    cout << "Sum of int b: " << sum(b, 5) << endl;
    cout << "100 - sum of int b: " << substract(b, 5, 100) << endl;

    return 0;
}