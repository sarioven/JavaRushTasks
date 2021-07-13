package com.javarush.task.task15.task1522;

import java.io.*;
/* 
Закрепляем паттерн Singleton
*/

public class Solution {
    public static void main(String[] args) {

    }

    static {
        readKeyFromConsoleAndInitPlanet();
    }

    public static Planet thePlanet;

    //add static block here - добавьте статический блок тут

    public static void readKeyFromConsoleAndInitPlanet() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            String s = reader.readLine();

            if(s.equals(Planet.SUN))
                thePlanet = Sun.getInstance();
            else if(s.equals(Planet.MOON))
                thePlanet = Moon.getInstance();
            else if(s.equals(Planet.EARTH))
                thePlanet = Earth.getInstance();
            else
                thePlanet = null;

        }
        catch(Exception e) {}


    }
}
