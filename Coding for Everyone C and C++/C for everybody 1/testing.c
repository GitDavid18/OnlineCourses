#include <stdio.h>

//Fibonaci numbers
// F(n) = F(n - 1) + F(n - 2)
long rec_fibonaci(int n){
    if(n <= 1){
        return n;
    }else{
        //printf("%i\n", n);
        long erg = rec_fibonaci(n - 1) + rec_fibonaci(n - 2);
        // printf("erg = %ld\n", erg);
        return (erg);
    }

}

int main(void){
   
    int a = 1, b = 2, c = 3;
    int *i = &a, *k = &b;
    printf("%d, %d\n",i, k);
    int n = 24;
    for (int i = 1; i <= n; i++){
        // printf("%d -> %ld\n", i, rec_fibonaci(i));
    }
    

    return 0;
}