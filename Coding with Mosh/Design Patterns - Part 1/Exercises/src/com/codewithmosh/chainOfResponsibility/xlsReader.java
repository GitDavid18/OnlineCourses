package com.codewithmosh.chainOfResponsibility;

public class xlsReader extends FormatReader{

    public xlsReader(FormatReader next) {
        super(next);
    }

    @Override
    protected boolean DoReadFormat(String filename) {
        if(filename.endsWith(".xls")){
            System.out.println("Reading data from an Excel spreadsheet.");
            return true;
        }
        return false;
    }
}
