package com.javarush.task.task19.task1927;

/* 
Контекстная реклама
*/

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream pStream = System.out;

        ByteArrayOutputStream bArray = new ByteArrayOutputStream();
        PrintStream pStreamArray = new PrintStream(bArray);

        System.setOut(pStreamArray);
        testString.printSomething();
        System.setOut(pStream);

        String[] lines = bArray.toString().split(System.lineSeparator());

        for(int i=0; i < lines.length; i++) {
            System.out.println(lines[i]);

            if((i+1) % 2 == 0)
                System.out.println("JavaRush - курсы Java онлайн");
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
