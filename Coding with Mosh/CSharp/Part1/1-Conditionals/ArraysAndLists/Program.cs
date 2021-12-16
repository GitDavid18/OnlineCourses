//Note: For any of these exercises, ignore input validation unless otherwise directed. Assume the user enters values in the format that the program expects.




public class ArraysAndLists
{
    public static void Main(string[] args)
    {
        //Excercise 1
        FacebookSimulator();
        //Excercise 2
        ReverseName();
        //Excercise 3
        FiveSortedNumbers();
        //Excercise 4
        UniqueNumbers();
        //Excercise 5
        ThreeSmallest();
    }

    #region Excercise1
    /// <summary>
    ///1- When you post a message on Facebook, depending on the number of people who like your post, Facebook displays different information.

    ///    If no one likes your post, it doesn't display anything.
    ///    If only one person likes your post, it displays: [Friend's Name] likes your post.
    ///    If two people like your post, it displays: [Friend 1] and[Friend 2] like your post.
    ///    If more than two people like your post, it displays: [Friend 1], [Friend 2] and[Number of Other People] others like your post.

    ///Write a program and continuously ask the user to enter different names, until the user presses Enter (without supplying a name). Depending on the number of names provided, display a message based on the above pattern.
    /// </summary>
    public static void FacebookSimulator()
    {
        Console.WriteLine("Enter your post:");
        var post = Console.ReadLine();

        var likes = new List<string>();
        while (WasLiked(likes))
        {
            CheckLikes(likes);
        }

        Console.WriteLine("Program terminated");
        Console.WriteLine($"Your post: {post}");
        CheckLikes(likes);
    }

    private static bool WasLiked(List<string> likes)
    {
        Console.WriteLine("What friend liked you post?");
        var input = Console.ReadLine();

        if (string.IsNullOrWhiteSpace(input))
            return false;

        likes.Add(input);
        return true;
    } 

    private static void CheckLikes(List<string> likes)
    {
        if (likes.Count == 0)
            Console.WriteLine("");
        if (likes.Count == 1)
            Console.WriteLine($"{likes.First()} likes your post");
        if(likes.Count == 2)
            Console.WriteLine($"{likes[0]} and {likes [1]} like your post");
        if(likes.Count > 2)
            Console.WriteLine($"{likes[0]}, {likes[1]} and {likes.Count - 2} others like your post");

    }
    #endregion Excercise1

    #region Excercise2
    //2- Write a program and ask the user to enter their name. Use an array to reverse the name and then store the result in a new string. Display the reversed name on the console.
    public static void ReverseName()
    {
        Console.WriteLine("Enter your name:");
        var input = Console.ReadLine();
        string reverse = "";

        for (int i = input.Length-1; i >= 0; i--)
        {
            reverse += input[i];
        }

        Console.WriteLine("Your name in reverse = " + reverse);
    }


    #endregion Excercise2

    #region Excercise3
    /// <summary>
    ///3- Write a program and ask the user to enter 5 numbers. If a number has been previously entered, display an error message and ask the user to re-try. Once the user successfully enters 5 unique numbers, sort them and display the result on the console.
    /// </summary>
    public static void FiveSortedNumbers()
    {
        var numbers = new List<int>();
        var maxNumbers = 5;
        for (int i = 0; i < maxNumbers;)
        {
            Console.WriteLine("Please enter a number that has not been used yet");
            var input = int.Parse(Console.ReadLine());
            if (numbers.Contains(input))
            {
                Console.WriteLine("Number already in the list! Try again.");
                continue;
            }
            else
            {
                numbers.Add(input);
                i++;
            }
        }

        numbers.Sort();

        var output = "";
        for (int i = 0;i < numbers.Count; i++)
        {
            output += numbers[i];
            if (i != numbers.Count - 1)
                output += " - ";
        }
        Console.WriteLine(output);
    }
    #endregion

    #region Excercise4
    /// <summary>
    ///4- Write a program and ask the user to continuously enter a number or type "Quit" to exit. The list of numbers may include duplicates. Display the unique numbers that the user has entered.
    /// </summary>
    public static void UniqueNumbers()
    {
        var uniqueNumbers = new List<int>();
        while (true)
        {
            Console.WriteLine("Please enter a number:");
            var input = Console.ReadLine();
            if (input == "Quit")
                break;

            var inputNumber = int.Parse(input);

            if (!uniqueNumbers.Contains(inputNumber))
                uniqueNumbers.Add(inputNumber);
        }

        Console.WriteLine("Unique Numbers entered: ");
        foreach (var input in uniqueNumbers)
            Console.WriteLine(input);
    }
    #endregion

    #region Excercise5
    /// <summary>
    ///5- Write a program and ask the user to supply a list of comma separated numbers (e.g 5, 1, 9, 2, 10). If the list is empty or includes less than 5 numbers, display "Invalid List" and ask the user to re-try; otherwise, display the 3 smallest numbers in the list.
    /// </summary>
    public static void ThreeSmallest()
    {
        List<int> numbers = new List<int>();
        while (true)
        {
            Console.WriteLine("Please enter a list of at least 5 numbers: ");
            var input = Console.ReadLine();

            var splitInput = input.Split(',');
            if (splitInput.Length <= 4)
                Console.WriteLine("Invalid amount of numbers. Please re-try.");
            else
            {
                foreach (string x in splitInput)
                    numbers.Add(int.Parse(x));
                break;
            }
        }

        Console.WriteLine("The 3 smallest numbers are: ");
        for(int i = 0; i < 3; i++)
        {
            Console.WriteLine($"{numbers.Min()}");
            numbers.Remove(numbers.Min());
        }
    }
    #endregion
}