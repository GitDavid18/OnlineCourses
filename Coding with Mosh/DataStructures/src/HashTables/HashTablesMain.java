package HashTables;

public class HashTablesMain
{
    public static void main(String[] args) {
        var testString = "what a wonderful day at home";

        System.out.println( StringInformation.FindFirstNonRepeatedCharacter(testString));
        System.out.println( StringInformation.FindFirstRepeatedCharacter(testString));
    }
}
