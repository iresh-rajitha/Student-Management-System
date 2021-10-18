package services.impl;

import models.Attendance;
import services.AttendanceService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AttendanceServiceImpl implements AttendanceService {
    List <Attendance> attendanceList;

    public AttendanceServiceImpl() {
        this.attendanceList = new ArrayList<>();
    }

    @Override
    public boolean add(Attendance attendance) {
        attendanceList.add(attendance);
        return true;
    }

    @Override
    public boolean update(Attendance attendance) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public List<Attendance> getAll() {
        return attendanceList;
    }

    @Override
    public Attendance getOne(int id) {
        return attendanceList != null ?
                attendanceList.stream()
                        .filter(attendance -> attendance.getId() == id)
                        .collect(Collectors.toList())
                        .get(0) :
                null;
    }

    @Override
    public int generateID() {
        return 0;
    }
}
