#include<stdio.h>
struct point{
double x;
double y;
} p1 = { 4};



int main(void){
    printf("%f\n", p1.x);
    return 0;
}