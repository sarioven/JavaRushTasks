package com.javarush.task.task18.task1826;

import java.io.*;
import java.util.*;
/* 
Шифровка
*/

import java.io.FileInputStream;

public class Solution {
    public static void main(String[] args) throws Exception {

        if (!args[0].equals("-e") && !args[0].equals("-d"))
            return;

        FileInputStream fStream1 = new FileInputStream(args[1]);
        FileOutputStream fStream2 = new FileOutputStream(args[2]);

        if(fStream1.available() > 0) {
            byte[] data = new byte[fStream1.available()];
            fStream1.read(data);

            byte buffer;

            for(int i=0; i < data.length/2; i++) {
                buffer = data[i];
                data[i] = data[data.length-1-i];
                data[data.length-1-i] = buffer;
            }

            fStream2.write(data);
        }

        /*if (fStream1.available() > 0) {
            if (args[0].equals("-e")) {
                byte[] buffer = new byte[fStream1.available()];
                fStream1.read(buffer);

                String newData = "";

                List<Byte> list = new ArrayList<>();

                Map<Byte, String> map = new HashMap<>();

                for (int i = 0; i < buffer.length; i++) {

                    if (!map.containsKey(buffer[i])) {
                        map.put(buffer[i], getSipher(map.size() + 1));
                        list.add(buffer[i]);
                    }

                    newData += map.get(buffer[i]) + " ";
                }

                byte[] header = new byte[list.size()];

                for (int i = 0; i < list.size(); i++)
                    header[i] = list.get(i);

                fStream2.write(header);
                fStream2.write("1".getBytes());
                fStream2.write("1".getBytes());
                fStream2.write("h".getBytes());
                fStream2.write(newData.getBytes());
            } else {
                String[] s = new BufferedReader(new InputStreamReader(fStream1)).readLine().split("11h");
                String[] dataS = s[1].split(" ");

                byte[] header = s[0].getBytes(), data = new byte[dataS.length];

                Map<String, Byte> map = new HashMap<>();

                for(int i=0; i < header.length; i++)
                        map.put(getSipher(i + 1), header[i]);

                for(int i=0; i < data.length; i++)
                    data[i] = map.get(dataS[i]);

                fStream2.write(data);
            }
        }*/

        fStream1.close();
        fStream2.close();
    }

    public static String getSipher(int size) {
        String s = "";

        for(int i = 0; i < size; i++)
            s += "|";

        return s;
    }
}
