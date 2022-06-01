package core;

import java.util.Date;
import java.util.Objects;

public class Student implements  Comparable<Student> {
    private int code;
    private String name;
    private Date birthDate;
    public Student() {
    }

    public Student(int code, String name, Date birthDate) {
        this.code = code;
        this.name = name;
        this.birthDate = birthDate;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Student{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return getCode() == student.getCode() && getName().equals(student.getName()) && getBirthDate().equals(student.getBirthDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCode(), getName(), getBirthDate());
    }

    @Override
    public int compareTo(Student o) {
        return o.compareTo(this);
    }
}
