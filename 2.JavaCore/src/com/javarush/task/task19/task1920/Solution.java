package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.FileReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        FileReader fReader = new FileReader(args[0]);

        String data = "";

        while(fReader.ready())
            data += (char)fReader.read();

        fReader.close();
        Map<String, Double> map = new HashMap<>();

        String[] buffer;

        for(String s : data.split("\n")) {
            buffer = s.split(" ");

            if(!map.containsKey(buffer[0])) {
                map.put(buffer[0], Double.parseDouble(buffer[1]));
                continue;
            }

            map.replace(buffer[0], map.get(buffer[0]) + Double.parseDouble(buffer[1]));
        }

        List<Double> listValue = new ArrayList<>(map.values());
        List<String> listKey = new ArrayList<>();

        Collections.sort(listValue);

        for(Map.Entry<String, Double> item : map.entrySet()) {
            if(listValue.get(listValue.size()-1) == (double)item.getValue())
                listKey.add(item.getKey());
        }

        Collections.sort(listKey);

        for(String name : listKey)
            System.out.println(name);
    }
}
