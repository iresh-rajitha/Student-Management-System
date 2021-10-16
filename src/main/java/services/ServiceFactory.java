package services;

import services.impl.ClassServiceImpl;
import services.impl.StudentServiceImpl;

public class ServiceFactory {

    public enum serviceType{
        STUDENT,ClASS,SESSION,ATTENDANCE;
    }

    private static ServiceFactory serviceFactory;

    private ServiceFactory(){
    }
    public static ServiceFactory getInstance(){
        if ( serviceFactory == null){
            return serviceFactory =  new ServiceFactory();
        }
        return serviceFactory;
    }
    public SuperService getService(serviceType type){
        switch (type){
            case STUDENT: return (SuperService) new StudentServiceImpl();
            case ClASS: return (SuperService) new ClassServiceImpl();
            //Extend other Services Here
            default:return null;
        }
    }
}
