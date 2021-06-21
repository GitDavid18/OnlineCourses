package com.codewithmoshSolutions.visitor;

public class FormatSegment extends Segment {
  @Override
  public void applyFilter(AudioFilter filter) {
    filter.apply(this);
  }
}
