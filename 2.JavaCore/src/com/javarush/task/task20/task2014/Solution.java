package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/
public class Solution implements Serializable {
    public static void main(String[] args) throws Exception {
        FileInputStream fIStream = new FileInputStream("E:/Test.txt");
        FileOutputStream fOStream = new FileOutputStream("E:/Test.txt");

        Solution savedObject = new Solution(4);
        Solution loadObject;

        ObjectOutputStream oOStream = new ObjectOutputStream(fOStream);
        oOStream.writeObject(savedObject);
        oOStream.close();
        fOStream.close();

        ObjectInputStream oIStream = new ObjectInputStream(fIStream);
        loadObject = (Solution) oIStream.readObject();
        oIStream.close();
        fIStream.close();

        System.out.println(savedObject);
        System.out.println(loadObject);
    }

    private transient final String pattern = "dd MMMM yyyy, EEEE";
    private transient Date currentDate;
    private transient int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and the current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
