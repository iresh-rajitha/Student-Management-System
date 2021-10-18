package controllers.impl;

import controllers.SessionController;
import models.Session;
import services.ServiceFactory;
import services.SessionService;
import services.StudentService;

import java.util.List;

public class SessionControllerImpl implements SessionController {
    private SessionService sessionService;

    public SessionControllerImpl() {
        sessionService= (SessionService) ServiceFactory.getInstance().getService(ServiceFactory.serviceType.SESSION);
    }

    @Override
    public boolean add(Session session) {
        return sessionService.add(session);
    }

    @Override
    public boolean update(Session session) {
        return sessionService.update(session);
    }

    @Override
    public boolean delete(int id) {
        return sessionService.delete(id);
    }

    @Override
    public List<Session> getAll() {
        return sessionService.getAll();
    }

    @Override
    public Session getOne(int id) {
        return sessionService.getOne(id);
    }

    @Override
    public int generateID() {
        return sessionService.generateID();
    }
}
