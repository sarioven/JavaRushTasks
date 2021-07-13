package com.javarush.task.task19.task1911;

/* 
Ридер обертка
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream pStream = System.out;

        ByteArrayOutputStream bArrayStream = new ByteArrayOutputStream();
        PrintStream pStreamArray = new PrintStream(bArrayStream);

        System.setOut(pStreamArray);

        testString.printSomething();

        System.setOut(pStream);

        System.out.println(bArrayStream.toString().toUpperCase());
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
