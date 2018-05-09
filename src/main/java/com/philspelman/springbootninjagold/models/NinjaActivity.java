package com.philspelman.springbootninjagold.models;

import java.util.Date;

public class NinjaActivity {

    private final Date timestamp;
    private final String location;
    private final String outcome;
    private final int money;

    public Date getTimestamp() {
        return timestamp;
    }

    public String getLocation() {

        return location;
    }

    public String getOutcome() {
        return outcome;
    }

    public int getMoney() {
        return money;
    }

    public NinjaActivity() {
        this("none", "none", 0);
    }

    public NinjaActivity(String location, String outcome, int money) {
        this.location = location;
        this.outcome = outcome;
        this.money = money;
        this.timestamp = new Date();
    }

    @Override
    public String toString() {
//        String returnString = "at " + this.timestamp + " ";
        String returnString = "";

        returnString += "Ninja went to the " + this.location + " and " + this.outcome + " " + this.money;
        System.out.println(returnString);

        return returnString;
    }

}
