package com.javarush.task.task19.task1912;

/* 
Ридер обертка 2
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream pStreamDefault = System.out;

        ByteArrayOutputStream bArrayStream = new ByteArrayOutputStream();
        PrintStream pArrayStream = new PrintStream(bArrayStream);

        System.setOut(pArrayStream);

        testString.printSomething();

        System.setOut(pStreamDefault);

        System.out.println(bArrayStream.toString().replaceAll("te", "??"));
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
