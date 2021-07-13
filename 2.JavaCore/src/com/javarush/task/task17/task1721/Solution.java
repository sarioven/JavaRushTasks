package com.javarush.task.task17.task1721;

import java.util.ArrayList;
import java.util.List;

import java.io.*;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            BufferedReader readerFile = new BufferedReader(new InputStreamReader(new FileInputStream(reader.readLine())));
            BufferedReader readerFile2 = new BufferedReader(new InputStreamReader(new FileInputStream(reader.readLine())));

            String s;

            while((s = readerFile.readLine()) != null)
                allLines.add(s);

            while((s = readerFile2.readLine()) != null)
                forRemoveLines.add(s);

            new Solution().joinData();
        }
        catch(Exception e) {}
    }

    public void joinData() throws CorruptedDataException {
        for(String s : forRemoveLines) {
            if(allLines.contains(s)) {
                allLines.remove(s);
                continue;
            }

            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}
