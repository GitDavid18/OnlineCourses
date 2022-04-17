
public class WotkingWithFiles
{
    public static void Main(string[] args)
    {
        //Excercise 1
        CountNumberOfWords();
        //Excercise 2
        FindLongestWords();

    }

    //1- Write a program that reads a text file and displays the number of words.
    public static void CountNumberOfWords()
    {
        var fileName = "Text.txt";
        Console.WriteLine($"The amount of words in {fileName} is {GetAllWordsFromFile(fileName).Count}" );
    }

    private static List<string> GetAllWordsFromFile(string fileName)
    {
        var words = new List<string>();
        var lines = File.ReadAllLines(fileName);

        foreach (var line in lines)
        {
            var wordArray = line.Split(' ');
            foreach (var word in wordArray)
            {
                words.Add(RemovePunctuation(word));
            }
        }

        return words;
    }

    private static string RemovePunctuation(string word)
    {
        if (word.Contains('.'))
            word = word.Remove(word.IndexOf('.'));
        if (word.Contains(','))
            word = word.Remove(word.IndexOf(','));
        if (word.Contains(';'))
            word = word.Remove(word.IndexOf(';'));

        return word;
    }

    //2 - Write a program that reads a text file and displays the longest word in the file. 
    public static void FindLongestWords()
    {
        var fileName = "Text.txt";
        Console.WriteLine($"The longest words in {fileName} are: ");
        foreach (var word in GetLongestWords(fileName))
            Console.WriteLine($"{word}");
    }

    private static List<string> GetLongestWords(string fileName)
    {
        var longestWords = new List<string>();
        int length = 0;
        var words = GetAllWordsFromFile(fileName);

        foreach(var word in words)
        {
            if(word.Length > length)
            {
                longestWords = new List<string> { word };
                length = word.Length;
            }
            else if(word.Length == length)
            {
                longestWords.Add(word);
            }
        }

        return longestWords;
    }
}