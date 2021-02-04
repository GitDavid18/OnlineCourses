#include<stdio.h>
#include<stdlib.h>

typedef enum suits{clubs, spades, heart, diamond} suits;

typedef struct card{short pips; suits suit;} card;

card deckOfCards[52] = {0};

void printCard(card input){
    printf("%d of ", input.pips);

    switch (input.suit){
        case clubs: printf("clubs");break;
        case spades: printf("spades");break;
        case heart: printf("heart");break;
        case diamond: printf("diamond");break;
        default: printf("Unknown suit");break;
    }
    printf("\n");
}

void printDeck(card deck[52]){
    printf("Current deck:\n");
    for (int i = 0; i < 52; i++){
        printCard(deck[i]);
    }
}

void swapCards(card *card1, card *card2){
    // printf("Swapping: ");
    // printCard(*card1);
    // printf(" and ");
    // printCard(*card2);

    card temp = *card1;
    // printf("Temp:");
    // printCard(temp);

    *card1 = *card2;
    // printf("card1:");
    // printCard(*card1);


    *card2 = temp;
}

void shuffleDeck(card deck[52]){
    srand(time(0));
    int cardSwaps = 1000;

    for(int i = 0; i < cardSwaps; i++ ){
        int card1 = rand() % 52;
        int card2 = rand() % 52;

        // printf("1:%d, 2:%d\n", card1, card2);

        swapCards(&deckOfCards[card1], &deckOfCards[card2]);
    }
    printf("Deck shuffled. %d cards were swapped.\n", cardSwaps);
}

void createDeck(void){
    for (int i = 1; i < 14; i++){
        for (int j = 0; j < 4; j++){
            deckOfCards[i + j * 13].pips = i;
            deckOfCards[i + j * 13].suit = j;
            // printf("Current card: pip = %d, suit = %d\n", deckOfCards[i + j *13].pips, deckOfCards[i + j *13].suit);
            // printCard(deckOfCards[i + j *13]);
        }
    }
    printf("Deck created.\n");
}

int main(void){
    createDeck();
    shuffleDeck(deckOfCards);
    // printDeck(deckOfCards);
    //deal 7 cards
    //find poker relevant things
    return 0;
}