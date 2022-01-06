package com.codewithmosh.visitor;

public class FactSegment extends Segment {
    @Override
    public void applyFilter(IOperation filter) {
        filter.execute(this);
    }
}
