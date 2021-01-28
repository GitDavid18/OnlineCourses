#include<stdio.h>

#define PI 3.14159

int main(){
    printf("Hello\n");

    double area = 0.0, radius = 0.0;
    printf("Enter radius: ");
    scanf("%lf", &radius);
    area = PI * radius * radius ;
    printf("radius of %lf meters, area is %lf sq. meters\n", radius, area);


    return 0;
}