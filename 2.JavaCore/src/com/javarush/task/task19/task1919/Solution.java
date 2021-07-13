package com.javarush.task.task19.task1919;

import java.io.*;
import java.util.*;
/* 
Считаем зарплаты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        FileReader fReader = new FileReader(args[0]);

        String data = "";

        while(fReader.ready())
            data += (char)fReader.read();

        fReader.close();

        List<String> list = new ArrayList<>();
        Map<String, Double> map = new HashMap<>();

        String[] buffer;

        for(String s : data.split("\n")) {
            buffer = s.split(" ");

            if(!map.containsKey(buffer[0])) {
                list.add(buffer[0]);
                map.put(buffer[0], Double.parseDouble(buffer[1]));
                continue;
            }

            map.replace(buffer[0], map.get(buffer[0]) + Double.parseDouble(buffer[1]));
        }

        Collections.sort(list);

        for(String s : list)
            System.out.println(s + " " + map.get(s));
    }
}
