package com.javarush.task.task18.task1803;

import java.io.*;
import java.util.*;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileInputStream fStream = new FileInputStream(reader.readLine());

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        int data;

        while(fStream.available() > 0) {
            data = fStream.read();

            if(map.get(data) == null)
                map.put(data, 1);
            else
                map.replace(data, map.get(data) + 1);
        }

        int max = 0;
        String s = "";
        Set<Integer> set = new HashSet<Integer>();

        for(Map.Entry<Integer, Integer> item : map.entrySet()) {
            if(max < item.getValue()) {
                max = item.getValue();
                s = "" + item.getKey();
            }
            else if(max == item.getValue() && !set.contains(item.getKey())) {
                set.add(item.getKey());
                s += " " + item.getKey();
            }

        }

        System.out.print(s);

        fStream.close();
        reader.close();
    }
}
