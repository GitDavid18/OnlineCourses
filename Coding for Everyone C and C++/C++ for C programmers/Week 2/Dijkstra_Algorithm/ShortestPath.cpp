#include <iostream>
#include <time.h>
#include <random>
#include "graph.cpp"
#include "priorityQueueDijkstra.cpp"

using namespace std;

int numNodes = 5;
double minDist = 1.0;
double maxDist = 10.0;
double density = 0.4;
Graph* connections = new Graph(1);
PriorityQueue* costs = new PriorityQueue(1);
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
                 connections -> add(i,j, round(randNum(maxDist, minDist) * 100.0 ) / 100.0);
            }
        }
    }
    
}

//returns the path form start to end if exists
vector<int> path(int start, int end){
    vector<int> shortestPath;
    costs = new PriorityQueue(connections -> nodes);
    int curNode = start;
    for (int i = 0 ; i < connections -> nodes; i++){
        if (curNode != i){
            // u[date the costs 
        }
    }


    return shortestPath;
}


//returns the length of the shortest path from start to end
double path_size(int start, int end){
    path(start, end);
    return connections->get_node_value(end);
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

