package com.codewithmosh.chainOfResponsibility;

public abstract class FormatReader {
    private FormatReader _next;

    public FormatReader(FormatReader next){
        _next = next;
    }

    public boolean ReadFormat(String filename){
        if(DoReadFormat(filename))
            return true;
        if(_next != null)
            return _next.ReadFormat(filename);

        return false;
    }

    protected abstract boolean DoReadFormat(String filename);
}
