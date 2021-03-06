package controllers;

import controllers.impl.AttendanceControllerImpl;
import controllers.impl.ClassControllerImpl;
import controllers.impl.SessionControllerImpl;
import controllers.impl.StudentControllerImpl;

public class ControllerFactory {
    public enum controllerType{
        STUDENT,CLASS,SESSION,ATTENDANCE;
    }
    private static ControllerFactory controllerFactory;
    private ControllerFactory(){}

    public static ControllerFactory getInstance(){
        if (controllerFactory==null){
            controllerFactory = new ControllerFactory();
        }
        return controllerFactory;
    }
    public SuperController getController(controllerType type){
        switch (type){
            case STUDENT: return (SuperController) new StudentControllerImpl();
            case CLASS: return (SuperController) new ClassControllerImpl();
            case SESSION: return (SuperController) new SessionControllerImpl();
            case ATTENDANCE: return (SuperController) new AttendanceControllerImpl();
            default: return null;
        }
    }
}
