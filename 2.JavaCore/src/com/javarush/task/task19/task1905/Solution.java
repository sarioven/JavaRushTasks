package com.javarush.task.task19.task1905;

import java.util.*;

/* 
Закрепляем адаптер
*/

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();

    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static void main(String[] args) {

    }

    public static class DataAdapter implements RowItem {
        private Customer customer;
        private Contact contact;

        public DataAdapter(Customer customer, Contact contact) {
            this.customer = customer;
            this.contact = contact;
        }

        public String getCountryCode() {
            String country = "";

            for(Map.Entry<String, String> item : countries.entrySet()) {
                if(item.getValue().equals(customer.getCountryName()))
                    country = item.getKey();
            }

            return country;
        }

        public String getCompany() {
            return customer.getCompanyName();
        }

        public String getContactFirstName() {
            return contact.getName().split(", ")[1];
        }

        public String getContactLastName() {
            return contact.getName().split(", ")[0];
        }

        public String getDialString() {
            char[] numberArray = contact.getPhoneNumber().toCharArray();
            String number = "";

            for(char ch : numberArray) {
                if(ch == '(' || ch == ')' || ch == '-')
                    continue;

                number += ch;
            }

            return "callto://" + number;
        }
    }

    public static interface RowItem {
        String getCountryCode();        //For example: UA

        String getCompany();            //For example: JavaRush Ltd.

        String getContactFirstName();   //For example: Ivan

        String getContactLastName();    //For example: Ivanov

        String getDialString();         //For example: callto://+380501234567
    }

    public static interface Customer {
        String getCompanyName();        //For example: JavaRush Ltd.

        String getCountryName();        //For example: Ukraine
    }

    public static interface Contact {
        String getName();               //For example: Ivanov, Ivan

        String getPhoneNumber();        //For example: +38(050)123-45-67 or +3(805)0123-4567 or +380(50)123-4567 or ...
    }
}