// The debugger cannot handle symbols that are longer than 255 characters.
// STL frequently creates symbols that are longer than 255 characters.
// When symbols are longer than 255 characters, the warning is disabled.
#pragma warning(disable:4786)
#include "stdafx.h"
#include <queue>

#using <mscorlib.dll>

#if _MSC_VER > 1020 // if VC++ version is > 4.2
  using namespace std; // std c++ libs implemented in std
#endif
using namespace System;

//Define a custom data type.
class Student
{
    public:
    char* chName;
    int nAge;
    Student(): chName(""),nAge(0){}
    Student( char* chNewName, int nNewAge ):chName(chNewName), nAge(nNewAge){}
    };

    //Overload the < operator.
    bool operator< (const Student& structstudent1, const Student &structstudent2)
    {
        return structstudent1.nAge > structstudent2.nAge;
    }
    //Overload the > operator.
    bool operator> (const Student& structstudent1, const Student &structstudent2)
    {
        return structstudent1.nAge < structstudent2.nAge;
    }

    int _tmain()
    {
      //Declare a priority_queue and specify the ORDER as <
      //The priorities will be assigned in the Ascending Order of Age
      priority_queue<Student, vector<Student>,less<vector<Student>::value_type> > pqStudent1;

      //declare a priority_queue and specify the ORDER as >
      //The priorities will be assigned in the Descending Order of Age
      priority_queue<Student, vector<Student>,greater<vector<Student>::value_type> > pqStudent2;

      // Add container elements.
      pqStudent1.push( Student( "Mark", 38 ));
      pqStudent1.push( Student( "Marc", 25 ));
      pqStudent1.push( Student( "Bill", 47 ));
      pqStudent1.push( Student( "Andy", 13 ));
      pqStudent1.push( Student( "Newt", 44 ));

      //Display container elements.
      while ( !pqStudent1.empty())
      {
          cout << pqStudent1.top().chName << endl;
          pqStudent1.pop();
      }
      cout << endl;

      // Add container elements.
      pqStudent2.push( Student( "Mark", 38 ));
      pqStudent2.push( Student( "Marc", 25 ));
      pqStudent2.push( Student( "Bill", 47 ));
      pqStudent2.push( Student( "Andy", 13 ));
      pqStudent2.push( Student( "Newt", 44 ));

      //Display container elements.
      while ( !pqStudent2.empty())
      {
          cout << pqStudent2.top().chName << endl;
          pqStudent2.pop();
      }
      cout << endl;
      return 0;
    }
}