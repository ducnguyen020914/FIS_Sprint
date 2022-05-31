package dao.mem;

import core.Student;
import dao.ISortStrategy;
import dao.SelectionSortStrategy;

public class StudentDAOMen {
    private Student[] students ;
    private int count ;
    private ISortStrategy sortStrategy;
    public StudentDAOMen(){
        this.students = new Student[100];
       this.count =  0;
       this.sortStrategy = new SelectionSortStrategy();
    }

    public void addStudent(Student student){
        this.students[count] = student;
    }
    public Student removeStudent(int code){
        for (int i = 0;i < count;i++){
            if(code == students[i].getCode()) {

            }
        }
        return null;
    }
    public void display(){
        for (Student s :students){
            System.out.println(s.toString());
        }
    }
    public void sort(){
        //TODO
    }

    public void setSortStrategy(ISortStrategy sortStrategy) {
        this.sortStrategy = sortStrategy;
    }
}
