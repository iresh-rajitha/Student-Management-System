package models;

import java.util.Date;

public class Class implements SuperModel{
    private int classId;
    private int year;
    private String className;
    private String TeacherName;

    public Class(){}
    public Class(int classId, int year, String className, String teacherName) {
        this.classId = classId;
        this.year = year;
        this.className = className;
        TeacherName = teacherName;
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
}
