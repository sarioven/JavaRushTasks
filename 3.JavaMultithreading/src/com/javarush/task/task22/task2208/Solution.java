package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* 
Формируем WHERE
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("name", null);
        map.put("country", null);
        map.put("city", null);
        map.put("age", null);

        System.out.println(getQuery(map));
    }

    public static String getQuery(Map<String, String> params) {
        StringBuilder result = new StringBuilder();

        for(Map.Entry<String ,String> map : params.entrySet()) {
            if(map.getValue() == null)
                continue;

            result.append(map.getKey());
            result.append(" = ");
            result.append("\'");
            result.append(map.getValue());
            result.append("\'");
            result.append(" and ");
        }

        String string = result.toString();

        if(string.equals(""))
            return "";

        string = string.substring(0, string.lastIndexOf(" and "));

        return string;
    }
}
