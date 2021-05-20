#include<iostream>
#include <bits/stdc++.h>

using namespace std;


// int = node number, double = priority
typedef pair <int, double> priorityNode;

// Structure of the condition for sorting the pair by its second elements
struct myComp {
    constexpr bool operator()(
        pair<int, double> const& a,
        pair<int, double> const& b)
        const noexcept
    {
        return a.second < b.second;
    }
};

class PriorityQueue{

    private:
    priority_queue <priorityNode, vector<priorityNode>, myComp > min_heap;

    public:
    PriorityQueue(){}

    void chgPriority(priorityNode queue_element, double priority){
        priority_queue <priorityNode, vector<priorityNode>, myComp > elements = min_heap;
        while(!elements.empty()){
            priorityNode temp = elements.top();

            if(temp.first == queue_element.first && temp.second == queue_element.second){
                temp.second = priority;
            }
            elements.pop();
        }
    }

    void minPriority(){
        min_heap.pop();
        // nodes.erase(nodes.begin());
    }

    void insert(priorityNode queue_element){
        min_heap.push(queue_element);
        // nodes.insert(queue_element);
    }

    bool contains(priorityNode queue_element){ 
        priority_queue <priorityNode, vector<priorityNode>, myComp > elements = min_heap;
        while(!elements.empty()){
            priorityNode temp = elements.top();

            if(temp.first == queue_element.first && temp.second == queue_element.second){
                return true;
            }

            elements.pop();
        }
        return false;
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