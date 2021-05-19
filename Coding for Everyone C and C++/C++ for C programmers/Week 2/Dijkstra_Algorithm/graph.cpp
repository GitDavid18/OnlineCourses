#include <iostream>
#include "Matrix2D.cpp"
#include <vector>

using namespace std;

class Graph
{
    Matrix2D<double> connectivity;
    vector<double> nodeValues;
    unsigned const int numNodes;
    unsigned int numEdges;

public:
    Graph(unsigned int numberOfNodes):  connectivity(numberOfNodes, numberOfNodes), numNodes(numberOfNodes)
    {
        connectivity(0,0) = 0.0;
        numEdges = 0;
    }

    int nodes(){
        return numNodes;
    }

    int edges(){
        return numEdges;
    }

    bool adjacent(int nodeA, int nodeB){
        return connectivity(nodeA, nodeB) == 0.0 ? false : true;
    }

    void neighbors (int node){
        cout << "Neighbors of " << node << " are: ";
        for (int i = 0; i < numNodes; i++){
            if (i != node && connectivity(node, i ) != 0.0 ){
                cout << i << ", ";
            }
        }

        cout << endl;
    }

    void add (int nodeA, int nodeB, double value){
        connectivity(nodeA, nodeB) = value;
        connectivity(nodeB, nodeA) = value;
        numEdges++;
    }

    void remove (int nodeA, int nodeB){
        connectivity(nodeA, nodeB) = 0.0;
        connectivity(nodeB, nodeA) = 0.0;
        numEdges--;
    }

    double get_node_value(int nodeA){
        return nodeValues[nodeA];
    }

    void set_node_value(int nodeA, double value){
        nodeValues[nodeA] = value;
    }

    int get_edge_value(int nodeA, int nodeB){
        return connectivity(nodeA, nodeB);
    }

    void set_edge_value(int nodeA, int nodeB, double value){
        connectivity(nodeA, nodeB) = value;
    }
    
    void print(){
        cout << "Graph has " << numNodes << " nodes and " << numEdges << " edges:" << endl;
        connectivity.print();
    }
};

//for testing purposes
// int main(){
//     int nodes = 5;
//     Graph web(nodes);
//     web.add(1,2,5);
//     web.add(0,4,12);
//     web.print();
//     cout << "Node 0 and 4 are adjacent: " << web.adjacent(0,4) << endl;
//     cout << "Node 1 and 2 are adjacent: " << web.adjacent(1,2) << endl;
//     cout << "Node 0 and 2 are adjacent: " << web.adjacent(0,2) << endl;
//     web.neighbors(4);
//     return 0;
// }