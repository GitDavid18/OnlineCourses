package com.codewithmosh.flyweight;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CellContextFactory {
    private Map<Integer, CellContext> cellContexts = new HashMap<Integer, CellContext>();

    public CellContext getCellContext(String fontFamily, int fontSize, boolean isBold){
        var hash = Objects.hash(fontFamily, fontSize, isBold);

        if(!cellContexts.containsKey(hash)){
            cellContexts.put(hash, new CellContext(fontFamily, fontSize, isBold));
        }

        return cellContexts.get(hash);
    }
}
