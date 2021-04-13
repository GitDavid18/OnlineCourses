#include<stdio.h>
#include<stdlib.h>
#include<math.h>

typedef struct tree 
{
    int number;
    struct tree *right;
    struct tree *left;
} tree;

tree* createTree(int num){
    tree* seed = malloc(sizeof(tree));
    seed -> number = num;
    seed -> left = NULL;
    seed -> right = NULL;
    return seed;
}

int hasLeft (tree* input){
    return input -> left == NULL ? 0 : 1;
}

int hasRight (tree* input){
    return input -> right == NULL ? 0 : 1;
}

tree* addLeft(tree* input, int num){
    tree* node = createTree (num);
    input -> left = node;
    // printf("Adding %d on the left of: %d", num, input -> number);
    return input;
}

tree* addRight(tree* input, int num){
    tree* node = createTree (num);
    // printf("Adding %d on the right of: %d", num, input -> number);
    input -> right = node;
    return input;
}

tree* addNumber(tree* input, int num){  
    if(input != NULL){
        if (input -> number > num){
            // printf("%d is smaller than %d\n", num, input -> number);
            if(hasLeft(input) == 1){
                // printf("Has Left\n");
                addNumber(input -> left, num);
            }
            else{
                // printf("Has NO Left\n");
                addLeft(input, num);
            }
        }
        else{
            // printf("%d is bigger than %d\n", num, input -> number);
            if(hasRight(input) == 1){
                // printf("Has Right\n");
                addNumber(input -> right, num);
            }
            else{
                // printf("Has NO Right\n");
                addRight(input, num);
            }
        }
    }
    else{
        // printf("Tree is NULL\n");
        input = createTree(num);
    }

    return input;
}

void printTree(tree* input){
    if(hasLeft(input)){
        printTree(input -> left);
    }
    printf(" %d ", input -> number);

    if(hasRight(input)){
        printTree(input -> right);
    }
}
// reads a file into an array
// returns the number of number in the file
int  readFileToArray(char *fileName, int *nums){
    FILE *ifp;
    ifp = fopen("data.txt", "r");

    rewind(ifp);

    int numOfNum = 0;
    fscanf(ifp, "%d", &numOfNum);

    //data.txt was initially created for the fraktions program.
    numOfNum *= 2;
    printf("Numbers in files: %d\n", numOfNum);

    // int c[numOfNum];
    int i = 0;
    while(fscanf(ifp, "%d", &nums[i]) == 1){
        printf("%d  ", nums[i]);
        i++;
    }

    return numOfNum;
}

void main(void){
    
    char fileName[20] = "data.txt";

    int numbers[10];
    int fileLength = 0;
    fileLength = readFileToArray(fileName, numbers);


    tree* numberTree = NULL;
    printf("\n");
    for(int i = 0; i < fileLength; i++){
        printf("Adding: %d\n", numbers[i]);
        numberTree = addNumber(numberTree, numbers[i]);
    }

    printTree(numberTree);
    printf("\n");
    // // testing for input
    // printf("bla\n");
    
    // for (int i = 0; i < fileLength; i++){
    //     // printf("%d  ", *c);
    //     // printf( "*(c + %d) : %d\n", i, *(numbers + i));
    //     printf( "numbers[%d]: %d\n", i, numbers[i]);
    // }

}