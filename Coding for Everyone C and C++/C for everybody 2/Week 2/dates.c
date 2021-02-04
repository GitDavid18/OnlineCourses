/*This program calculates the next day of a given date and prints it to the screen.
Assignement option 1 - General
*/

#include<stdio.h>

typedef enum month{jan, feb, mar, apr, mai, jun, jul, aug, sep, oct, nov, dec} month;
typedef struct date{month m; int d;} date;

//This is gives the information on how long every month of the year is
int monthlength [12] = {31,28,31,30,31,30,31,31,30,31,30,31};

//Returns the next day of a date and incerements the month if today is the last day of a month
date nextday(date today){
    date tomorrow = {today.d % monthlength[today.m] == 0 ? (today.m + 1) % 12 : today.m, today.d  % monthlength[today.m] + 1};
    return tomorrow;
}

//prints curMonth as full text
//Note: %-9 gives the following string 9 characters of space. Used to nicely allign the output.
void printMonth(month curMonth){
    switch (curMonth)
        {
        case jan: printf("%-9s","January");break;
        case feb: printf("%-9s","February");break;
        case mar: printf("%-9s","March");break;
        case apr: printf("%-9s","April");break;
        case mai: printf("%-9s","Mai");break;
        case jun: printf("%-9s","June");break;
        case jul: printf("%-9s","July");break;
        case aug: printf("%-9s","August");break;
        case sep: printf("%-9s","September");break;
        case oct: printf("%-9s","October");break;
        case nov: printf("%-9s","November");break;
        case dec: printf("%-9s","December");break;
        default:printf("%d is not a valid month", curMonth);break;
        }
}

//Prints today and tomorrow in a understandable way
//%2 alligns the day nicely in the output
void printdate(date today){
    date tomorrow = nextday(today);
    printf("Today is: %2d of ", today.d);
    printMonth(today.m);
    printf(" Tomorrow is: %2d of ", tomorrow.d);
    printMonth(tomorrow.m);
    printf("\n");
}

int main(void){
    date testday= {jan,1};
    printdate(testday);

    testday.d=28;
    testday.m=feb;
    printdate(testday);

    testday.d=14;
    testday.m=mar;
    printdate(testday);

    testday.d=31;
    testday.m=oct;
    printdate(testday);

    testday.d=31;
    testday.m=dec;
    printdate(testday);

    return 0;
}
