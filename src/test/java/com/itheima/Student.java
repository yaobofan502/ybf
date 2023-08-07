package com.itheima;

import java.util.Objects;

public class Student {

    private String name;

    private String id;


    public Student(String name, String id) {
        this.name = name;
        this.id = id;
    }


    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || o.getClass() != getClass()) return false;
        Student student = (Student) o;
        return this.name.equals(student.name) && this.id.equals(student.id);
        //return Objects.equals(name,student.name) && Objects.equals(id,student.id);
    }

    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }


    public static void main(String[] args) {
        Student stu1 = new Student("小明", "1");
        Student stu2 = new Student("小明", "1");
        System.out.println(stu1.equals(stu2));
        System.out.println(stu1.hashCode());
        System.out.println(stu2.hashCode());
    }

}
