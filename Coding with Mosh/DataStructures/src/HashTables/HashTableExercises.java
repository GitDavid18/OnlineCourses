package HashTables;

import java.util.HashMap;
import java.util.HashSet;

public  class HashTableExercises {

    // Exercise 1
    // Find the most repeated element in an array of integers. What is the time complexity of this method? (A variation of this exercise is finding the most repeated word in a sentence. The algorithm is the same. Here we use an array of numbers for simplicity.)
    public static int MostFrequent(int[] input){
        var map= new HashMap<Integer, Integer>();
        for (var item:input) {
            if(map.containsKey(item)==false)
                map.put(item, 0);

            var count = map.get(item);
            count++;
            map.replace(item, count);
        }

        var maxValue = 0;
        var maxKey = 0;
        for (var item: map.entrySet()) {
            if (item.getValue() > maxValue) {
                maxValue = item.getValue();
                maxKey = item.getKey();
            }
        }

        return maxKey;
    }

    //Exercise 2
    // Given an array of integers, count the number of unique pairs of integers that have difference k.
    public static int CountPairsWithDiff(int[] input, int difference){
        var set = new HashSet<Integer>();

        for(var item : input)
            set.add(item);

        var count = 0;
        for(var item: input){
            if(set.contains(item - difference))
                count++;
            if(set.contains(item + difference))
                count++;
            set.remove(item);
        }

        return count;
    }

    // Exercise 3
    // Given an array of integers, return indices of the two numbers such that they add up to a specific target.
    // Assume that each input has exactly one solution, and you may not use the same element twice.
    public static int[] TwoSum(int[] items, int target){
        var set = new HashMap<Integer, Integer>();

        for(var index = 0; index < items.length; index++)  {
            set.put(items[index], index);
            System.out.println("item: " + items[index] + ", index: " + index);
        }

        for (var item : items){
            for(var setItem : set.entrySet()){
                if(setItem.getKey() + item == target)
                    return new int[]{set.get(item), set.get(setItem.getKey())};
            }
            set.remove(item);
        }
        return new int[]{};
    }
}
