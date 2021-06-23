package com.codewithmosh.state;

public class Travel_Main {
    public static void main(String[] args) {
        TravelMode mode = new WalkingService();
        printMode(mode);

        mode = new BicyclingService();
        printMode(mode);

        mode = new TransitService();
        printMode(mode);

        mode = new DrivingService();
        printMode(mode);

        mode = new TransitService();
        printMode(mode);
    }

    private static void printMode(TravelMode mode){
        System.out.println("Walk direction is: " + mode.getDirection() + " and it's eta is: " + mode.getEta());
    }
}
