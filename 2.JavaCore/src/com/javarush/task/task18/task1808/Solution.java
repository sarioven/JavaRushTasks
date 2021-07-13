package com.javarush.task.task18.task1808;

import java.io.*;
/* 
Разделение файла
*/

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileInputStream fStream1 = new FileInputStream(reader.readLine());
        FileOutputStream fStream2 = new FileOutputStream(reader.readLine());
        FileOutputStream fStream3 = new FileOutputStream(reader.readLine());

        byte[] buffer;

        if(fStream1.available() > 0)
            buffer = new byte[fStream1.available()];
        else {
            fStream1.close();
            fStream2.close();
            fStream3.close();

            return;
        }

        int count = fStream1.read(buffer);

        int fCount1 = (count / 2) + (count % 2),
            fCount3 = count / 2;


        fStream2.write(buffer, 0, fCount1);
        fStream3.write(buffer, fCount1, fCount3);

        fStream1.close();
        fStream2.close();
        fStream3.close();
    }
}
