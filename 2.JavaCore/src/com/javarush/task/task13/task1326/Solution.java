package com.javarush.task.task13.task1326;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
/* 
Сортировка четных чисел из файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream file = new FileInputStream((new BufferedReader(new InputStreamReader(System.in))).readLine());

        BufferedReader reader = new  BufferedReader(new InputStreamReader(file));

        String s;
        int digit;

        ArrayList<Integer> list = new ArrayList<Integer>();

        while((s = reader.readLine()) != null) {
            if((digit = Integer.parseInt(s)) % 2 == 0)
                list.add(digit);
        }

        Collections.sort(list);

        for(Integer i : list)
            System.out.println(i);

        file.close();
        reader.close();
    }
}
