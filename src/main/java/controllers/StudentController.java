package controllers;

import models.Student;

import java.util.List;

public interface StudentController extends SuperController{
    public boolean add(Student student);
    public boolean update(Student student);
    public boolean delete(int id);
    public List<Student> getAll();
    public Student getOne(int id);
    public int generateID();
}
