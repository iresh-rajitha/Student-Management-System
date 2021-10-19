package function;

import controllers.AttendanceController;
import controllers.ControllerFactory;
import models.Attendance;
import models.Session;
import models.Student;
import services.ServiceFactory;
import services.SessionService;

import java.util.List;
import java.util.Scanner;

public class AttendanceFunction {
    private AttendanceController attendanceController;
    private SessionService sessionService;

    public AttendanceFunction(){
        attendanceController=  (AttendanceController) ControllerFactory.getInstance().getController(ControllerFactory.controllerType.ATTENDANCE);
    }

    public void attendanceConsole(Scanner scanner){
        int input = 0 ;
        do{
            System.out.println("0 - Exit");
            System.out.println("1 - Add Attendance");
            System.out.println("2 - View Attendance");
            System.out.print("Your choice:");
            input = Integer.parseInt(scanner.nextLine());

            switch (input){
                case 1: addAttendance(scanner); break;
            }
        }while (input != 0);
        System.out.println("Exit From Attendance");
    }
    public boolean addAttendance(Scanner scanner)  {
        attendanceController.add(getAttendanceData(scanner,0));
        return true;
    }
    public Attendance getAttendanceData(Scanner scanner, int id){
        Session session;
        List<Student> students;
        Attendance attendance=new Attendance();
        if (id==0){
            id=attendanceController.generateID();
        }
        attendance.setId(id);
        System.out.print("Session Id : ");
        session=sessionService.getOne(Integer.parseInt(scanner.nextLine()));
        //students=session.getCls().
        return null;

    }
}
