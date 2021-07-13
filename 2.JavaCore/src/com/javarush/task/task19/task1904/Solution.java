package com.javarush.task.task19.task1904;

import java.util.*;
import java.text.*;
/* 
И еще один адаптер
*/

import java.io.IOException;

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner {
        private final Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        public Person read() throws IOException {
            String[] data = fileScanner.nextLine().split(" ");

            Person person = null;

            try {
                person = new Person(data[1], data[2], data[0], new SimpleDateFormat("dd MM yyyy").parse(data[3] + " " + data[4] + " " + data[5]));
            }
            catch(Exception e) {}

            return person;
        }

        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
