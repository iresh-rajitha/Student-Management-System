package Services;

import Services.impl.StudentServiceImpl;

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
            //Extend other Services Here
            default:return null;
        }
    }
}