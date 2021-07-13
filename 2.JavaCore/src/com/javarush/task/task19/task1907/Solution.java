package com.javarush.task.task19.task1907;

import java.io.*;
import java.util.*;
/* 
Считаем слово
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileReader fReader = new FileReader(reader.readLine());

        reader.close();

        List<String> list = new ArrayList<>();

        String word = "";
        char data;

        while(fReader.ready()) {
            data = (char)fReader.read();

            if(Character.isLetter(data)) {
                word += data;
            }
            else {
                if(!word.equals(""))
                    list.add(word);

                word = "";
            }
        }

        fReader.close();

        int counter = 0;
        for(String s : list) {
            if(s.equals("world"))
                counter++;
        }

        System.out.println(counter);
    }
}
