import Function.StudentFunction;
import Models.Student;

import java.util.Date;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int input = 0;
        System.out.println("Begin Code Here");
        do{

            System.out.println("0 - Exit");
            System.out.println("1 - Student");
            System.out.println("2 - Class");
            System.out.println("3 - Session");
            System.out.println("4 - Attendance");
            System.out.print("Your choice:");
            input = scan.nextInt();
            if (1 == input){
                StudentFunction studentFunction = new StudentFunction();
                studentFunction.studentConsole(scan);
            } else if (2 == input) {

            }
        }while(0 != input);
        scan.close();
    }
}