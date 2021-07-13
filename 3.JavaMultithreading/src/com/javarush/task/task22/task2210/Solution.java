package com.javarush.task.task22.task2210;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/* 
StringTokenizer
*/

public class Solution {
    public static void main(String[] args) {
        for(String string : getTokens("menya zovut ivan", "ia"))
        System.out.println(string);
    }

    public static String[] getTokens(String query, String delimiter) {
        StringTokenizer tokens = new StringTokenizer(query, delimiter);

        List<String> result = new ArrayList<>();

        while(tokens.hasMoreTokens()) {
            result.add(tokens.nextToken());
        }

        return result.toArray(new String[]{});
    }
}
