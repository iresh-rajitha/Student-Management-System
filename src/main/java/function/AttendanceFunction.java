package function;

import controllers.AttendanceController;
import controllers.ControllerFactory;
import controllers.SessionController;
import controllers.StudentController;
import models.Attendance;
import models.Session;
import models.Student;
import services.ServiceFactory;
import services.SessionService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AttendanceFunction {
    private AttendanceController attendanceController;
    private SessionController sessionController;
    private StudentController studentController;

    public AttendanceFunction(){
        attendanceController=  (AttendanceController) ControllerFactory.getInstance().getController(ControllerFactory.controllerType.ATTENDANCE);
        sessionController=  (SessionController) ControllerFactory.getInstance().getController(ControllerFactory.controllerType.SESSION);
        studentController =  (StudentController) ControllerFactory.getInstance().getController(ControllerFactory.controllerType.STUDENT);
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
                case 2: getAllAttendance(); break;
            }
        }while (input != 0);
        System.out.println("Exit From Attendance");
    }
    public boolean addAttendance(Scanner scanner)  {
        attendanceController.add(getAttendanceData(scanner,0));
        return true;
    }
    public Attendance getAttendanceData(Scanner scanner, int id){
        Attendance attendance= new Attendance();
        if (id==0){
            id=attendanceController.generateID();
        }
        attendance.setId(id);
        System.out.print("Session Id : ");
        attendance.setSession(sessionController.getOne(Integer.parseInt(scanner.nextLine())));
        List<Student> studentList =  new ArrayList<>();
        System.out.print("Enter 0 to exit");
        System.out.print("Add student id : ");
        int input=0;
        do {
            input=Integer.parseInt(scanner.nextLine());
            if (input !=0 ){
                try {
                    studentList.add(studentController.getOne(input));
                }catch (ArrayIndexOutOfBoundsException e){
                    System.out.println("Student id "+input+" Not available");
                }

            }
        }while (input != 0);
        //students=session.getCls().
        return attendance;
    }
    public void getAllAttendance(){
        List<Attendance> attendanceList=attendanceController.getAll();
        for (Attendance attendance: attendanceList ){
            System.out.println("iD : "+ attendance.getId());
            System.out.println("Session : "+ attendance.getSession());
            System.out.println("Students: "+ attendance.getStudents());
        }
    }
}
