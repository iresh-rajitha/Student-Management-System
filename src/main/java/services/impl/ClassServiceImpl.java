package services.impl;

import models.Class;
import services.ClassService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ClassServiceImpl implements ClassService {
    List<Class> classList;

    public ClassServiceImpl() {
        this.classList = new ArrayList<>();
    }

    @Override
    public boolean add(Class cls) {
        classList.add(cls);
        return true;
    }

    @Override
    public boolean update(Class classUpdate) {
        Class oldData= getOne(classUpdate.getClassId());
        classList.set(classList.indexOf(oldData), classUpdate);
        return true;
    }

    @Override
    public boolean delete(int classId) {
        return classList.remove(getOne(classId));
    }

    @Override
    public List<Class> getAll() {
        return classList;
    }

    @Override
    public Class getOne(int classId) {

        return classList != null ?
                classList.stream()
                        .filter(class1 -> class1.getClassId() == classId)
                        .collect(Collectors.toList())
                        .get(0) :
                null;
    }

    @Override
    public int generateID() {
        return classList.size() != 0 ? classList.get(classList.size() - 1).getClassId() + 1 : 1;
    }
}
