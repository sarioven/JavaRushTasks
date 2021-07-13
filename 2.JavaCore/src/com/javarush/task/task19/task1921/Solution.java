package com.javarush.task.task19.task1921;

import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws Exception {
        FileReader fReader = new FileReader(args[0]);

        String buffer = "";

        while(fReader.ready())
            buffer += (char)fReader.read();

        fReader.close();

        String[] paople;

        String name = "", date = "";

        for(String data : buffer.split("\n")) {
            paople = data.split(" ");

            for(int i=0; i < paople.length-3; i++) {
                name += paople[i];

                if(i != paople.length-4)
                    name += " ";
            }

            for(int i=paople.length-3; i < paople.length; i++)
                date += paople[i] + " ";

            PEOPLE.add(new Person(name, new SimpleDateFormat("d M yyyy").parse(date)));

            name = "";
            date = "";
        }

        for(Person p : PEOPLE)
            System.out.println(p.getName() + " " + p.getBirthDate());
    }
}
