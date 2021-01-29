#include<stdio.h>
#include<math.h>

int main(void){
    double input = 0.0;

    //read an input value
    printf("Please insert a value between 0.0 and 1.0 (not included): ");
    scanf("%lf", &input);
    printf("Your input = %lf\n", input);

    //check if input value is between 0.0 and 1.0
    if(input < 0.0 || input >= 1.0){
        printf("The inserted value is too big or too small.\nPlease only insert values between 0.0 and 1.0(not included)");
    }
    else{
        printf("The sin of %lf = %lf", input ,sin(input));
    }

}