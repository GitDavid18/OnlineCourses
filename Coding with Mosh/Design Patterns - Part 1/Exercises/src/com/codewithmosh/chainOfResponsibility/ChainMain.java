package com.codewithmosh.chainOfResponsibility;

import com.codewithmoshSolutions.chainOfResponsibility.DataReaderFactory;

public class ChainMain {
    public static void main(String [] args) {
        var reader = new DataReader();
        reader.read("data.xls");
        reader.read("data.numbers");
        reader.read("data.qbw");
        reader.read("data.jpg");
    }
}
