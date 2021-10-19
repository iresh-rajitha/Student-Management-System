package function;

import controllers.ClassController;
import controllers.ControllerFactory;
import controllers.SessionController;
import models.Session;
import models.Student;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class SessionFunction {
    private SessionController sessionController;
    private ClassController classController;

    public SessionFunction() {
        sessionController=  (SessionController) ControllerFactory.getInstance().getController(ControllerFactory.controllerType.SESSION);
        classController=  (ClassController) ControllerFactory.getInstance().getController(ControllerFactory.controllerType.CLASS);
    }
    public void sessionConsole(Scanner scanner){
        int input = 0 ;
        do{
            System.out.println("0 - Exit");
            System.out.println("1 - Add Session");
            System.out.println("2 - Update Session");
            System.out.println("3 - Delete Session");
            System.out.println("4 - Get Session by id");
            System.out.println("5 - Get All Sessions");
            System.out.print("Your choice:");
            input = Integer.parseInt(scanner.nextLine());

            switch (input){
                case 1: addSession(scanner); break;
                case 2: updateSession(scanner); break;
                case 3: deleteSession(scanner); break;
                case 4: getOneSession(scanner); break;
                case 5: getAllSessions();
            }
        }while (input != 0);
        System.out.println("Exit From Session");
    }
    public boolean addSession(Scanner scanner)  {
        sessionController.add(getSessionDetails(scanner,0));
        return true;
    }
    public Session getSessionDetails(Scanner scanner, int id){
        Session session =  new Session();
        if (id==0){
            id=sessionController.generateID();
        }
        session.setId(id);

        System.out.print("Class : ");
        session.setCls(classController.getOne(Integer.parseInt(scanner.nextLine())));
        int year=0,month=0,day=0,shour=0,sminute=0,ehour=0,eminute=0;

        System.out.println("Date:");
        System.out.print("Year : ");
        year = Integer.parseInt(scanner.nextLine());
        System.out.print("Month : ");
        month = Integer.parseInt(scanner.nextLine());
        System.out.print("Day : ");
        day = Integer.parseInt(scanner.nextLine());
        System.out.println("Start:");
        System.out.print("Hour : ");
        shour = Integer.parseInt(scanner.nextLine());
        System.out.print("Minute : ");
        sminute = Integer.parseInt(scanner.nextLine());
        System.out.println("End:");
        System.out.print("Hour : ");
        ehour = Integer.parseInt(scanner.nextLine());
        System.out.print("Minute : ");
        eminute = Integer.parseInt(scanner.nextLine());
        String sTime = day +"-"+month+"-"+year+" "+shour+":"+sminute;
        String eTime = day +"-"+month+"-"+year+" "+ehour+":"+eminute;
        SimpleDateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
        try {
            Date sDateTime = formatter.parse(sTime);
            Date eDateTime = formatter.parse(eTime);
            session.setStartTime(sDateTime);
            session.setEndTime(eDateTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return session;
    }
    public void updateSession(Scanner scanner){
        System.out.print(" Session ID :");
        int sessionId= Integer.parseInt(scanner.nextLine());
        sessionController.update(getSessionDetails(scanner,sessionId));
    }
    public void deleteSession(Scanner scanner){
        System.out.print(" Session ID :");
        int sessionId= Integer.parseInt(scanner.nextLine());
        sessionController.delete(sessionId);
    }
    public void getOneSession(Scanner scanner){
        System.out.print("ID :");
        int sessionId= Integer.parseInt(scanner.nextLine());
        Session session=sessionController.getOne(sessionId);
        if ((session != null)){
            System.out.println("Session ID:"+ session.getId());
            System.out.println("Session start time:"+ session.getStartTime());
            System.out.println("Session end time:"+ session.getEndTime());
            System.out.println("Class:"+ session.getCls().getClassName());
        }else{
            System.out.println("Invalid ID");
        }
    }
    public void getAllSessions(){
        List<Session> sessions= sessionController.getAll();
        System.out.println("=============================================");
        if (sessions.size()>0){
            for (Session session : sessions){
                System.out.println("Session ID:"+ session.getId());
                System.out.println("Session start time:"+ session.getStartTime());
                System.out.println("Session end time:"+ session.getEndTime());
                System.out.println("Class:"+ session.getCls().getClassName());
                System.out.println("=============================================");
            }
        }else{
            System.out.println("Student list is empty");
        }
    }
}
