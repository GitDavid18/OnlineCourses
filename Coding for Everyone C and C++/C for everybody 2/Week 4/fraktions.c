#include<stdio.h>
#include<stdlib.h>
#include<math.h>

typedef struct rational
{
    int numerator;
    int denominator;
} rational;

#define MIN(a,b) (((a)<(b))?(a):(b))
#define MAX(a,b) (((a)>(b))?(a):(b))

rational reduceFactions(rational *a, int start){
// printf("Reducing: %d/%d, start: %d\n", a->numerator, a->denominator, start);
    if(MIN(a->denominator, a->numerator) / start == 0){
        // printf("returning\n");
        return *a;
    }

    if(a->numerator % start == 0 && a->denominator % start == 0){
        // printf("same start\n");
        a->numerator = a->numerator / start;
        a->denominator = a->denominator / start;
        reduceFactions(a, start);
    }
    else{
        // printf("Next step.\n");
        reduceFactions(a, ++start);
    }
    // printf("this will return: %d/%d\n", a->numerator, a->denominator);
    return *a;
}

rational reduceRational(rational *a){
    if (a->numerator == a->denominator){
        // printf("They are equal");
        a->denominator = 1;
        a->numerator = 1;
    }
    else{
        reduceFactions(a, 2);
    }
    // printf("I will return: %d/%d\n", a->numerator, a->denominator);
    return *a;
}

rational addRational(rational a, rational b){
    rational result;
    result.numerator = a.numerator * b.denominator + b.numerator * a.denominator;
    result.denominator = a.denominator * b.denominator;
    return reduceRational(&result);
}

rational substractRational(rational a, rational b){
    rational result;
    result.numerator = a.numerator * b.denominator - b.numerator * a.denominator;
    result.denominator = a.denominator * b.denominator;
    return reduceRational(&result);
}

rational multiplyRational(rational a, rational b){
    rational result;
    result.numerator = a.numerator * b.numerator;
    result.denominator = a.denominator * b.denominator;
    return reduceRational(&result);
}

rational divideRationals(rational a, rational b){
    rational result;
    result.numerator = a.numerator * b.denominator;
    result.denominator = a.denominator * b.numerator;
    return reduceRational(&result);
}

void main(void){
    FILE *ifp;
    ifp = fopen("data.txt", "r");
    
    int c[15];
    rewind(ifp);

    int numOfRat = 0;
    fscanf(ifp, "%d", &numOfRat);
    printf("Number of rationals: %d\n", numOfRat);

    rational inputRationals[numOfRat];

    int size = 0;
    while(fscanf(ifp, "%d", &c[size]) == 1){
        
        printf("%d  ", c[size]);
        if(size % 2 == 0){
            inputRationals[size / 2].numerator = c[size];
        }else{
            inputRationals[size / 2].denominator = c[size];
        }
        size++;
    }
    printf("\n");

    rational avg;
    avg.numerator = 0;
    avg.denominator = 1;

    for(int i = 0; i < numOfRat; i++){
        printf("Rational %d: %d/%d\n", i, inputRationals[i].numerator, inputRationals[i].denominator);
        avg = addRational(avg, inputRationals[i]);
    }

    rational sum = avg;
    rational numberOfRat;
    numberOfRat.numerator = numOfRat;
    numberOfRat.denominator = 1;
    avg = divideRationals(avg, numberOfRat);
    
    printf("The sum is: %d/%d\nThe avereage is: %d/%d", sum.numerator, sum.denominator, avg.numerator, avg.denominator);

    fclose(ifp);
    return 0;
}