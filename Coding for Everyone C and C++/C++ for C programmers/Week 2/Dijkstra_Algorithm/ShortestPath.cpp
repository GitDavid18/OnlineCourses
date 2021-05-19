#include <iostream>
#include "graph.cpp"
#include <time.h>
#include <random>

using namespace std;

int numNodes = 5;
double minDist = 1.0;
double maxDist = 10.0;
double density = 0.4;
Graph* connections = new Graph(1);
// Graph connections();

double randNum(double MAX, double MIN = 0.0){

    double f = (double)rand() / RAND_MAX;
    double ret =  MIN + f * (MAX - MIN);

//    cout << "f: " << f << ", ret: " << ret << "\n";
   return ret;
}

void createRandomGraph(){
    connections = new Graph(numNodes);
    for (int i = 0; i < numNodes; i++){
        for (int j = i + 1; j < numNodes; j++){
            //add a connection with a probability of density
            if(randNum(1.0) <= density){
                // add a new connection rounded to 2 decimal numbers
                 connections -> add(i,j, round(randNum(maxDist, minDist) *100.0 ) / 100.0);
            }
        }
    }
    
}

int main(){
    srand(time(NULL));  
    createRandomGraph();
    cout << "Random Graph created: " << endl;
    cout << "Parameters: Density: " << density << " , Min_Dist: " << minDist << ", Max_Dist: " << maxDist << endl;
    connections -> print();

    for (int i = 0; i < numNodes; i++){
        connections -> neighbors(i);
    }

    return 0;
}

