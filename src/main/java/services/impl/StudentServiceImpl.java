package services.impl;

import memory.StudentMemoryStore;
import models.Student;
import models.SuperModel;
import services.StudentService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StudentServiceImpl implements StudentService {
    private List<Student> studentList;
    private StudentMemoryStore studentMemoryStore;

    public StudentServiceImpl() {
        this.studentList = new ArrayList<>();
        studentMemoryStore =  new StudentMemoryStore();
    }

    @Override
    public boolean add(Student student) {
        boolean arg =studentList.add(student);
        studentMemoryStore.write(studentList);
        return arg;
    }

    @Override
    public boolean update(Student studentUpdate) {
        Student oldData= getOne(studentUpdate.getId());
        Student updated=studentList.set(studentList.indexOf(oldData), studentUpdate);
        studentMemoryStore.write(studentList);
        return updated != null;
    }

    @Override
    public boolean delete(int id) {
        boolean arg = studentList.remove(deleteObj(id));
        studentMemoryStore.write(studentList);
        return arg;
    }

    @Override
    public List<Student> getAll() {
        studentList =  studentMemoryStore.read();
        return studentList;
    }

    @Override
    public Student getOne(int id) {
        studentList =  studentMemoryStore.read();
        return studentList != null ?
                studentList.stream()
                .filter(student1 -> student1.getId() == id)
                .collect(Collectors.toList())
                .get(0) :
                null;
    }
    public Student deleteObj (int id){
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
