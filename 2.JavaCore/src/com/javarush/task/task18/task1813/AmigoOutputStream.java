package com.javarush.task.task18.task1813;

import java.io.*;

/* 
AmigoOutputStream
*/

public class AmigoOutputStream extends FileOutputStream {
    public static String fileName = "C:/tmp/result.txt";
    public FileOutputStream fStream;

    public static void main(String[] args) throws FileNotFoundException {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }

    public AmigoOutputStream(FileOutputStream file) throws FileNotFoundException {
        super(file.toString());
        this.fStream = file;
    }

    public void flush() throws IOException {
        fStream.flush();
    }

    public void write(int b) throws IOException {
        fStream.write(b);
    }

    public void write(byte[] b) throws IOException {
        fStream.write(b);
    }

    public void write(byte[] b, int off, int len) throws IOException {
        fStream.write(b, off, len);
    }

    public void close() throws IOException {
        fStream.flush();

        fStream.write("JavaRush © All rights reserved.".getBytes());

        fStream.close();
    }

}
