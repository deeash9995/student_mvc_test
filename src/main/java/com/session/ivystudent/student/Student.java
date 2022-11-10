package com.session.ivystudent.student;

import javax.persistence.*;

@Entity
@Table
public class Student {

    @Id
   // @SequenceGenerator( name = "student_sequence", sequenceName = "student_sequence", allocationSize = 1 )
    //@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "student_sequence")
    private Integer id;
    private String name;
    private Integer age;
    private String email;

    public Student() {
    }

    public Student(Integer id, String name, Integer age, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public Student(String name, Integer age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }
}
