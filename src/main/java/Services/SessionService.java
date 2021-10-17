package Services;

import Models.Session;
import Models.Student;

import java.util.List;

public interface SessionService extends SuperService {
    public boolean add(Session session);
    public boolean update(Session session);
    public boolean delete(int id);
    public List<Session> getAll();
    public Session getOne(int id);
}
