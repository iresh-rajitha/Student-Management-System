package controllers;

import models.Student;
import models.SuperModel;

import java.util.List;

public interface SuperController<T extends SuperModel> {
    public boolean add(T t);
    public boolean update(T t);
    public boolean delete(int id);
    public List<T> getAll();
    public T getOne(int id);
    public int generateID();
}
