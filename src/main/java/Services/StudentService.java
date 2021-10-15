package Services;

import Models.Student;

import java.util.List;

public interface StudentService extends SuperService {
    public boolean add(Student student);
    public boolean update(Student student);
    public boolean delete(int id);
    public List<Student> getAll();
    public Student getOne(int id);
    public int generateID();

}
