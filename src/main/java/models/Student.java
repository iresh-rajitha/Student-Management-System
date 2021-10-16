package models;

import java.util.Date;

public class Student {
    private int id;
    private String name;
    private Date dob;
    private Date joinedDate;

    public Student(){}
    public Student(int id, String name, Date dob, Date joinedDate) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.joinedDate = joinedDate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public void setJoinedDate(Date joinedDate) {
        this.joinedDate = joinedDate;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getDob() {
        return dob;
    }

    public Date getJoinedDate() {
        return joinedDate;
    }
}
