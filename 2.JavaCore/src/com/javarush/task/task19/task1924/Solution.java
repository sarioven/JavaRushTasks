package com.javarush.task.task19.task1924;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.HashMap;
import java.util.Map;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileReader fReader = new FileReader(reader.readLine());
        reader.close();

        BufferedReader fBReader = new BufferedReader(fReader);

        String buffer = "", newData = "";
        String[] data;
        int number;
        while((buffer = fBReader.readLine()) != null) {
            data = buffer.split(" ");

            for(int i=0; i < data.length; i++) {
                try {
                    number = Integer.parseInt(data[i]);
                    if(map.containsKey(number))
                        newData += map.get(number);
                    else
                        newData += data[i];
                }
                catch(Exception e) {
                    newData += data[i];
                }

                if(i !=  data.length-1)
                    newData += " ";
            }

            newData += "\n";
        }

        System.out.println(newData);

        fBReader.close();
        fReader.close();
    }
}
