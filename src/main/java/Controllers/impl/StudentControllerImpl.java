package Controllers.impl;

import Controllers.StudentController;
import Models.Student;
import Services.ServiceFactory;
import Services.StudentService;

import java.util.List;

public class StudentControllerImpl implements StudentController {
    private StudentService studentService;

    public StudentControllerImpl() {
        studentService= (StudentService)ServiceFactory.getInstance().getService(ServiceFactory.serviceType.STUDENT);
    }

    @Override
    public boolean add(Student student) {
        return studentService.add(student);
    }

    @Override
    public boolean update(Student student) {
        return studentService.update(student);
    }

    @Override
    public boolean delete(int id) {
        return studentService.delete(id);
    }

    @Override
    public List<Student> getAll() {
        return studentService.getAll();
    }

    @Override
    public Student getOne(int id) {
        return studentService.getOne(id);
    }

    @Override
    public int generateID() {
        return studentService.generateID();
    }
}
