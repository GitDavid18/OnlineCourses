package HashTables;

public class HashTablesMain
{
    public static void main(String[] args) {
        var testString = "what a wonderful day at home";

        System.out.println( StringInformation.FindFirstNonRepeatedCharacter(testString));
        System.out.println( StringInformation.FindFirstRepeatedCharacter(testString));

        var values = new int[]{1, 2, 2, 2, 2, 3, 3, 3, 4};
        System.out.println(HashTableExercises.MostFrequent(values));

        values = new int[]{1, 7, 5, 9, 2, 12, 3};
        System.out.println(HashTableExercises.CountPairsWithDiff(values, 2));

        values = new int[]{2, 7, 11, 15};
        var response = HashTableExercises.TwoSum(values, 9);
        for(var item : response)
            System.out.println(item);

    }
}
