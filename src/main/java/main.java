import controllers.ControllerFactory;
import controllers.StudentController;
import function.AttendanceFunction;
import function.ClassFunction;
import function.SessionFunction;
import function.StudentFunction;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        ControllerFactory controllerFactory = ControllerFactory.getInstance();


        Scanner scan = new Scanner(System.in);
        int input = 0;
        System.out.println("=======================================================");
        System.out.println("               Student Management System");
        System.out.println("=======================================================");
        System.out.println("     Herath H.M.D.P.M       |      Madhushan G.G.N");
        System.out.println("     Rohana D.M.G           |      Kalhara H.K.I.R");
        System.out.println("=======================================================");
        System.out.println("Enter a number to get started!");
        do{
            System.out.println("=======================================================");
            System.out.println("0 - Exit");
            System.out.println("1 - Student");
            System.out.println("2 - Class");
            System.out.println("3 - Session");
            System.out.println("4 - Attendance");
            System.out.println("=======================================================");
            System.out.print("Your choice:");

            try {
                input = Integer.parseInt(scan.nextLine());
            } catch (Exception e) {
                System.out.println("--------------------Invalid Input----------------------");
            }

            if (1 == input){
                StudentFunction studentFunction = new StudentFunction(controllerFactory);
                studentFunction.studentConsole(scan);
            } else if (2 == input) {
                ClassFunction classFunction = new ClassFunction();
                classFunction.classConsole(scan);
            }else if( 4 == input){
                AttendanceFunction attendanceFunction =  new AttendanceFunction();
                attendanceFunction.attendanceConsole(scan);
            }
            else if (3 == input) {
                SessionFunction sessionFunction = new SessionFunction();
                sessionFunction.sessionConsole(scan);
            }
        }while(0 != input);
        scan.close();
//        new StudentFunction(controllerFactory).getAllStudents();
    }
}
