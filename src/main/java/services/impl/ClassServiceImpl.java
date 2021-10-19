package services.impl;

import memory.ClassMemoryStore;
import memory.StudentMemoryStore;
import models.Class;
import models.Student;
import services.ClassService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ClassServiceImpl implements ClassService {
    List<Class> classList;
    private ClassMemoryStore classMemoryStore;

    public ClassServiceImpl() {
        this.classList = new ArrayList<>();
        classMemoryStore =  new ClassMemoryStore();
    }

    @Override
    public boolean add(Class cls) {
//        classList.add(cls);
//        return true;
        boolean arg =classList.add(cls);
        classMemoryStore.write(classList);
        return arg;
    }

    @Override
    public boolean update(Class classUpdate) {
//        Class oldData= getOne(classUpdate.getClassId());
//        classList.set(classList.indexOf(oldData), classUpdate);
//        return true;
        Class oldData= getOne(classUpdate.getClassId());
        Class updated=classList.set(classList.indexOf(oldData), classUpdate);
        classMemoryStore.write(classList);
        return updated != null;
    }

    @Override
    public boolean delete(int classId) {

//        return classList.remove(getOne(classId));
        boolean arg = classList.remove(deleteObj(classId));
        classMemoryStore.write(classList);
        return arg;
    }

    @Override
    public List<Class> getAll() {
//        return classList;
        classList =  classMemoryStore.read();
        return classList;
    }

    @Override
    public Class getOne(int classId) {

//        return classList != null ?
//                classList.stream()
//                        .filter(class1 -> class1.getClassId() == classId)
//                        .collect(Collectors.toList())
//                        .get(0) :
//                null;
        classList =  classMemoryStore.read();
        return classList != null ?
                classList.stream()
                        .filter(student1 -> student1.getClassId() == classId)
                        .collect(Collectors.toList())
                        .get(0) :
                null;
    }

    public Class deleteObj (int classId){
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
