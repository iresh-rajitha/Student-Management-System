package models;

import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Session implements SuperModel{
    private int id;
    private Class cls;
    private Date startTime;
    private Date endTime;

    public Session() {}

    public Session(int id, Class cls, Date startTime, Date endTime) {
        this.id = id;
        this.cls = cls;
        this.startTime = startTime;
        this.endTime = endTime;
    }
    public Session(JSONObject explrObject)  {
        SimpleDateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
        this.id = explrObject.getInt("id");
        this.cls = new Class(explrObject.getJSONObject("cls"));
        try {
            this.startTime = formatter.parse(explrObject.getString("startTime"));
            this.endTime = formatter.parse(explrObject.getString("endTime"));
        }catch (ParseException e){
            e.printStackTrace();
        }
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Class getCls() {
        return cls;
    }

    public void setCls(Class cls) {
        this.cls = cls;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "{" +
                "id:" + id +
                ", cls:" + cls +
                ", startTime:'" + startTime +'\'' +
                ", endTime: '" + endTime +"\'" +
                "}";
    }

    public Session toObject(JSONObject explrObject) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
        Session read = new Session();

        read.setId(explrObject.getInt("id"));
        read.setCls(new Class(explrObject.getJSONObject("cls")));
        read.setStartTime(formatter.parse(explrObject.getString("startTime")));
        read.setEndTime(formatter.parse(explrObject.getString("endTime")));
        System.out.println(read.toString()); // For testing
        return read;
    }
}
