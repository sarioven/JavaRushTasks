package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class Solution {
    public static void main(String[] args) throws Exception {
        FileReader fReader = new FileReader(args[0]);
        FileWriter fWriter = new FileWriter(args[1]);

        BufferedReader reader = new BufferedReader(fReader);

        String data = "";
        while ((data = reader.readLine()) != null) {
            for (String s : data.split(" "))
                for (char ch : s.toCharArray()) {
                    if (Character.isDigit(ch)) {
                        fWriter.write(s + " ");
                        break;
                    }
                }
        }

        reader.close();
        fReader.close();
        fWriter.close();
    }
}
