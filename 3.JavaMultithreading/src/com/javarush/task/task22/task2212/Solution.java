package com.javarush.task.task22.task2212;

/* 
Проверка номера телефона
*/

public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        if(telNumber == null)
            return false;

        return telNumber.matches("(\\+[0-9]{2})?\\(?[0-9]{3}\\)?[0-9]{3}-?[0-9]{2}-?[0-9]{2}");
    }

    public static void main(String[] args) {
        System.out.println(checkTelNumber("050123-45-67"));
    }
}
