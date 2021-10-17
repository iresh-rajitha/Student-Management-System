package Controllers;

import Controllers.impl.SessionControllerImpl;
import Controllers.impl.StudentControllerImpl;

public class ControllerFactory {
    public enum controllerType{
        STUDENT,ClASS,SESSION,ATTENDANCE;
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
            case SESSION: return (SuperController) new SessionControllerImpl();
            // Enter other types to here to extend
            default: return null;
        }
    }
}
