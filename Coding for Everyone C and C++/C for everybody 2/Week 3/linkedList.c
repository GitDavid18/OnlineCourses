#include<stdio.h>
#include<stdlib.h>
#include <time.h>


//====== List begin =======
typedef struct list 
{
    int number;
    struct list *next;
} list;


int is_empty(const list *l){
    return (l == NULL);
}

list* createList(int d){
    list* head = malloc(sizeof(list));
    head -> number = d;
    head -> next = NULL;
    return head;
}

list* addToFront(int d, list* h){
    list* head = createList(d);
    head -> next = h;
    return head;
}

void printList(list *l){
    printf("List content: \n");
    int numPerRow = 0;
    while (l != NULL){
        printf(" %5d ", l -> number);
        l = l -> next;

        if (++numPerRow == 5){
            printf("\n");
            numPerRow = 0;
        }
    }
    printf("\n");
}

//====== List end =======

//====== Sorting algorithm begin =======

void bubblesort(list *input){
    
}

void swap (list *a, list  *b){
    printf("swapping a: %d & b: %d\n",a->number , b->number);
    int temp = a -> number;
    a -> number = b -> number;
    b -> number = temp;
}

//====== Sorting algorithm end =======

int main(void){
    
    time_t t;
    srand((unsigned) time(NULL));

    list*  myList = createList(rand());
    for(int i = 5; i > 0; i--){
        //int num = rand();
        int num = i;
        // printf("adding to front: %d \n", num);
        myList = addToFront(num ,myList);
    }
    printList(myList);
    swap(myList -> next, myList -> next -> next);

    printList(myList);
    return 0;
}