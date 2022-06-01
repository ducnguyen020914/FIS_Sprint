package dao;

import core.Student;

public interface IStudentDAO {
    public void addStudent(Student student);
    Student remove(int code);
    void sort();
}
