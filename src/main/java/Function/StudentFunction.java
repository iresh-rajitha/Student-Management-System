package Function;

import Controllers.ControllerFactory;
import Controllers.StudentController;
import Models.Student;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class StudentFunction {

    private StudentController studentController;

    public StudentFunction(){
        studentController=  (StudentController) ControllerFactory.getInstance().getController(ControllerFactory.controllerType.STUDENT);
    }


    public void studentConsole(Scanner scanner){
        int input = 0 ;
        do{
            System.out.println("0 - Exit");
            System.out.println("1 - Add Student");
            System.out.println("2 - Update Student");
            System.out.println("3 - Delete Student");
            System.out.println("4 - Get Student by id");
            System.out.println("5 - Get All Student");
            System.out.print("Your choice:");
            input = scanner.nextInt();
            if (input == 1){
                addStudent(scanner);
            }
        }while (input != 0);
        System.out.println("Exit From Student");
    }
    public boolean addStudent(Scanner scanner)  {
        Student student =  new Student();

        System.out.print("ID :");
        student.setId(scanner.nextInt());

        System.out.print("Name : ");
        student.setName(scanner.nextLine());

        int year=0,month=0,day=0;

        System.out.println("Date of birth:");
        System.out.print("Year : ");
        year = scanner.nextInt();
        System.out.print("Month : ");
        month = scanner.nextInt();
        System.out.print("Day : ");
        day = scanner.nextInt();
        String dob = day +"-"+month+"-"+year;
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        try {
            Date date = formatter.parse(dob);
            student.setDob(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        student.setJoinedDate(new Date());
        studentController.add(student);
        return true;

    }
}
