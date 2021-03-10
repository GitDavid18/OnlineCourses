#include<stdio.h>
#include<stdlib.h>
#include <time.h>


//====== List begin =======
typedef struct list 
{
    int number;
    struct list *next;
    struct list *prev;
} list;


int is_empty(const list *l){
    return (l == NULL);
}

list* createList(int d){
    list* head = malloc(sizeof(list));
    head -> number = d;
    head -> next = NULL;
    head -> prev = NULL;
    return head;
}

list* addToFront(int d, list* h){
    list* head = createList(d);
    head -> next = h;
    h -> prev = head;
    return head;
}

list* addToEnd(int d, list* h){
    list* head = createList(d);
    head -> prev = h;
    h -> next = head;
    return head;
}

void deleteNode(list* h){
    if(h -> next != NULL ){
        h -> next -> prev = h -> prev;
    }

    if (h -> prev != NULL){
        h -> prev -> next = h -> next;
    }

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

void swap (list *a, list  *b){
    int temp = a -> number;
    a -> number = b -> number;
    b -> number = temp;
}

void bubblesort(list *input, int length){
    list* cur = input;
    for (int i = 0; i < length - 1; i++){
        if (cur -> number > cur -> next -> number){
            swap(cur, cur -> next);
        }
        cur = cur -> next;
    }

    if(length > 2){
        bubblesort(input, length - 1);
    }
}

void deleteDoubles(list *input){
    list *cur = input;
    while (cur -> next != NULL){
        if(cur -> number == cur -> next -> number) {
            deleteNode(cur -> next);
        }else{
            cur = cur -> next;
        }
    }
}

//====== Sorting algorithm end =======

int main(void){
    
    time_t t;
    srand((unsigned) time(NULL));
    int listLength= 200;

    list*  myList = createList(rand() % 50);
    for(int i = listLength - 1; i > 0; i--){
        int num = rand() % 50;
        //int num = i;
        myList = addToFront(num ,myList);
    }
    bubblesort(myList, listLength);
    printList(myList);
    deleteDoubles(myList);
    
    printList(myList);
    return 0;
}