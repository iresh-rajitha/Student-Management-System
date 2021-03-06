package function;

import controllers.ControllerFactory;
import controllers.ClassController;
import models.Class;

import java.util.List;
import java.util.Scanner;

public class ClassFunction {

    private ClassController classController;

    public ClassFunction(){
        classController =  (ClassController) ControllerFactory.getInstance().getController(ControllerFactory.controllerType.CLASS);
    }

    public void classConsole(Scanner scanner){
        int input = 0 ;
        do{
            System.out.println("0 - Exit");
            System.out.println("1 - Add Class");
            System.out.println("2 - Update Class");
            System.out.println("3 - Delete Class");
            System.out.println("4 - Get Class by classId");
            System.out.println("5 - Get All Class");
            System.out.print("Your choice:");
            input = Integer.parseInt(scanner.nextLine());

            switch (input){
                case 1: addClass(scanner); break;
                case 2: updateClass(scanner); break;
                case 3: deleteClass(scanner); break;
                case 4: getOneClass(scanner); break;
                case 5: getAllClasss();
            }
        }while (input != 0);
        System.out.println("Exit From Class");
    }
    public boolean addClass(Scanner scanner)  {
        classController.add(getClassDetails(scanner,0));
        return true;
    }
    public void getOneClass(Scanner scanner){
        System.out.print("ID :");

        try {
            int classId= Integer.parseInt(scanner.nextLine());
            Class cls=classController.getOne(classId);
            if ((cls != null)){
                System.out.println("    Class ID       :"+ cls.getClassId());
                System.out.println("    Class Name     :"+ cls.getClassName());
                System.out.println("    Class Teacher  :"+ cls.getTeacherName());
                System.out.println("    Class Year     :"+ cls.getYear());
                System.out.println("    Class Students :" + cls.getEnrolledStudents());
            }else{
                System.out.println("--------------------Invalid Input----------------------");
            }
        } catch (Exception e) {
            System.out.println("--------------------Invalid Input----------------------");
        }
    }
    public void getAllClasss(){
        List<Class> classes= classController.getAll();
        System.out.println("=======================================================");
        if (classes.size()>0){
            for (Class cls : classes){
                System.out.println("    Class ID       :"+ cls.getClassId());
                System.out.println("    Class Name     :"+ cls.getClassName());
                System.out.println("    Class Teacher  :"+ cls.getTeacherName());
                System.out.println("    Class Year     :"+ cls.getYear());
                System.out.println("    Class Students :" + cls.getEnrolledStudents());
                System.out.println("=======================================================");
            }
        }else{
            System.out.println("Class list is empty");
        }
    }
    public Class getClassDetails(Scanner scanner, int classId){
        Class cls =  new Class();
        String command;
        boolean studentsAdded = false;

//        System.out.print("ID :");
        if (classId == 0){
            classId = classController.generateID();
        }
        cls.setClassId(classId);

        try {
            System.out.print("  Class Name : ");
            cls.setClassName(scanner.nextLine());

            System.out.print("  Class Teacher Name : ");
            cls.setTeacherName(scanner.nextLine());

            System.out.print("  Year : ");
            cls.setYear(Integer.parseInt(scanner.nextLine()));

            while (!studentsAdded) {
                System.out.print("  Press 'A' to add students to the class or 'F' to finish class setup: ");
                command = scanner.nextLine();

                if(command.equals("A")) {
                    System.out.print("      Enter student id: ");
                    cls.setEnrolledStudents(Integer.parseInt(scanner.nextLine()));
                } else if (command.equals("F")) {
                    studentsAdded = true;
                }
            }
        } catch (Exception e) {
            System.out.println("--------------------Invalid Input----------------------");
        }

        return cls;
    }
    public void updateClass(Scanner scanner){
        System.out.print("  class ID :");

        try {
            int classId= Integer.parseInt(scanner.nextLine());
            classController.update(getClassDetails(scanner, classId));
        } catch (Exception e) {
            System.out.println("--------------------Invalid Input----------------------");
        }
    }
    public void deleteClass(Scanner scanner){
        System.out.print(" class ID :");

        try {
            int classId= Integer.parseInt(scanner.nextLine());
            classController.delete(classId);
        } catch (Exception e) {
            System.out.println("--------------------Invalid Input----------------------");
        }
    }
}
