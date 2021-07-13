package com.javarush.task.task18.task1810;

import java.io.*;
/* 
DownloadException
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileInputStream fStream;

        while(true) {
            fStream = new FileInputStream(reader.readLine());

            if(fStream.available() < 1000) {
                fStream.close();
                reader.close();

                throw new DownloadException();
            }
        }
    }

    public static class DownloadException extends Exception {

    }
}
