#include<stdio.h>

int main(void){
    printf("Length of int %lu\n", sizeof(int));
    printf("Length of long int %lu\n", sizeof(long int));
    printf("Length of long %lu\n", sizeof(long));
    printf("Length of char %lu\n", sizeof(char));
    printf("Length of double %lu\n", sizeof(double));
    printf("Length of float %lu\n", sizeof(float));
    printf("Length of long double %lu\n", sizeof(long double));

    int  miles = 26, yards = 385;
    int kilometers;
    kilometers = 1.609 * (miles + yards/1760.0);
    printf("\nA marathon is %lf kilometers.\n", kilometers);
    test();
}

void test(void)
{
   int  a = 0, b = 1, c = 2;
   
   if(a < b){
        printf (" TRUE\n"); 
   }
   else{ printf(" FALSE\n");
   }

   if (a < b - c) {
       printf (" TRUE\n");
       } else printf(" FALSE\n");   
   
   if (b < c - 1) printf (" TRUE\n"); else printf(" FALSE\n"); 

   if (!c) printf (" TRUE\n"); else printf(" FALSE\n");
}
