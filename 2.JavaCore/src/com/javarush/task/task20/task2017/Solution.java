package com.javarush.task.task20.task2017;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.sql.SQLOutput;

/* 
Десериализация
*/
public class Solution {
    public A getOriginalObject(ObjectInputStream objectStream) {
        A result = null;

        try {
            Object obj = objectStream.readObject();

            if(obj instanceof A)
                result = (A)obj;

        } catch(Exception e) {
            System.out.println(e);
            return null;
        }

        return result;
    }

    public class A implements Serializable {
    }

    public class B extends A {
        public B() {
            System.out.println("inside B");
        }
    }

    public static void main(String[] args) {

    }
}
