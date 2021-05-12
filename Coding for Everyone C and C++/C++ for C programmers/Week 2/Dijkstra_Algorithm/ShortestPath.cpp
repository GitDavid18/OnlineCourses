#include <iostream>
#include "graph.cpp"
#include <time.h>

using namespace std;

int numNodes = 5;
double minDist = 1.0;
double maxDist = 10.0;
double density = 0.4;
Graph* connections = new Graph(1);
// Graph connections();

void createRandomGraph(){
    connections = new Graph(numNodes);
    connections -> add(1,2,3);
    connections -> print();
}

int main(){
    srand(time(NULL));  
    connections -> print();
    createRandomGraph();
    connections -> print();
    return 0;
}

