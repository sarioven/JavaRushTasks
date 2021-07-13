package com.javarush.task.task19.task1914;

/* 
Решаем пример
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

        String[] resultS = bArrayStream.toString().split(" ");
        int a = Integer.parseInt(resultS[0]);
        int b = Integer.parseInt(resultS[2]);


        switch(resultS[1]) {
            case "+":
                System.out.println(a + " + " + b + " = " + (a+b));
                break;
            case "-":
                System.out.println(a + " - " + b + " = " + (a-b));
                break;
            case "*":
                System.out.println(a + " * " + b + " = " + (a*b));
                break;
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

