package HashTables;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class StringInformation {
    public static char FindFirstNonRepeatedCharacter(String input){
        var map = new HashMap<Character, Boolean>();
        var chars = input.toCharArray();
        for (var c : chars) {
            if(map.containsKey(c) == false)
                map.put(c, false);
            else{
                map.replace(c, true);
            }
        }

        for(var c : chars){
            if (map.get(c) == false)
                return c;
        }

        return 0;
    }

    public static char FindFirstRepeatedCharacter(String input){
        var chars = new HashSet<Character>();
        for (var c : input.toCharArray()) {
            if(chars.contains(c))
                return c;
            else
                chars.add(c);

        }

        return Character.MIN_VALUE;
    }
}
