#include<iostream>

#include <bits/stdc++.h>

using namespace std;


// int = node number, double = priority
typedef pair <int, double> priorityNode;

// Structure of the condition
// for sorting the pair by its
// second elements
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
    priority_queue <priorityNode, vector<priorityNode>, greater<myComp> > min_heap; 

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