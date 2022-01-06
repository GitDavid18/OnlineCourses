package com.codewithmosh.visitor;

public class NormalizeOperation implements IOperation{
    @Override
    public void execute(FactSegment segment) {
        System.out.println("Normalize fact segment");
    }

    @Override
    public void execute(FormatSegment segment) {
        System.out.println("Normalize format segment");
    }
}
