package com.javarush.task.task18.task1827;

import java.io.*;
import java.util.*;
/* 
Прайсы
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String file = reader.readLine();

        reader.close();

        FileInputStream fStreamIn = new FileInputStream(file);
        BufferedReader fReader = new BufferedReader(new InputStreamReader(fStreamIn));

        List<String> list = new ArrayList<>();
        String s;

        int id, max = -1;
        while ((s = fReader.readLine()) != null) {
            list.add(s);

            id = Integer.parseInt(list.get(list.size() - 1).substring(0, 8).trim());

            if(id > max)
                max = id;
        }

        fReader.close();
        fStreamIn.close();

        FileOutputStream fStreamOut = new FileOutputStream(file);
        BufferedWriter fWriter = new BufferedWriter(new OutputStreamWriter(fStreamOut));

        if(args.length > 0) {
            if (args[0].equals("-c")) {
                id = max + 1;

                list.add(fillString("" + id, 8) + fillString(args[1], 30) + fillString(args[2], 8, true) + fillString(args[3], 4));
            }
        }

        for (String item : list) {
            fWriter.write(item);
            fWriter.newLine();
        }

        fWriter.close();
        fStreamOut.close();
    }

    public static String fillString(String s, int size) {
        return fillString(s, size, false);
    }

    public static String fillString(String s, int size, boolean dbl) {
        if(s.length() < size) {
            while (s.length() < size) {
                s += " ";
            }
        } else {
            if (dbl)
                s = s.substring(s.length()-size, s.length());
            else
                s = s.substring(0, size);
        }


        return s;
    }
}
