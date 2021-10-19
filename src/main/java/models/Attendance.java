package models;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Attendance implements SuperModel {
    private int id;
    private Session session;
    private List<Student> students;

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Attendance(){
    }
    public Attendance(JSONObject explrObject){
        this.id = explrObject.getInt("id");
        JSONObject jsonObject= explrObject.getJSONObject("session");
//        this.session= new Session(jsonObject.getInt());
    }

    public Attendance(int id, Session session) {
        this.id = id;
        this.session = session;
        this.students=new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public void addStudent(Student student){
        List<Student> temp=this.students;
        temp.add(student);
        this.students=temp;
    }

    @Override
    public String toString() {
        return "{" +
                "id:" + id +
                ", session:" + session +
                ", students:" + students +
                '}';
    }
}
