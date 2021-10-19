package services.impl;

import memory.SessionMemoryStore;
import models.Session;
import services.SessionService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SessionServiceImpl implements SessionService {
    List<Session> sessionList;
    private SessionMemoryStore sessionMemoryStore;

    public SessionServiceImpl() {

        this.sessionList=new ArrayList<>();
        sessionMemoryStore=new SessionMemoryStore();
    }

    @Override
    public boolean add(Session session) {
        boolean arg=sessionList.add(session);
        sessionMemoryStore.write(sessionList);
        return arg;
    }

    @Override
    public boolean update(Session session) {
        Session oldData= getOne(session.getId());
        Session newSession =sessionList.set(sessionList.indexOf(oldData), session);
        sessionMemoryStore.write(sessionList);
        return newSession!=null;
    }

    @Override
    public boolean delete(int id) {
        boolean arg=sessionList.remove(deleteObj(id));
        sessionMemoryStore.write(sessionList);
        return arg;
    }

    @Override
    public List<Session> getAll() {
        sessionList=sessionMemoryStore.read();
        return sessionList;
    }

    @Override
    public Session getOne(int id) {
        sessionList=sessionMemoryStore.read();
        return sessionList != null ?
                sessionList.stream()
                        .filter(session -> session.getId() == id)
                        .collect(Collectors.toList())
                        .get(0) :
                null;
    }
    public Session deleteObj (int id){
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
