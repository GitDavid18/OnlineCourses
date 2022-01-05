package com.codewithmosh.chainOfResponsibility;

public class DataReader {
    public void read(String fileName) {
        FormatReader qbReader = new QuickBookReader(null);
        FormatReader numReader = new NumbersReader(qbReader);
        FormatReader xlsReader = new xlsReader(numReader);

        var result = xlsReader.ReadFormat(fileName);
        if(!result)
            throw new UnsupportedOperationException("File format not supported.");
    }
}
