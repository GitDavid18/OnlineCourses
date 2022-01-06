package com.codewithmosh.visitor;

public class AddReverbOperation implements IOperation{
    @Override
    public void execute(FactSegment segment) {
        System.out.println("Add reverb to fact segment");
    }

    @Override
    public void execute(FormatSegment segment) {
        System.out.println("Add reverb to format segment");
    }
}
