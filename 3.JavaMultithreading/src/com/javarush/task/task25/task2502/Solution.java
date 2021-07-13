package com.javarush.task.task25.task2502;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* 
Машину на СТО не повезем!
*/

public class Solution {
    public static enum Wheel {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }

    public static class Car {
        protected List<Wheel> wheels;

        public Car() {
            wheels = new ArrayList<>();

            String[] data = loadWheelNamesFromDB();
            if(data.length != Wheel.values().length) {
                    throw new IllegalArgumentException();
            }

            for(String string : loadWheelNamesFromDB()) {
                boolean added = false;
                for(Wheel wheel : Wheel.values()) {
                    if(string.equals(wheel.toString())){
                        wheels.add(wheel);
                        added = true;
                        break;
                    }
                }
                if(!added)
                    throw new IllegalArgumentException();
            }
        }

        protected String[] loadWheelNamesFromDB() {
            //this method returns mock data
            return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT"};
        }
    }

    public static void main(String[] args) {
    }
}
