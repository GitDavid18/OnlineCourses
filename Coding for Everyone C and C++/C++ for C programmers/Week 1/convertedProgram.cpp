/*   Convert this program to C++
*   change to C++ io
*   change to one line comments
*   change defines of constants to const
*   change array to vector<>
*   inline any short function
*/

//#include <stdio.h>
#include <iostream>
#include <vector>
using namespace std;
// #define N 40
const int N = 40;

//void sum(int*p, int n, int d[])
// void sum(int &p, int n, int data[])
// {
//   //int i;
//   int i;
//   //*p = 0;
//   p = 0;
//   //for(i = 0; i < n; ++i)
//   for(i = 0; i < n; ++i){
//     //*p = *p + d[i];
//     p += data[i];
//   }
// }

int sum(vector<int> vec){
    int res = 0;
    for(int i = 0; i < vec.size(); ++i){
        res += i;
    }
    return res;
}

int main()

{
   //int i;
   //int accum = 0;
   //int data[N];
    vector<int> vec;
    // for(i = 0; i < N; ++i)
    //   data[i] = i;
   for(int i = 0; i < N; ++i){
       vec.push_back(i);
   }
    // sum(&accum, N, data);

    // printf("sum is %d\n", accum); 
    cout << "sum is " << sum(vec) << endl;
    return 0;

}