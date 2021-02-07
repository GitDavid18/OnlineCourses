#include<stdio.h>
#include<stdlib.h>

typedef enum suits{clubs, spades, heart, diamond} suits;
typedef enum hand{royalFlush, straightFlush, fours, fullHouse, flush, straight, threes, twoPair, pair, highCard} hand;

typedef struct card{short pips; suits suit;} card;

int result[10] = {0};

card deckOfCards[52] = {0};

// print a card to the screen
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

//print out the current state of the deck
void printDeck(card deck[52]){
    printf("Current deck:\n");
    for (int i = 0; i < 52; i++){
        printCard(deck[i]);
    }
}

//exchange two input cards
void swapCards(card *card1, card *card2){
    card temp = *card1;
    *card1 = *card2;
    *card2 = temp;
}

//randomly change 1000 positions of cards in the deck
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

//Each card in the deck gets a number < 14 (King would be 13) and a suit
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

void runTest(card deck[52]){
    printf("Running Test\n");

    // The first 7 cards are the ones the dealer deals you
    // That would not be the case in a casino but is good enough for our test
    for(int i = 0; i < 7; i++){
        
    }
}

// print the results of our test to the screen
void evaluateTests(int testsRun){
    for (int i = 0; i < 10; i++){
        printf("%2d \t %5.5lf  \t %5.5lf\n", i, result[i], result[i] / testsRun);
    }
}

int main(void){
    int maxTests = 10;

    createDeck();
    shuffleDeck(deckOfCards);
    // printDeck(deckOfCards);

    for (int i = 0; i < maxTests; i++){
        shuffleDeck(deckOfCards);
        runTest(deckOfCards);
    }

    evaluateTests(maxTests);
    //deal 7 cards
    //find poker relevant things
    //evaluate
    return 0;
}