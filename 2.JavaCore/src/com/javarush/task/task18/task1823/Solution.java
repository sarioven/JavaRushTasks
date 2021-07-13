package com.javarush.task.task18.task1823;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* 
Нити и байты
*/

public class Solution {
    public static volatile Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName;
        while(!(fileName = reader.readLine()).equals("exit"))
            new ReadThread(fileName);

        reader.close();


        for(Map.Entry<String, Integer> item: resultMap.entrySet()) {
            System.out.println(item.getKey() + " " + item.getValue());
        }
    }

    public static class ReadThread extends Thread {
        private String fileName = "";

        public ReadThread(String fileName){
            this.fileName = fileName;

            start();
        }

        public void run() {
            try {
                FileInputStream fStream = new FileInputStream(fileName);

                Map<Integer, Integer> map = new HashMap<>();

                int data;

                while(fStream.available() > 0) {
                    data = fStream.read();

                    if(!map.containsKey(data)) {
                        map.put(data, 1);
                        continue;
                    }

                    map.replace(data, map.get(data) + 1);
                }

                List<Integer> list = new ArrayList<>(map.values());

                Collections.sort(list);

                for(Map.Entry<Integer, Integer> item: map.entrySet()) {
                    if(item.getValue() == list.get(list.size() - 1)) {
                        resultMap.put(fileName, item.getKey());
                        break;
                    }
                }

                fStream.close();
            }
            catch(Exception e) {}
        }
        // implement file reading here - реализуйте чтение из файла тут
    }
}
