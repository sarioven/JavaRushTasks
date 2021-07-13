package com.javarush.task.task19.task1903;

/* 
Адаптация нескольких интерфейсов
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();

    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }
    
    public static void main(String[] args) {
        String test = "67566", code = "76";

        String phone = test;

        while(phone.length() < 10)
            phone = "0" + phone;

        System.out.println("+" + code + "(" + phone.substring(0, 3) + ")" + phone.substring(3, 6) + "-" + phone.substring(6, 8) + "-" + phone.substring(8, 10));
    }

    public static class IncomeDataAdapter implements Customer, Contact {
        private IncomeData data;
        
        public IncomeDataAdapter(IncomeData data) {
            this.data = data;
        }
        
        public String getCompanyName() {
            return data.getCompany();
        }
        
        public String getCountryName() {
            return countries.get(data.getCountryCode());
        }
        
        public String getName() {
            return data.getContactLastName() + ", " + data.getContactFirstName();
        }
        
        public String getPhoneNumber() {
            String phone = "" + data.getPhoneNumber();
            
            while(phone.length() < 10)
                phone = "0" + phone;
            
            return "+" + data.getCountryPhoneCode() + "(" + phone.substring(0, 3) + ")" + phone.substring(3, 6) + "-" + phone.substring(6, 8) + "-" + phone.substring(8, 10);
        }
    }


    public static interface IncomeData {
        String getCountryCode();        //For example: UA

        String getCompany();            //For example: JavaRush Ltd.

        String getContactFirstName();   //For example: Ivan

        String getContactLastName();    //For example: Ivanov

        int getCountryPhoneCode();      //For example: 38

        int getPhoneNumber();           //For example: 501234567
    }

    public static interface Customer {
        String getCompanyName();        //For example: JavaRush Ltd.

        String getCountryName();        //For example: Ukraine
    }

    public static interface Contact {
        String getName();               //For example: Ivanov, Ivan

        String getPhoneNumber();        //For example: +38(050)123-45-67
    }
}