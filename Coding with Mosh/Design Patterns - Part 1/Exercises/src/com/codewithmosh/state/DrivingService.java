package com.codewithmosh.state;

public class DrivingService implements TravelMode{

    public Object getEta() {
        System.out.println("Calculating ETA (driving)");
        return 1;
    }

    public Object getDirection() {
        System.out.println("Calculating Direction (driving)");
        return 1;
    }
}
