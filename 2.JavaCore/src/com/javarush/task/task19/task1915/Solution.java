package com.javarush.task.task19.task1915;

/* 
Дублируем текст
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileOutputStream fWriter = new FileOutputStream(reader.readLine());
        reader.close();

        PrintStream pStream = System.out;

        ByteArrayOutputStream bArrayStream = new ByteArrayOutputStream();
        PrintStream pArrayStream = new PrintStream(bArrayStream);

        System.setOut(pArrayStream);
        testString.printSomething();
        System.setOut(pStream);

        System.out.println(bArrayStream.toString());

        fWriter.write(bArrayStream.toByteArray());
        fWriter.close();
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

