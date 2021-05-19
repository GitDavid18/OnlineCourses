
#include<iostream>
#include <set>
#include <bits/stdc++.h>

template <typename T>
class priorityNode{
    T node;
    double priority;

    public:
    priorityNode(T node, double priority) : node(node), priority(priority){}

    double getPriority(){
        return priority;
    }

    void setPriority(double prio){
        priority = prio;
    }

    T getNode(){
        return node;
    }

    T& operator==(priorityNode nodeA){
        if(nodeA.getPriority() == this.getPriority() && nodeA.getNode() == this.getNode() ){
            return true;
        }
        return false;
    }

    bool operator< (const priorityNode &nodeB)
    {
        return this.priority > nodeB.priority;
    }
    //Overload the > operator.
    bool operator> (const priorityNode &nodeB)
    {
        return this.priority < nodeB.priority;
    }
};