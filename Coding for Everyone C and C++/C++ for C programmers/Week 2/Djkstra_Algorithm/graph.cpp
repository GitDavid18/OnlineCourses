#include <iostream>
#include "Matrix2D.cpp"

class Graph
{
    Matrix2D<int> connectivity;
    unsigned int numNodes;
    unsigned int numEdges;

public:
    Graph(unsigned int numberOfNodes):  connectivity(numberOfNodes, numberOfNodes)
    {
        numNodes = numberOfNodes;
        numEdges = 0;
    }

    int nodes(){
        return numNodes;
    }

    int edges(){
        return numEdges;
    }

    bool adjacent(int nodeA, int nodeB){
        return connectivity(nodeA, nodeB) == 0 ? false : true;
    }

    void add (int nodeA, int nodeB, int value){
        connectivity(nodeA, nodeB) = value;
        connectivity(nodeB, nodeA) = value;
        numEdges++;
    }

    void remove (int nodeA, int nodeB){
        connectivity(nodeA, nodeB) = 0;
        connectivity(nodeB, nodeA) = 0;
        numEdges--;
    }

    int get_edge_value(int nodeA, int nodeB){
        return connectivity(nodeA, nodeB);
    }

    void set_edge_value(int nodeA, int nodeB, int value){
        connectivity(nodeA, nodeB) = value;
    }
    
    void print(){
        std::cout << "Graph has " << numNodes << " nodes and " << numEdges << " edges:" << std::endl;
        connectivity.print();
    }
};

int main(){
    int nodes = 5;
    Graph web(nodes);
    web.add(1,2,5);
    web.add(0,4,12);
    web.print();
    return 0;
}