package controllers;

import controllers.impl.ClassControllerImpl;
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
            default: return null;
        }
    }
}
