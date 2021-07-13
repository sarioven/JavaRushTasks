package com.javarush.task.task18.task1821;

import java.io.*;
import java.util.*;
/* 
Встречаемость символов
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        FileInputStream fStream = new FileInputStream(args[0]);

        Map<Integer, Integer> map = new HashMap<>();

        int data;

        while(fStream.available() > 0) {
            data = fStream.read();

            if(!map.containsKey(data)) {
                map.put(data, 1);
                continue;
            }

            map.replace(data, map.get(data)+1);
        }

        fStream.close();

        List<Integer> list = new ArrayList<>(map.keySet());

        Collections.sort(list);

        for(int item : list)
            System.out.println((char)item + " " + map.get(item));
    }
}
