package com.codewithmosh.visitor;

import com.codewithmoshSolutions.visitor.NormalizeFilter;
import com.codewithmoshSolutions.visitor.ReverbFilter;

public class VisitorMain {
    public static void main(String[] args) {
        var file = WavFile.read("NewSong.wav");
        var normalize = new NormalizeOperation();
        file.executeOperationOnFile(normalize);
        file.executeOperationOnFile(new AddReverbOperation());
        file.executeOperationOnFile(new ReduceNoiseOperation());
    }
}
