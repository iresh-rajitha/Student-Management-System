package memory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileStoreMemory {

    public enum file{
        STUDENT,CLASS,SESSION,ATTENDANCE;
    }
    public boolean writeFile(String data, file type){
        File file = new File("");
//        System.out.println(file.getAbsolutePath()+"\\src\\main\\java\\memory\\filename.txt");
        String fileName = getFileName(type);;

        try {
            FileWriter myWriter = new FileWriter(file.getAbsolutePath()+"\\src\\main\\java\\memory\\"+fileName+".txt");
            myWriter.write(data);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
            return true;
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return false;
        }
    }
    public String readFile(file type){
        String fileName= getFileName(type);
        File file = new File("");
        File myObj = new File(file.getAbsolutePath()+"\\src\\main\\java\\memory\\"+fileName+".txt");

        Scanner myReader = null;
        try {
            myReader = new Scanner(myObj);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        StringBuilder full = new StringBuilder();
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
//            System.out.println(data);
            full.append(data);
        }
        myReader.close();

        return full.toString();
    }
    private String getFileName(file type) {
        String fileName = "Student";
        switch (type){
            case STUDENT: fileName="Student";break;
            case CLASS: fileName="Class";break;
            case SESSION: fileName="Session";break;
            case ATTENDANCE: fileName="Attendance";break;
        }
        return  fileName;
    }
}
