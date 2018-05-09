package com.philspelman.springbootninjagold.models;

public class Location {
    private String name;
    private int maxValue;
    private int minValue;

    public int makeMoney() {
        //this should get a random number between min and max
//        System.out.println("making money!");
        int gold_earned = getRandomBetween(this.minValue, this.maxValue);
        System.out.println("made: " + gold_earned);

        return gold_earned;
    }

    public int makeMoney(int minValue, int maxValue) {
        //this should get a random number between min and max
        int gold_earned = getRandomBetween(minValue, maxValue);
        System.out.println("made: " + gold_earned);

        return gold_earned;
    }

    Location() {
        this("nowhere", 0, 10);
    }

    public Location(String name, int minValue, int maxValue) {
        this.name = name;
        this.minValue = minValue;
        this.maxValue = maxValue;

    }

    private static int getRandomBetween(int min, int max) {
        //should get number between min and max inclusive of both
        // console.log(`min: ${min}, max: ${max}`,);
        return (int) (Math.floor(Math.random() * (max - min)) + min + 1);
    }



}
