package com.codewithmosh.chainOfResponsibility;

public class QuickBookReader extends FormatReader{
    public QuickBookReader(FormatReader next) {
        super(next);
    }

    @Override
    protected boolean DoReadFormat(String filename) {
        if (filename.endsWith(".qbw")) {
            System.out.println("Reading data from a QuickBooks file.");
            return true;
        }
        return false;
    }
}
