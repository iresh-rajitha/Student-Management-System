package models;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Class implements SuperModel{
    private int classId;
    private int year;
    private String className;
    private String teacherName;
    private List<Integer> enrolledStudents = new ArrayList<>();

    public Class(){}

    public Class(int classId, int year, String className, String teacherName, List<Integer> enrolledStudents) {
        this.classId = classId;
        this.year = year;
        this.className = className;
        this.teacherName = teacherName;
        this.enrolledStudents = enrolledStudents;
    }

    public Class(JSONObject explrObject){
        SimpleDateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
        this.classId = explrObject.getInt("classId");
        this.year = explrObject.getInt("year");
        this.className = explrObject.getString("className");
        this.teacherName = explrObject.getString("teacherName");
//        this.enrolledStudents.add((Integer) explrObject.get("enrolledStudents"));
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getTeacherName() {
        return this.teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public List<Integer> getEnrolledStudents() {
        return enrolledStudents;
    }

    public void setEnrolledStudents(int newStudent) {
        this.enrolledStudents.add(newStudent);
    }

    @Override
    public String toString() {
        return "{" +
                "classId:" + classId +
                ", className:'" + className + '\'' +
                ", teacherName:'" + teacherName +'\'' +
                ", year: '" + year +'\'' +
                ", enrolledStudents: '" + enrolledStudents +'\'' +
                "}";
    }

    public Class toObject(JSONObject explrObject){
        Class read = new Class();

        read.setClassId(explrObject.getInt("classId"));
        read.setClassName(explrObject.getString("className"));
        read.setTeacherName(explrObject.getString("teacherName"));
        read.setYear(explrObject.getInt("year"));
        for (int i = 0; i < explrObject.getJSONArray("enrolledStudents").length(); i++) {
            read.setEnrolledStudents((Integer) explrObject.getJSONArray("enrolledStudents").get(i));
        }
        System.out.println(read.toString()); // For testing
        return read;
    }
}
