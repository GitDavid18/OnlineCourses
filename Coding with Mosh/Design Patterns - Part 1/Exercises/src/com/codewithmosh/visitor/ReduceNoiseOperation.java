package com.codewithmosh.visitor;

public class ReduceNoiseOperation implements IOperation {
    @Override
    public void execute(FactSegment segment) {
        System.out.println("Reduce noise on fact segment");
    }

    @Override
    public void execute(FormatSegment segment) {
        System.out.println("Reduce noise on format segment");
    }
}
