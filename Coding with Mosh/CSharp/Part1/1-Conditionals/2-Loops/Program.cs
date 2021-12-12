public class LoopClass
{
    public static void Main(string[] args)
    {
        //Excercise 1
        DividerThree();
        //Excercise 2
        SumInput();
        //Excercise 3
        FactorialCalculation();
        //Excercise 4
        GuessingGame();
        //Excercise 5
        MaxFromInput();

    }

    /// <summary>
    ///1- Write a program to count how many numbers between 1 and 100 are divisible by 3 with no remainder. Display the count on the console.
    /// </summary>
    public static void DividerThree()
    {
        var result = 0;

        for(int i = 1; i < 100; i++)
        {
            if ( i % 3 == 0)
                result++;
        }

        Console.WriteLine($"Amount of numbers divided by 3 from 1 to 100: {result}");
    }

    /// <summary>
    ///2 - Write a program and continuously ask the user to enter a number or "ok" to exit. Calculate the sum of all the previously entered numbers and display it on the console.
    /// </summary>
    public static void SumInput()
    {
        var sum = 0;
        while (true)
        {
            Console.WriteLine("Enter a number:");
            var input = Console.ReadLine();
            if (input == "ok")
            {
                Console.WriteLine($"The sum is: {sum}");
                break;
            }
            else
            {
                sum += int.Parse(input);
            }
        }
    }

    /// <summary>
    ///3- Write a program and ask the user to enter a number. Compute the factorial of the number and print it on the console. For example, if the user enters 5, the program should calculate 5 x 4 x 3 x 2 x 1 and display it as 5! = 120.
    /// </summary>
    public static void FactorialCalculation()
    {
        Console.WriteLine("Enter a number:");
        var startPoint = int.Parse(Console.ReadLine());
        Console.WriteLine($"{startPoint}! = {Factorial(startPoint)}");
    }

    private static int Factorial (int input)
    {
        if (input > 1)
            return input * Factorial(input - 1);
        else 
            return 1;
    }

    /// <summary>
    ///4- Write a program that picks a random number between 1 and 10. Give the user 4 chances to guess the number. If the user guesses the number, display “You won"; otherwise, display “You lost". (To make sure the program is behaving correctly, you can display the secret number on the console first.)
    /// </summary>
    public static void GuessingGame()
    {
        var rand = new Random();
        var guessMe = rand.Next(1, 10);
        var maxTries = 4;


        for (int i = 0; i < maxTries; i++)
        {
            Console.WriteLine("Guess the number between 1 and 10");
            var input = int.Parse(Console.ReadLine());
            if (input == guessMe)
            { Console.WriteLine("Congrats! That was right!");
                break;

            }
            else
            {
                Console.WriteLine($"Wrong. {maxTries - i - 1} tries left");
            }
        }

        Console.WriteLine($"The secrect number was {guessMe}");
    }
   
    /// <summary>
    ///5 - Write a program and ask the user to enter a series of numbers separated by comma. Find the maximum of the numbers and display it on the console. For example, if the user enters “5, 3, 8, 1, 4", the program should display 8.
    /// </summary>
    public static void MaxFromInput()
    {
        Console.WriteLine("Enter a series of numbers separated by ','");
        var input = Console.ReadLine();

        var numbersAsString = input.Split(',');
        var max = int.Parse(numbersAsString[0]);
        foreach (var number in numbersAsString)
        {
            var num = int.Parse(number);
            if (num > max)
                max = num;
        }

        Console.WriteLine($"The max is {max}");
    }
}