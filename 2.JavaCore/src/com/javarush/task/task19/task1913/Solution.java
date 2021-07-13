package com.javarush.task.task19.task1913;

/* 
Выводим только цифры
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream pStream = System.out;

        ByteArrayOutputStream bArrayStream = new ByteArrayOutputStream();
        PrintStream pArrayStream = new PrintStream(bArrayStream);

        System.setOut(pArrayStream);

        testString.printSomething();

        System.setOut(pStream);

        for(char ch : bArrayStream.toString().toCharArray()) {
            if(Character.isDigit(ch))
                System.out.print(ch);
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's 1 a 23 text 4 f5-6or7 tes8ting");
        }
    }
}
