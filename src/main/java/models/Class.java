package models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Class implements SuperModel{
    private int classId;
    private int year;
    private String className;
    private String TeacherName;
    private List<Integer> enrolledStudents = new ArrayList<>();

    public Class(){}

    public Class(int classId, int year, String className, String teacherName, List<Integer> enrolledStudents) {
        this.classId = classId;
        this.year = year;
        this.className = className;
        TeacherName = teacherName;
        this.enrolledStudents = enrolledStudents;
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
        return TeacherName;
    }

    public void setTeacherName(String teacherName) {
        TeacherName = teacherName;
    }

    public List<Integer> getEnrolledStudents() {
        return enrolledStudents;
    }

    public void setEnrolledStudents(int newStudent) {
        this.enrolledStudents.add(newStudent);
    }
}
