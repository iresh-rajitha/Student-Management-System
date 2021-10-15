package Services.impl;

import Models.Student;
import Services.StudentService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StudentServiceImpl implements StudentService {
    List<Student> studentList;

    public StudentServiceImpl() {
        this.studentList = new ArrayList<>();
    }

    @Override
    public boolean add(Student student) {
        studentList.add(student);
        return true;
    }

    @Override
    public boolean update(Student studentUpdate) {
        Student oldData= getOne(studentUpdate.getId());
        studentList.set(studentList.indexOf(oldData), studentUpdate);
        return true;
    }

    @Override
    public boolean delete(int id) {
        return studentList.remove(getOne(id));
    }

    @Override
    public List<Student> getAll() {
        return studentList;
    }

    @Override
    public Student getOne(int id) {

        return studentList != null ?
                studentList.stream()
                .filter(student1 -> student1.getId() == id)
                .collect(Collectors.toList())
                .get(0) :
                null;
    }

    @Override
    public int generateID() {
        return studentList.size() !=0 ? studentList.get(studentList.size()-1).getId() + 1 : 1;
    }
}
