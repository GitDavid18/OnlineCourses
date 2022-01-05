package com.codewithmosh.chainOfResponsibility;

public class NumbersReader extends FormatReader{

    public NumbersReader(FormatReader next) {
        super(next);
    }

    @Override
    protected boolean DoReadFormat(String filename) {
        if (filename.endsWith(".numbers")) {
            System.out.println("Reading data from a Numbers spreadsheet.");
            return true;
        }
        return false;
    }
}
