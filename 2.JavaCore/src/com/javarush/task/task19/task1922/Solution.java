package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileReader fReader = new FileReader(reader.readLine());

        reader.close();

        String buffer = "";
        int counter = 0;

        BufferedReader fBReader = new BufferedReader(fReader);

        while((buffer = fBReader.readLine()) != null) {
            for(String ss : buffer.split(" ")) {
                if(words.contains(ss))
                    counter++;

                if(counter > 2)
                    break;
            }

            if(counter == 2)
                System.out.println(buffer);

            counter = 0;
        }

        // buffer += (char)fReader.read();

        fReader.close();
        fBReader.close();

        /*for(String s : buffer.split("\r\n")) {
            for(String ss : words) {
                if(list.contains(ss))
                    counter++;

                if(counter > 2)
                    break;
            }

            if(counter == 2)
                System.out.print(s);

            counter = 0;
        }*/
    }
}
