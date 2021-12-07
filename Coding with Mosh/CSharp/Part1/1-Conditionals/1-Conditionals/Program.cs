public class MainClass
{
    public static void Main(string[] args)
    {
        IsNumberBtwOneAndTen();

        ShowMax();

        ImageOrientation();

        SpeedCam();
    }

    /// <summary>
    /// 1- Write a program and ask the user to enter a number. The number should be between 1 to 10. If the user enters a valid number, display "Valid" on the console. Otherwise, display "Invalid". (This logic is used a lot in applications where values entered into input boxes need to be validated.)
    /// </summary>
    public static void IsNumberBtwOneAndTen()
    {
        Console.WriteLine("Input a number btw 1 and 10:");
        var number = int.Parse(Console.ReadLine());

        if (number >= 1 && number <= 10)
            Console.WriteLine("Valid");
        else
            Console.WriteLine("Invalid");
    }

    /// <summary>
    /// 2- Write a program which takes two numbers from the console and displays the maximum of the two.
    /// </summary>
    public static void ShowMax()
    {
        Console.WriteLine("First number:");
        var number1 = int.Parse(Console.ReadLine());

        Console.WriteLine("Second number:");
        var number2 = int.Parse(Console.ReadLine());

        Console.WriteLine($"Max is: {Math.Max(number1, number2)}");
    }

    /// <summary>
    /// 3- Write a program and ask the user to enter the width and height of an image. Then tell if the image is landscape or portrait. 
    /// </summary>
    public static void ImageOrientation()
    {

        Console.WriteLine("Width:");
        var number1 = int.Parse(Console.ReadLine());

        Console.WriteLine("Height:");
        var number2 = int.Parse(Console.ReadLine());

        Console.WriteLine($"Orientation: {(number1 > number2 ? "Landscape" : "Portrait")}");
    }

    /// <summary>
    /// 4- Your job is to write a program for a speed camera. For simplicity, ignore the details such as camera, sensors, etc and focus purely on the logic. Write a program that asks the user to enter the speed limit. Once set, the program asks for the speed of a car. If the user enters a value less than the speed limit, program should display Ok on the console. If the value is above the speed limit, the program should calculate the number of demerit points. For every 5km/hr above the speed limit, 1 demerit points should be incurred and displayed on the console. If the number of demerit points is above 12, the program should display License Suspended. 
    /// </summary>
    public static void SpeedCam()
    {
        Console.WriteLine("What is the speed limit?");
        var speedLimit = int.Parse(Console.ReadLine());
        int points = 0;
           
        while (true)
        {
            Console.WriteLine("How fast are you going?");
            var speed = int.Parse(Console.ReadLine());
            if (speed == -1)
                break;
            else if (speed > speedLimit)
            {
                Console.WriteLine("The speed cam caught you!");
                points += (speed - speedLimit) / 5;
                Console.WriteLine($"You currently have {points} points");
                if (points >= 12)
                {
                    Console.WriteLine("License suspended");
                    break;
                }
            }
            else
                Console.WriteLine("The speed cam let you past..");
        }
    }
}