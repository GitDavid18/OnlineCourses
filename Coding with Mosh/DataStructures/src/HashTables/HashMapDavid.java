package HashTables;

import java.util.Arrays;

//Exercise 4
//  Build a hash table from scratch.
//  Use linear probing strategy for handling collisions.
//  Implement the following operations:  -put(int, String) -get(int) -remove(int) -size()
public class HashMapDavid {

    private class Entry{
        private String value;
        private int key;

        Entry(int key, String value){
            this.value = value;
            this.key = key;
        }

        @Override
        public String toString() {
            return "Entry{" +
                    "value='" + value + '\'' +
                    ", key=" + key +
                    '}';
        }
    }
    private Entry[] entries;
    private final int length;
    private  int size;

    public HashMapDavid(int length){
        entries = new Entry[length];
        this.length = length;
        size = 0;
    }

    public void put(int key, String value){
        var entry = GetEntry(key);
        if (entry != null){
            entry.value = value;
            return;
        }

        if(size == entries.length)
            throw new IllegalStateException("Hash Map is full.");

        entry = new Entry(key , value);
        entries[nextAvailable(key)] = entry;
        size++;
    }

    private int nextAvailable(int key) {
        var candidate = GetHash(key);
        while (entries[candidate] != null) {
            candidate++;
            candidate = candidate % length;
        }
        return candidate;
    }

    private Entry GetEntry(int inputKey){
        for(var entry : entries)
           if(inputKey == entry.key)
               return entry;
        return null;
    }

    public String get(int key){
        var entry = GetEntry(key);
        if (entry != null) {
            return entry.value;
        }

        return null;
    }

    public void remove (int key){
        var entry = GetEntry(key);
        entry = null;
        size --;
    }

    public int size(){
        return size;
    }

    private int GetHash(int input){
        return input % length;
    }
}
