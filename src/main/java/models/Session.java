package models;

import java.time.LocalDateTime;
import java.util.Date;

public class Session implements SuperModel{
    private int id;
    private Class cls;
    private Date startTime;
    private Date endTime;

    public Session() {
    }

    public Session(int id, Class cls, Date startTime, Date endTime) {
        this.id = id;
        this.cls = cls;
        this.startTime = startTime;
        this.endTime = endTime;
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
}
