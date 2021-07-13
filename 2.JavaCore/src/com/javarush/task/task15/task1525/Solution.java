package com.javarush.task.task15.task1525;

import java.util.ArrayList;
import java.util.List;

import java.io.*;

/* 
Файл в статическом блоке
*/

public class Solution {
    public static List<String> lines = new ArrayList<String>();

    static {
        try {
            FileInputStream file = new FileInputStream(Statics.FILE_NAME);

            BufferedReader reader = new BufferedReader(new InputStreamReader(file));

            String text;

            while ((text = reader.readLine()) != null)
                lines.add(text);

            file.close();
            reader.close();
        }
        catch(Exception e) {}
    }

    public static void main(String[] args){
        System.out.println(lines);
    }
}
