//Note: For all these exercises, ignore input validation unless otherwise specified. Assume the user provides input in the format that the program expects.

using System;
using System.Collections.Generic;

public class WotkingWithText
{
    public static void Main(string[] args)
    {
        //Excercise 1
        VerifyConsecutiveNumbers();
        //Excercise 2
        CheckForDuplicates();
        //Excercise 3
        TimeInput();
        //Excercise 4
        PascalCase();
        //Excercise 5
        CountVowels();
    }

    //1- Write a program and ask the user to enter a few numbers separated by a hyphen. Work out if the numbers are consecutive. For example, if the input is "5-6-7-8-9" or "20-19-18-17-16", display a message: "Consecutive"; otherwise, display "Not Consecutive".

    #region excercise1

    public static void VerifyConsecutiveNumbers()
    {
        string[] splitInput = GetSplitNumbers();

        if (IsConsecutive(splitInput))
            Console.WriteLine("Consecutive");
        else
            Console.WriteLine("Not Consecutive");
    }

    private static string[] GetSplitNumbers()
    {
        Console.WriteLine("Insert a number of values sepparated by '-':");
        var input = Console.ReadLine();
        if (string.IsNullOrEmpty(input))
            return null;
        var splitInput = input.Split('-');
        return splitInput;
    }

    private static bool IsConsecutive(string[] splitInput)
    {
        int lastValue = 0;
        var direction = 0;

        for (int i = 0; i < splitInput.Length; i++)
        {
            var currentValue = int.Parse(splitInput[i]);
            Console.WriteLine($"{i}: {splitInput[i]}");

            if (i == 0)
            {
                lastValue = currentValue;
                continue;
            }

            if (i == 1)
                direction = currentValue - lastValue;

            if (lastValue + direction != currentValue || Math.Abs(direction) != 1)
                return false;

            if (i == splitInput.Length - 1)
                return true;

            lastValue = currentValue;
        }

        return false;
    }

    #endregion excercise1

    //2 - Write a program and ask the user to enter a few numbers separated by a hyphen. If the user simply presses Enter, without supplying an input, exit immediately; otherwise, check to see if there are duplicates. If so, display "Duplicate" on the console.

    #region excercise2

    public static void CheckForDuplicates()
    {
        var splitIntput = GetSplitNumbers();
        if (splitIntput == null)
            return;

        var potDuplicates = new List<int>();
        foreach (var input in splitIntput)
        {
            var value = int.Parse(input);
            if (potDuplicates.Contains(value))
            {
                Console.WriteLine($"Duplicate found: {value}");
                return;
            }

            potDuplicates.Add(value);
        }

        Console.WriteLine("No duplicates found");
    }

    #endregion excercise2

    //3- Write a program and ask the user to enter a time value in the 24-hour time format (e.g. 19:00). A valid time should be between 00:00 and 23:59.If the time is valid, display "Ok"; otherwise, display "Invalid Time".If the user doesn't provide any values, consider it as invalid time.

    #region excercise3

    private static void TimeInput()
    {
        Console.WriteLine("Please enter a valid time (24h format)");
        var input = Console.ReadLine();

        if (IsValidTime(input))
            Console.WriteLine("Time ok");
        else
            Console.WriteLine("Invalid time!");
    }

    private static bool IsValidTime(string input)
    {
        if (string.IsNullOrWhiteSpace(input))
            return false;

        var time = input.Split(':');
        if (time.Length != 2)
            return false;

        if (int.TryParse(time[0], out int hour)
         && int.TryParse(time[1], out int minute)
         && hour >= 0
         && hour < 24
         && minute >= 0
         && minute < 59)
            return true;

        return false;
    }

    #endregion excercise3

    //4- Write a program and ask the user to enter a few words separated by a space. Use the words to create a variable name with PascalCase. For example, if the user types: "number of students", display "NumberOfStudents".Make sure that the program is not dependent on the input. So, if the user types "NUMBER OF STUDENTS", the program should still display "NumberOfStudents".

    #region excercise4

    public static void PascalCase()
    {
        Console.WriteLine("Please enter a sentence to convert:");
        var input = Console.ReadLine();

        if (String.IsNullOrWhiteSpace(input))
        {
            Console.WriteLine("Not a valid input");
            return;
        }

        var splitInput = input.Split(" ");
        var output     = "";

        foreach (var s in splitInput)
        {
            output += char.ToUpper(s[0]);
            output += s.ToLower().Substring(1);
        }

        Console.WriteLine($"The Camel case is : {output}");
    }

    #endregion

    //5- Write a program and ask the user to enter an English word. Count the number of vowels (a, e, o, u, i) in the word.So, if the user enters "inadequate", the program should display 6 on the console.
    public static void CountVowels()
    {
        Console.WriteLine("Let me count vowels for you");
        var input = Console.ReadLine();
        var count = 0;
        foreach (var character in input)
            if (character is 'a' or 'e' or 'i' or 'o' or 'u')
                count++;

        Console.WriteLine($"I counted {count} vowels for you.");
    }
}