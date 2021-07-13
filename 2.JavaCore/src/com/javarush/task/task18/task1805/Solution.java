package com.javarush.task.task18.task1805;

import java.io.*;
import java.util.*;
/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileInputStream fStream = new FileInputStream(reader.readLine());

        reader.close();

        List<Integer> list = new ArrayList<Integer>();
        int data;

        while(fStream.available() > 0) {
            data = fStream.read();

            if(!list.contains(data))
                list.add(data);
        }

        fStream.close();

        Collections.sort(list);

        for(int i : list)
            System.out.print(i + " ");
    }
}
