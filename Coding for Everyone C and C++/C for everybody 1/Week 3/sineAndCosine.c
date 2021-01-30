/*
This program prints the values of sine and cosine in 0.1 steps between 0.0 and 1.0
*/

#include <stdio.h>
#include <math.h>

int main(void){
    for(int i = 0; i<=10; i++){
        double var = i / 10.0;
        printf("Sin(%lf) = %lf, Cos(%lf) = %lf\n", var, sin(var), var, cos(var));
    }
}