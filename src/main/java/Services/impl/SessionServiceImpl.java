package Services.impl;

import Models.Session;
import Services.SessionService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SessionServiceImpl implements SessionService {
    List<Session> sessionList;

    public SessionServiceImpl() {
        this.sessionList = new ArrayList<>();
    }

    @Override
    public boolean add(Session session) {
        sessionList.add(session);
        return true;
    }

    @Override
    public boolean update(Session session) {
        Session oldData= getOne(session.getId());
        sessionList.set(sessionList.indexOf(oldData), session);
        return true;
    }

    @Override
    public boolean delete(int id) {
        return sessionList.remove(getOne(id));
    }

    @Override
    public List<Session> getAll() {
        return sessionList;
    }

    @Override
    public Session getOne(int id) {
        return sessionList.stream()
                .filter(student1 -> student1.getId() == id)
                .collect(Collectors.toList())
                .get(0);
    }
}
