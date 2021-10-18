package controllers.impl;

import controllers.ClassController;
import models.Class;
import services.ServiceFactory;
import services.ClassService;

import java.util.List;

public class ClassControllerImpl implements ClassController {
    private ClassService classService;

    public ClassControllerImpl() {
        classService= (ClassService)ServiceFactory.getInstance().getService(ServiceFactory.serviceType.CLASS);
    }

    @Override
    public boolean add(Class cls) {
        return classService.add(cls);
    }

    @Override
    public boolean update(Class cls) {
        return classService.update(cls);
    }

    @Override
    public boolean delete(int classId) {
        return classService.delete(classId);
    }

    @Override
    public List<Class> getAll() {
        return classService.getAll();
    }

    @Override
    public Class getOne(int classId) {
        return classService.getOne(classId);
    }

    @Override
    public int generateID() {
        return classService.generateID();
    }
}
