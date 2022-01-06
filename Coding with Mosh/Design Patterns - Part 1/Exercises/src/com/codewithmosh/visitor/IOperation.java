package com.codewithmosh.visitor;

public interface IOperation {
    public void execute(FactSegment segment);
    public void execute(FormatSegment segment);
}
