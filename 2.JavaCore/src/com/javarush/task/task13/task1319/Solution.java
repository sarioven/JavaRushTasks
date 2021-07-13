package com.javarush.task.task13.task1319;

/* 
Писатель в файл с консоли
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileOutputStream file = new FileOutputStream(new File(reader.readLine()));

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(file));

        String text;

        while (true) {
            text = reader.readLine();

            writer.write(text);
            writer.newLine();

            if(text.equals("exit"))
                break;
        }

        writer.close();
        file.close();
        reader.close();
    }
}
