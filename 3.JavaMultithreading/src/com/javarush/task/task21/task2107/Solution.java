package com.javarush.task.task21.task2107;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/* 
Глубокое клонирование карты
*/

public class Solution implements Cloneable{

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.users.put("Hubert", new User(172, "Hubert"));
        solution.users.put("Zapp", new User(41, "Zapp"));
        Solution clone = null;
        try {
            clone = solution.clone();
            System.out.println(solution);
            System.out.println(clone);

            System.out.println(solution.users);
            System.out.println(clone.users);

            System.out.println(solution.equals(clone));

        } catch (CloneNotSupportedException e) {
            e.printStackTrace(System.err);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Solution)) return false;
        Solution solution = (Solution) o;
        return Objects.equals(users, solution.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(users);
    }

    public Solution clone() throws CloneNotSupportedException {
        Solution solution = (Solution) super.clone();
        Map<String, User> list = new LinkedHashMap<>();

        for(Map.Entry<String, User> map : users.entrySet()) {
            list.put(map.getKey(), map.getValue().clone());
        }

        solution.users = list;

        return solution;
    }

    protected Map<String, User> users = new LinkedHashMap<>();

    public static class User implements Cloneable {
        int age;
        String name;

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof User)) return false;
            User user = (User) o;
            return Objects.equals(age, user.age)&&
                    Objects.equals(name,user.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(age, name);
        }

        public User clone() throws CloneNotSupportedException {
            User user = (User) super.clone();
            user.age = age;
            user.name = new String(name);

            return user;
        }
    }
}
