package controllers;

import models.Class;

import java.util.List;

public interface ClassController extends SuperController{
    public boolean add(Class cls);
    public boolean update(Class cls);
    public boolean delete(int classId);
    public List<Class> getAll();
    public Class getOne(int classId);
    public int generateID();
}
