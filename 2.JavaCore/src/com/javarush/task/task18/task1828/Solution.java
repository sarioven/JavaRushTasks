package com.javarush.task.task18.task1828;

import java.io.*;
import java.util.*;
/*
Прайсы 2
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        if(args.length <= 0)
            return;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String file = reader.readLine();

        reader.close();

        FileInputStream fStreamIn = new FileInputStream(file);
        BufferedReader fReader = new BufferedReader(new InputStreamReader(fStreamIn));

        List<String> list = new ArrayList<>();
        String s;

        while ((s = fReader.readLine()) != null)
            list.add(s);

        fReader.close();
        fStreamIn.close();

        FileOutputStream fStreamOut = new FileOutputStream(file);
        BufferedWriter fWriter = new BufferedWriter(new OutputStreamWriter(fStreamOut));


        int id;
        String item;
        Iterator<String> iter = list.iterator();
        while (iter.hasNext()) {
            item = iter.next();
            id = Integer.parseInt(item.substring(0, 8).trim());

            if (id == Integer.parseInt(args[1])) {
                if (args[0].equals("-u")) {
                    list.set(list.indexOf(item), (fillString("" + id, 8) + fillString(args[2], 30) + fillString(args[3], 8, true) + fillString(args[4], 4)));
                } else if (args[0].equals("-d")) {
                    iter.remove();
                }

                break;
            }
        }

        for (int i = 0; i < list.size(); i++) {
            fWriter.write(list.get(i));

            if (i != list.size() - 1)
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
