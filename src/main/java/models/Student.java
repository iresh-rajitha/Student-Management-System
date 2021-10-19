package models;

import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Student implements SuperModel {
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
    public Student(JSONObject explrObject){
        SimpleDateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
        this.id = explrObject.getInt("id");
        this.name = explrObject.getString("name");
        try {
            this.dob = formatter.parse(explrObject.getString("dob"));
            this.joinedDate = formatter.parse(explrObject.getString("joinedDate"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

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

    @Override
    public String toString() {
        return "{" +
                "id:" + id +
                ", name:'" + name + '\'' +
                ", dob:'" + dob +'\'' +
                ", joinedDate: '" + joinedDate +'\'' +
                "}";
    }

    public Student toObject(JSONObject explrObject){
        Student read = new Student();
        SimpleDateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
        read.setId(explrObject.getInt("id"));
        read.setName(explrObject.getString("name"));
        try {
            read.setDob(formatter.parse(explrObject.getString("dob")));
            read.setJoinedDate(formatter.parse(explrObject.getString("joinedDate")));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(read.toString()); // For testing
        return read;
    }


}
