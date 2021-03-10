#include<stdio.h>
#include<stdlib.h>
#include <time.h>

typedef enum suits{clubs, spades, heart, diamond} suits;
typedef enum combinations{royalFlush, straightFlush, fours, fullHouse, flush, straight, threes, twoPair, pair, highCard} combinations;

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
void printDeck(card deck[], int size){
    printf("Current deck:\n");
    for (int i = 0; i < size; i++){
        printCard(deck[i]);
    }
}

//exchange two input cards
void swapCards(card *card1, card *card2){
    card temp = *card1;
    *card1 = *card2;
    *card2 = temp;
}

// selection sort
void sortCardsBySuit(card hand[7]){
      int i, j, min_idx; 
  
    // One by one move boundary of unsorted subarray 
    for (i = 0; i < 7 - 1; i++) { 
  
        // Find the minimum element in unsorted array 
        min_idx = i; 
        for (j = i + 1; j < 7; j++) 
            if (hand[j].suit < hand[min_idx].suit) 
                min_idx = j; 
  
        // Swap the found minimum element 
        // with the first element 
        swapCards(&hand[min_idx], &hand[i]); 
    }
   // printDeck(hand, 7);
}

// selection sort
void sortCardsbyNumber(card hand[7]){
    int i, j, min_idx; 
  
    // One by one move boundary of unsorted subarray 
    for (i = 0; i < 7 - 1; i++) { 
  
        // Find the minimum element in unsorted array 
        min_idx = i; 
        for (j = i + 1; j < 7; j++) 
            if (hand[j].pips < hand[min_idx].pips) 
                min_idx = j; 
  
        // Swap the found minimum element 
        // with the first element 
        swapCards(&hand[min_idx], &hand[i]); 
    }

    //printDeck(hand, 7);
}

//randomly change 1000 positions of cards in the deck
void shuffleDeck(card deck[52]){
    int cardSwaps = 1000;

    for(int i = 0; i < cardSwaps; i++ ){
        int card1 = rand() % 52;
        int card2 = rand() % 52;

        // printf("1:%d, 2:%d\n", card1, card2);

        swapCards(&deckOfCards[card1], &deckOfCards[card2]);
    }
    // printf("Deck shuffled. %d cards were swapped.\n", cardSwaps);
}

// Each card in the deck gets a number <= 13 (Ace is 13) and a suit
void createDeck(void){
    for (int i = 0; i < 13; i++){
        for (int j = 0; j < 4; j++){
            deckOfCards[i + j * 13].pips = i;
            deckOfCards[i + j * 13].suit = j;
            // printf("Current card: pip = %d, suit = %d\n", deckOfCards[i + j *13].pips, deckOfCards[i + j *13].suit);
            // printCard(deckOfCards[i + j *13]);
        }
    }
    printf("Deck created.\n");
}

int containsStraight(int numbers[], int length){
    // check the first 9 cards if they are the beginning of a 5 card sequence
    for (int i = 0; i < length - 4; i++){
        if (numbers[i] != 0){
            for(int k = i + 1; k < i + 5; k++){
                if(numbers[k] == 0){
                    // skip to the number that is higher than one that does not exist in our hand
                    i = k + 1;
                    break;
                }

                if(k == i + 4){
                    // we have 5 numbers in a row
                    // printf("\n Found straight\n");
                    return 1;
                }
            }
        } 
    }

    return 0;
}

int containsStraightFlush(card hand[7], int flushColor){
    // sortCardsBySuit(hand);

    int flushPips[13] = {0};
    //printDeck(hand, 7);
    for(int i = 0; i < 7; i++){
        if (hand[i].suit == flushColor){
            flushPips[hand[i].pips] = 1;
            //printDeck(hand, 7);
            //printf("adding pip %d to list, i = %d", hand[i].pips, i);
        }
      //  else{
            //printf("i: %d" , i );
       // }
    }
    //printf("\n------");
    return containsStraight(flushPips, 13);
}

int containsRoyalFlush(card hand[7], int flushColor){
    
    int result = 0;
    int flushPips[13] = {0};

    for(int i = 0; i < 7; i++){
        if (hand[i].suit == flushColor){
            flushPips[hand[i].pips] = 1;
        }
    }

    if(flushPips[12] == 1 && flushPips[11] == 1 && flushPips[10] == 1 && flushPips[9] == 1 && flushPips[8] == 1){
        result = 1;
    }

    return result;
}
// check if 5 consecutive numbers exist in the input array

void runTest(card deck[52]){
  //  printf("Running Test\n");

    // The first 7 cards are the ones the dealer deals you
    // That would not be the case in a casino but is good enough for our test
    int numbers[13] = {0};
    int suits[4] = {0};
    int potComb[10] = {0};

    int flushColor = -1;

    card hand[7] = {0};

    for(int i = 0; i < 7; i++){
        // count numbers and suits in our hand
        numbers[deck[i].pips] += 1;
        suits[deck[i].suit] += 1;
        hand[i] = deck[i];
    }
    
    // Now look for pairs etc
    for(int i = 0; i < 13; i++){
        if(numbers[i] == 4){
            potComb[fours] = 1;
            // printf("FOURS!!\n");
        }
        else if (numbers[i] == 3){
            potComb[threes] = 1;

            if(potComb[pair] == 1){
                potComb[fullHouse] = 1;
            }
        }
        else if (numbers[i] == 2){
            if(potComb[pair] == 1){
                potComb[twoPair] = 1;
            }
            else{
                potComb[pair] = 1;
            }

            if(potComb[threes] == 1){
                potComb[fullHouse] = 1;
            }
        }
    }

    // find straight
    sortCardsbyNumber(hand);
    // printDeck(hand, 7);
    // We need to find out if we have 5 cards in a row in our hand which is impossible if we have four of a kind
    if(potComb[fours] == 0){
        potComb[straight] = containsStraight(numbers, 13);
    }

    for(int i = 0; i < 4; i++){
        // printf("suit[%d] = %d",i, suits[i]);
        if (suits[i] >= 5){
            // printf("Flush!\n");
            potComb[flush] = 1;
            flushColor = i;
        }


    
    // find straigth flush
    if(potComb[straight] == 1  && potComb[flush] == 1){
        // straight and flush must be found
        if(numbers[12] != 0){
            // we need an Ace (card value = 12) for a royal flush
            potComb[royalFlush] = containsRoyalFlush(hand, flushColor);
            // int p = 0;
        }
        else{
            potComb[straightFlush] =  containsStraightFlush(hand, flushColor);
        }

    }

    //find royal flush
    }

    // add our findings to the result array
    for(int i = 0; i <= highCard; i++){
        if (potComb[i] == 1){
            result[i]++;
        //    printf("Found %d!\n", i);
            break;
        }
        if(i == highCard){
           result[highCard]++; 
        //   printf("Found nothing!\n");
        }
    }
}

// print the results of our test to the screen
void evaluateTests(int testsRun){
    double check = 0.0;
    printf("Evaluating\n");
    for (int i = 0; i < 10; i++){
        double percentile = 1.0 * result[i] / testsRun;
        check += percentile;
        printf("%2d \t %5d  \t %5.5lf\n", i, result[i], percentile);
    }
    printf("sum \t %5d  \t %5.5lf\n", testsRun, check);

}

int main(void){

    // srand(time(0));
    time_t t;
    srand((unsigned) time(NULL));
    int maxTests = 1000000;
    
    createDeck();
    printf("Shuffeling deck for first time.\n");
    shuffleDeck(deckOfCards);
    // runTest(deckOfCards);
    printf("Deck shuffled.\n");    
    // printDeck(deckOfCards, 52);
    printf("Running %d tests\n", maxTests);

    for (int i = 0; i <= maxTests; i++){
        if(i % (maxTests /100) == 0 ){
            printf("Running test %2.0lf%% \n", 100.0 * i / maxTests );
        }
        shuffleDeck(deckOfCards);
        runTest(deckOfCards);
    }

   evaluateTests(maxTests);

//================Test suite ==================
    // card testHand[7] = {0};
    // for (int i = 0; i < 5; i++){
    //     printf("i: %d, ", i);
    //     testHand[i].pips = i+5;
    //     testHand[i].suit = clubs;
    // }

    // printDeck(testHand, 7);

    // printf("\nContains straight flush: %d", containsStraightFlush(testHand, clubs));

    return 0;
}


/*Hand	        Combinations	Probabilities
Royal flush	    4324	        0.00003232
Straight flush	37260	        0.00027851
Four of a kind	224848	        0.00168067
Full house	    3473184	        0.02596102
Flush	        4047644	        0.03025494
Straight	    6180020	        0.04619382
Three of a kind	6461620	        0.04829870
Two pair	    31433400	    0.23495536
Pair	        58627800	    0.43822546
high or less    23294460	    0.17411920
Total	        133784560	    1.00000000*/