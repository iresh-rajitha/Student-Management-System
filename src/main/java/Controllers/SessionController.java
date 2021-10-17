package Controllers;

import Models.Session;

import java.util.List;

public interface SessionController {
    public boolean add(Session session);
    public boolean update(Session session);
    public boolean delete(int id);
    public List<Session> getAll();
    public Session getOne(int id);
}