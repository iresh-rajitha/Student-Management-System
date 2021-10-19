package services;

import services.impl.AttendanceServiceImpl;
import services.impl.ClassServiceImpl;
import services.impl.StudentServiceImpl;

public class ServiceFactory {
// new ServiceFactory();
    public enum serviceType{
        STUDENT,CLASS,SESSION,ATTENDANCE;
    }
    //Singleton start
    private static ServiceFactory serviceFactory;

    private ServiceFactory(){
    }

    public static ServiceFactory getInstance(){
        if ( serviceFactory == null){
            return serviceFactory =  new ServiceFactory();
        }
        return serviceFactory;
    }
//    Singleton Ends

//    Factory
    public SuperService getService(serviceType type){
        switch (type){
            case STUDENT: return (SuperService) new StudentServiceImpl();
            case CLASS: return (SuperService) new ClassServiceImpl();
            case ATTENDANCE: return (SuperService) new AttendanceServiceImpl();

            default:return null;
        }
    }
}
