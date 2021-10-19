//import jdk.nashorn.internal.parser.JSONParser;
//import memory.StudentMemoryStore;
//import models.Student;
//import org.json.JSONArray;
//import org.json.JSONObject;
//
//import java.io.*;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import java.util.Objects;
//import java.util.stream.Collectors;
//
//public class MemoryTest {
//    public static void main(String[] args) throws IOException, ParseException {
//
//        List<Student> students= new ArrayList<>();
//        for (int i=0 ; i<5;i++){
//            Student student= new Student(1,"iresh",new Date(),new Date());
//            students.add(student);
//        }
//        StudentMemoryStore  studentMemoryStore=  new StudentMemoryStore();
////        Write File
//        studentMemoryStore.write(students);
////        ReadFile
//        System.out.println(studentMemoryStore.read().toString());;
//    }
//}
//
