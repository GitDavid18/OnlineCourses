#include <iostream>

using namespace std;

typedef enum days{MON, TUE, WED, THU, FRI, SAT, SUN} days;

inline days operator++ (days d){
    return static_cast<days>((static_cast<int>(d) + 1) % 7);
}

ostream& operator<<
(ostream& out, const days& d){
    switch(d){
        case MON: out << "MON"; break;
        case TUE: out << "TUE"; break;
        case WED: out << "WED"; break;
        case THU: out << "THU"; break;
        case FRI: out << "FRI"; break;
        case SAT: out << "SAT"; break;
        case SUN: out << "SUN"; break;
    }
    return out;
}

int main(){

    days myDay = MON;
    
    cout << "My day is: " << myDay << endl;
    cout << "The day after my Day is: " << ++myDay << endl;
    cout << "The day after my Day is: " << ++++myDay << endl;
    cout << "The day after my Day is: " << ++++++myDay << endl;

    return 0;
}