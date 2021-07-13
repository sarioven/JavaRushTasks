package com.javarush.task.task16.task1630;

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        ha:
        for (int i=0; i < 5; i++)
            for (int j=0; j < 5; j++) {
                System.out.println("Interesting...");
                continue ha;
            }
    }

}
