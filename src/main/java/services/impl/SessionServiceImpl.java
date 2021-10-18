package services.impl;

import models.Session;
import models.Student;
import services.SessionService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SessionServiceImpl implements SessionService {
    List<Session> sessionList;

    public SessionServiceImpl() {
        this.sessionList=new ArrayList<>();
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
        sessionList.remove(getOne(id));
        return true;
    }

    @Override
    public List<Session> getAll() {
        return sessionList;
    }

    @Override
    public Session getOne(int id) {
        return sessionList != null ?
                sessionList.stream()
                        .filter(session -> session.getId() == id)
                        .collect(Collectors.toList())
                        .get(0) :
                null;
    }

    @Override
    public int generateID() {
        return sessionList.size() !=0 ? sessionList.get(sessionList.size()-1).getId() + 1 : 1;
    }
}
