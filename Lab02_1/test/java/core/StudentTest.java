package core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

class StudentTest {

  @Test
    void getCode() {
    Student student = new Student(1,"duc",new Date());
    Assertions.assertEquals(1,student.getCode());
    }
}