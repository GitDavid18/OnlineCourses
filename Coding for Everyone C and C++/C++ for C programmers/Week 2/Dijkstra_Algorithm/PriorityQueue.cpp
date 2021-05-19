#include<iostream>
#include <set>
#include <bits/stdc++.h>
#include "priorityNode.cpp"

using namespace std;

//Change this to just int and double pair


template <typename T>
class PriorityQueue{

    private:
    priority_queue <priorityNode, vector<priorityNode>, greater<priorityNode>::value_type > min_heap; 
    

    priorityNode find(priorityNode input){
        priority_queue <priorityNode, vector<priorityNode>, greater<priorityNode.getPriority()> > finder = min_heap;
        while(!finder.empty()){
            priorityNode temp = finder.pop()
            if(temp == input){
                return temp;
            }
        }
        return nullptr;
    }

    public:
    PriorityQueue(){}

    void chgPriority(priorityNode queue_element, double priority){
        priorityNode temp = find (queue_element)
        if(temp != nullptr){
            temp.setPriority(priority);
        }
    }

    void minPriority(){
        min_heap.pop();
        // nodes.erase(nodes.begin());
    }

    void insert(priorityNode queue_element){
        min_heap.push(queue_element)
        // nodes.insert(queue_element);
    }

    bool contains(priorityNode queue_element){ 
        return find(queue_element) == nullptr ? false : true;
        //  return nodes.find(queue_element) == nodes.end() ? false : true;
    }


    //returns a reference to the top element
    priorityNode top (){
        return min_heap.top();
        // return *nodes.begin();
    }

    int size(){
        return min_heap.size();
        // return nodes.size();
    }
};


int main(){
    return 0;
}