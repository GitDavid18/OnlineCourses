/*
This program reads the weight of the elephant seal population from a file
Then it will calculate the average weight of these animals and print it.
*/

#include<stdio.h>

int main(void){
    // open file for processing
    FILE *fp;
    fp = fopen("elephant_seal_data.txt", "r");
    
    // initialize variables
    int weight = 0;
    int sealAmount = 0;
    float average = 0.0;

    // scan file for integer weight values and calculate the average on the fly
    while(fscanf(fp, "%d", &weight) != EOF){
        average = average + (weight - average) / ++sealAmount;
    }

    // notify the user that the operation is done and close the file
    printf("Done! \n");
    fclose(fp);

    printf("The average weight of the elephant seal population is %lf", average);
    
    return 0;
}