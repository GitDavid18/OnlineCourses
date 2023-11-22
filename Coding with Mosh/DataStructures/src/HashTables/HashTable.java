package HashTables;

import javax.swing.*;
import java.util.LinkedList;
import java.util.Map;

public class HashTable {

    private Integer length = 10;

    // Collision Detection: Chaining
    private class Entry{
        public int key;
        public String value;

        public Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    public HashTable(){
        Entries = new LinkedList[length];
    }

    private Integer getHash(Integer key){
        return key.hashCode() % length;
    }
    private LinkedList<Entry>[] Entries;

    public void put(int key, String value){
        var index = getHash(key);

        if(Entries[index] == null)
            Entries[index] = new LinkedList<Entry>();

        for (var entry : Entries[index]) {
            if (entry.key == key) {
                entry.value = value;
                return;
            }
        }

        Entries[index].addLast(new Entry(key, value));
    }

    public String get(int key){
        var index = getHash(key);
        if(Entries[index] == null)
            return null;

        for (var entry :Entries[index]){
            if (entry.key == key)
                return entry.value;
        }

        return null;
    }

    public void remove(int key){
        var index = getHash(key);
        if(Entries[index] == null)
            throw new IllegalStateException();

        for (var entry : Entries[index]){
            if (entry.key == key) {
                Entries[index].remove(entry);
                return;
            }
        }

        throw new IllegalStateException();
    }
}
