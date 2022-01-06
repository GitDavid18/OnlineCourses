package com.codewithmosh.visitor;

public class FormatSegment extends Segment {
    @Override
    public void applyFilter(IOperation filter) {
        filter.execute(this);
    }
}
