package Models;

import java.time.LocalDateTime;

public class Session {
    private int id;
    private Class cls;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public Session() {
    }

    public Session(int id, Class cls, LocalDateTime startTime, LocalDateTime endTime) {
        this.id = id;
        this.cls = cls;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Class getCls() {
        return cls;
    }

    public void setCls(Class cls) {
        this.cls = cls;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
