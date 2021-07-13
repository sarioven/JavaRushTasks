package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class University {

    private List<Student> students = new ArrayList<>();

    public List<Student> getStudents() {
        return students;
    }

    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student getStudentWithAverageGrade(double averageGrade) {
        for(Student student : students) {
            if(student.getAverageGrade() == averageGrade)
                return student;
        }
        return null;
    }

    public Student getStudentWithMaxAverageGrade() {
        Student result = null;
        double max = 0;

        for(Student student : students) {
            if(student.getAverageGrade() > max) {
                result = student;
                max = student.getAverageGrade();
            }
        }

        return result;
    }

    public Student getStudentWithMinAverageGrade() {
        Student result = students.get(0);
        double min = result.getAverageGrade();

        for(Student student : students) {
            if(student.getAverageGrade() < min) {
                result = student;
                min = student.getAverageGrade();
            }
        }

        return result;
    }

    public void expel(Student student) {
        students.remove(student);
    }
}