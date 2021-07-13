package com.javarush.task.task18.task1822;

import java.io.*;
/* 
Поиск данных внутри файла
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileInputStream fStream = new FileInputStream(reader.readLine());

        reader = new BufferedReader(new InputStreamReader(fStream));

        int id = Integer.parseInt(args[0]);
        String s;
        String[] data;
        while((s = reader.readLine()) != null) {
            data = s.split(" ");

            if(Integer.parseInt(data[0]) == id) {
                System.out.println(s);
                break;
            }
        }

        reader.close();
        fStream.close();
    }
}
