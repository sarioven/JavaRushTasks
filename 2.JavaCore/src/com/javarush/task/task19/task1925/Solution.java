package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        FileReader fReader = new FileReader(args[0]);
        FileWriter fWriter = new FileWriter(args[1]);
        BufferedReader reader = new BufferedReader(fReader);

        String buffer, newData = "";
        while((buffer = reader.readLine()) != null) {
            for(String s : buffer.split(" ")) {
                if(s.length() > 6) {
                    newData += s + ",";
                }
            }
        }

        reader.close();
        fReader.close();

        newData = newData.substring(0, newData.length()-1);

        fWriter.write(newData);

        fWriter.close();
    }
}
