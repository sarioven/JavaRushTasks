package com.javarush.task.task18.task1812;

import java.io.*;

/* 
Расширяем AmigoOutputStream
*/

import java.io.IOException;

public class QuestionFileOutputStream implements AmigoOutputStream {
    public AmigoOutputStream aStream;

    public QuestionFileOutputStream(AmigoOutputStream amigo) {
            this.aStream = amigo;
    }

    public void flush() throws IOException {
        aStream.flush();
    }

    public void write(int b) throws IOException {
        aStream.write(b);
    }

    public void write(byte[] b) throws IOException {
        aStream.write(b);
    }

    public void write(byte[] b, int off, int len) throws IOException {
        aStream.write(b, off, len);
    }

    public void close() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Вы действительно хотите закрыть поток? Д/Н");
        String s = reader.readLine();

        if(s.equals("Д"))
            aStream.close();
    }
}

