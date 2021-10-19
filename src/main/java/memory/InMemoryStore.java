package memory;

import models.Student;

import java.util.ArrayList;
import java.util.List;

public class InMemoryStore {
    static List<Student> studentList;

    public InMemoryStore(){
        studentList =  new ArrayList<>();
    }
    public static List<Student> getStudentList(){
        return studentList;
    }
}

