#include <iostream>
#include <time.h>
using namespace :: std;

int generateDiceRoll(int num_Dice, int num_Sides){
    int result = 0;

    for (int i = 0; i < num_Dice; i++){
        result += rand() % num_Sides + 1;
    }
    return result;
}

int main(void){
    int num_dice = 2;
    int num_sides = 6;
    int num_probes = 10000000;
    int results[11] = {0};
    srand(time(NULL));

    for(int run = 0; run < num_probes; run++){
        int cur_result = generateDiceRoll(num_dice, num_sides);
        results[cur_result - 2]++;
    }

    for(int printRun = 0; printRun < 11; printRun ++){
        printf("\n[%d]: \t %8d = %2.4f %%",  printRun + 2, results[printRun], (double) results[printRun] / num_probes);
    }

    return 0;
}