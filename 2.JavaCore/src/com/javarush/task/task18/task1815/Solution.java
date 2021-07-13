package com.javarush.task.task18.task1815;

import java.util.List;

/* 
Таблица
*/

public class Solution {
    public class TableInterfaceWrapper implements TableInterface {
        public TableInterface table;

        public TableInterfaceWrapper(TableInterface table) {
            this.table = table;
        }

        public void setModel(List rows) {
            System.out.println(rows.size());

            table.setModel(rows);
        }

        public String getHeaderText() {
            return table.getHeaderText().toUpperCase();
        }

        public void setHeaderText(String newHeaderText) {
            table.setHeaderText(newHeaderText);
        }
    }

    public interface TableInterface {
        void setModel(List rows);

        String getHeaderText();

        void setHeaderText(String newHeaderText);
    }

    public static void main(String[] args) {

    }
}