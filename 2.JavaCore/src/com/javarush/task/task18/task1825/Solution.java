package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.*;
/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> list = new ArrayList<>();

        String data, fileName = null;
        String[] dataArray;
        while (!(data = reader.readLine()).equals("end")) {
            dataArray = data.split(".part");

            if (fileName == null)
                fileName = dataArray[0];

            list.add(Integer.parseInt(dataArray[dataArray.length - 1]));
        }

        reader.close();

        Collections.sort(list);

        FileOutputStream fOutStream = new FileOutputStream(new File(fileName));
        FileInputStream fInStream;

        byte[] buffer;

        for (Integer item : list) {
            fInStream = new FileInputStream(fileName + ".part" + item);

            buffer = new byte[fInStream.available()];

            fInStream.read(buffer);

            fOutStream.write(buffer);

            fInStream.close();
        }

        fOutStream.close();
    }
}
