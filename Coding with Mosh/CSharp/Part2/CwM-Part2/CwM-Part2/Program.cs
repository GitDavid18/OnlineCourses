// See https://aka.ms/new-console-template for more information

using CwM_Part2.Classes;
using CwM_Part2.Inheritance;
using CwM_Part2.Polymorphism;

Console.WriteLine("Hello, World!");

// Classes
var classes = new Classes();
classes.RunStopwatch();
classes.RunStackOverflowPost();

// Inheritance
var stack = new Stack(); 
stack.Push(1); 
stack.Push(2); 
stack.Push(3); 

Console.WriteLine(stack.Pop()); 
Console.WriteLine(stack.Pop()); 
Console.WriteLine(stack.Pop());

// Polymorphism
var oracle = new OracleConnection("oracle");
var sql = new SqlConnection("SQL");

sql.Open();
oracle.Open();

sql.Close();
oracle.Close();