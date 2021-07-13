package com.javarush.task.task22.task2211;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/* 
Смена кодировки
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Charset utf8 = Charset.forName("UTF-8");
        Charset windows1251 = Charset.forName("Windows-1251");

        byte[] buffer = new byte[1000];
        (new FileInputStream(args[0])).read(buffer);
        String s = new String(buffer, windows1251);
        buffer = s.getBytes(utf8);
        (new FileOutputStream(args[0])).write(buffer);
    }
}
