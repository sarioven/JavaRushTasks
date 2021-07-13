package com.javarush.task.task20.task2002;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.*;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File yourFile = File.createTempFile("Test.txt", null);
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User user = new User();

            user.setFirstName("gigi");
            user.setLastName("gg");
            user.setBirthDate(new Date());
            user.setMale(true);
            user.setCountry(User.Country.UKRAINE);

            //javaRush.users.add(user);
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //here check that the javaRush object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны

            if(javaRush.hashCode() == loadedObject.hashCode())
                System.out.println(true);
            else
                System.out.println(false);

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            for(User user : users) {
                outputStream.write((user.getFirstName() + "\n").getBytes());
                outputStream.write((user.getLastName() + "\n").getBytes());
                outputStream.write((user.getBirthDate().getTime() + "\n").getBytes());
                outputStream.write((user.isMale() + "\n").getBytes());
                outputStream.write((user.getCountry().getDisplayName() + "\n").getBytes());
            }

            if(users.size() == 0)
                users = null;
        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            User user = new User();

            String buffer; int counter = 0;
            while((buffer = reader.readLine()) != null) {
                switch(counter) {
                    case 0: user.setFirstName(buffer); break;
                    case 1: user.setLastName(buffer); break;
                    case 2: user.setBirthDate(new Date(Long.parseLong(buffer))); break;
                    case 3: user.setMale(Boolean.parseBoolean(buffer)); break;
                    case 4:
                        switch(buffer) {
                            case "Ukraine": user.setCountry(User.Country.UKRAINE); break;
                            case "Russia": user.setCountry(User.Country.RUSSIA); break;
                            case "Other": user.setCountry(User.Country.OTHER); break;
                        }
                        break;
                }

                if(counter == 4) {
                    counter = 0;
                    users.add(user);
                    user = new User();
                }
                else
                    counter++;
            }

            if(users.size() == 0)
                users = null;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
