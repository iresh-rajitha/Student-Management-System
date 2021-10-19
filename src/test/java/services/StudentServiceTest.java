package services;

import models.Student;
import org.junit.jupiter.api.Test;
import services.impl.StudentServiceImpl;

import java.util.Date;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class StudentServiceTest {
    @Test
    public void should_empty_when_create(){
        StudentService studentService =  new StudentServiceImpl();
        assertThat(studentService.getAll(),is(empty()));
        // when initiate it could have json object in fileStore
    }
    @Test
    public void should_hasOne_when_addObject(){
        StudentService studentService =  new StudentServiceImpl();
        studentService.add(new Student(studentService.generateID(), "Iresh", new Date(), new Date()));
        assertThat(studentService.getAll(),is(hasSize(1)));
    }
    @Test
    public void should_containSame_when_GetAll(){
        StudentService studentService =  new StudentServiceImpl();
        Student s1= new Student(studentService.generateID(), "Iresh", new Date(), new Date());
        studentService.add(s1);
        assertThat(studentService.getAll(),is(hasSize(1)));
    }
    @Test
    public void should_hasOrder_when_add2Objects(){
        StudentService studentService =  new StudentServiceImpl();
        Student s1= new Student(studentService.generateID(), "Iresh", new Date(), new Date());
        Student s2= new Student(studentService.generateID(), "Rajitha", new Date(), new Date());
        studentService.add(s1);
        studentService.add(s2);
        assertThat(studentService.getAll(),is(hasSize(2)));
    }

}
