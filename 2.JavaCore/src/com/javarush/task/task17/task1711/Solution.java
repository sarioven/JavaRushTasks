package com.javarush.task.task17.task1711;

import java.text.SimpleDateFormat;
import java.util.*;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws Exception {
        switch (args[0]) {

            case "-c":
                synchronized (allPeople) {
                    for (int i = 1; i + 2 < args.length; i += 3) {
                        if (args[i + 1].equals("м"))
                            allPeople.add(Person.createMale(args[i], new SimpleDateFormat("d/MM/yyyy", Locale.ENGLISH).parse(args[i + 2])));
                        else
                            allPeople.add(Person.createFemale(args[i], new SimpleDateFormat("d/MM/yyyy", Locale.ENGLISH).parse(args[i + 2])));

                        System.out.println(allPeople.size() - 1);
                    }
                    break;
                }

            case "-u":
                synchronized (allPeople) {
                    for (int i = 1; i + 2 < args.length; i += 4) {
                        if (args[i + 2].equals("м"))
                            allPeople.set(Integer.parseInt(args[i]), Person.createMale(args[i + 1], new SimpleDateFormat("d/MM/yyyy", Locale.ENGLISH).parse(args[i + 3])));
                        else
                            allPeople.set(Integer.parseInt(args[i]), Person.createFemale(args[i + 1], new SimpleDateFormat("d/MM/yyyy", Locale.ENGLISH).parse(args[i + 3])));
                    }

                    break;
                }

            case "-d":
                synchronized (allPeople) {
                    Person person1;

                    for (int i = 1; i < args.length; i++) {
                        person1 = allPeople.get(Integer.parseInt(args[i]));

                        person1.setName(null);
                        person1.setSex(null);
                        person1.setBirthDate(null);
                    }

                    break;
                }

            case "-i":
                synchronized (allPeople) {
                    Person person2;

                    for (int i = 1; i < args.length; i++) {
                        person2 = allPeople.get(Integer.parseInt(args[i]));

                        Calendar cal = new GregorianCalendar();
                        cal.setTime(person2.getBirthDate());

                        System.out.println(person2.getName() + " " + ((person2.getSex() == Sex.MALE) ? "м" : "ж") + " " + cal.get(Calendar.DAY_OF_MONTH) + "-" + new SimpleDateFormat("MMM", Locale.ENGLISH).format(person2.getBirthDate().getTime()) + "-" + cal.get(Calendar.YEAR));
                    }

                    break;
                }
        }
    }
}
