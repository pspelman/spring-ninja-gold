package com.philspelman.springbootninjagold;

import com.philspelman.springbootninjagold.models.Location;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class SpringBootNinjaGoldApplication {
    public static ArrayList<Object> locations = new ArrayList<>();
    public static Location farm = new Location("farm", 10, 20);
    public static Location cave = new Location("cave", 5, 10);
    public static Location house = new Location("house", 2, 5);
    public static Location casino = new Location("casino", 0, 50);




    public static void main(String[] args) {
        SpringApplication.run(SpringBootNinjaGoldApplication.class, args);

        locations.add(0, "farm");
        locations.add(1, "cave");
        locations.add(2, "house");
        locations.add(3, "casino");
    }





}
