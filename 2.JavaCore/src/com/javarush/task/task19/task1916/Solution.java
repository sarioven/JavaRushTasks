package com.javarush.task.task19.task1916;

import java.util.*;
import java.io.*;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        BufferedReader fReader1 = new BufferedReader(new FileReader(reader.readLine()));
        BufferedReader fReader2 = new BufferedReader(new FileReader(reader.readLine()));

        reader.close();

        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        String data;

        while((data = fReader1.readLine()) != null)
            list1.add(data);

        fReader1.close();

        while((data = fReader2.readLine()) != null)
            list2.add(data);

        fReader2.close();

        /*for(String item : list1) {
            if(list2.contains(item)) {
                lines.add(new LineItem(Type.SAME, item));
                list2.remove(item);
            }
            else
                lines.add(new LineItem(Type.REMOVED, item));
        }

        for(String item : list2)
            lines.add(new LineItem(Type.ADDED, item));*/

        for(int i=0; i < list1.size(); i++) {
            if (i > list2.size() - 1 || list2.size() == 0) {
                lines.add(new LineItem(Type.REMOVED, list1.get(i)));
                continue;
            }

            if (list1.get(i).equals(list2.get(i)))
                lines.add(new LineItem(Type.SAME, list1.get(i)));
            else {
                if(i != list2.size()-1) {
                    if (list1.get(i).equals(list2.get(i + 1))) {
                        lines.add(new LineItem(Type.ADDED, list2.get(i)));
                        list1.add(i, "");
                    } else {
                        lines.add(new LineItem(Type.REMOVED, list1.get(i)));
                        list2.add(i, "");
                    }
                } else {
                    lines.add(new LineItem(Type.REMOVED, list1.get(i)));
                    list2.add(i, "");
                }
            }

            if (i == list1.size() - 1 && list2.size() - list1.size() == 1) {
                lines.add(new LineItem(Type.ADDED, list2.get(i+1)));
                continue;
            }
        }

        for(LineItem li : lines) {
            String type = "";

            switch (li.type) {
                case ADDED:
                    type = "ADDED";
                break;

                case REMOVED:
                    type = "REMOVED";
                    break;

                case SAME:
                    type = "SAME";
                    break;

            }

            System.out.println(type + " " + li.line);
        }
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
