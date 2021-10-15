package Function;

import Controllers.ControllerFactory;
import Controllers.StudentController;
import Models.Student;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
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
            input = Integer.parseInt(scanner.nextLine());

            switch (input){
                case 1: addStudent(scanner); break;
                case 2: updateStudent(scanner); break;
                case 3: deleteStudent(scanner); break;
                case 4: getOneStudent(scanner); break;
                case 5: getAllStudents();
            }
        }while (input != 0);
        System.out.println("Exit From Student");
    }
    public boolean addStudent(Scanner scanner)  {
        studentController.add(getStudentDetails(scanner));
        return true;
    }
    public void getOneStudent(Scanner scanner){
        System.out.print("ID :");
        int studentId= Integer.parseInt(scanner.nextLine());
        Student student=studentController.getOne(studentId);
        if ((student != null)){
            System.out.println("Student ID:"+ student.getId());
            System.out.println("Student Name:"+ student.getName());
            System.out.println("Student Date of Birth:"+ student.getDob());
            System.out.println("Student Joined date:"+ student.getJoinedDate());
        }else{
            System.out.println("Invalid ID");
        }
    }
    public void getAllStudents(){
        List<Student> students= studentController.getAll();
        System.out.println("=============================================");
        for (Student student : students){
            System.out.println("Student ID:"+ student.getId());
            System.out.println("Student Name:"+ student.getName());
            System.out.println("Student Date of Birth:"+ student.getDob());
            System.out.println("Student Joined date:"+ student.getJoinedDate());
            System.out.println("=============================================");
        }
    }
    public Student getStudentDetails(Scanner scanner){
        Student student =  new Student();

        System.out.print("ID :");
        student.setId(Integer.parseInt(scanner.nextLine()));

        System.out.print("Name : ");
        student.setName(scanner.nextLine());

        int year=0,month=0,day=0;

        System.out.println("Date of birth:");
        System.out.print("Year : ");
        year = Integer.parseInt(scanner.nextLine());
        System.out.print("Month : ");
        month = Integer.parseInt(scanner.nextLine());
        System.out.print("Day : ");
        day = Integer.parseInt(scanner.nextLine());
        String dob = day +"-"+month+"-"+year;
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        try {
            Date date = formatter.parse(dob);
            student.setDob(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        student.setJoinedDate(new Date());
        return student;
    }
    public void updateStudent(Scanner scanner){

    }
    public void deleteStudent(Scanner scanner){

    }
}
