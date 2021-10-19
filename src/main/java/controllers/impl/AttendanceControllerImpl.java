package controllers.impl;

import controllers.AttendanceController;
import models.Attendance;
import models.SuperModel;
import services.AttendanceService;
import services.ServiceFactory;

import java.util.List;

public class AttendanceControllerImpl implements AttendanceController {
    private AttendanceService attendanceService;

    public AttendanceControllerImpl(){
        attendanceService= (AttendanceService) ServiceFactory.getInstance().getService(ServiceFactory.serviceType.ATTENDANCE);
    }

    @Override
    public boolean add(Attendance attendance) {
        return attendanceService.add(attendance);
    }

    @Override
    public boolean update(Attendance attendance) {
        return attendanceService.update(attendance);
    }

    @Override
    public boolean delete(int id) {
        return attendanceService.delete(id);
    }

    @Override
    public List<Attendance> getAll() {
        return attendanceService.getAll();
    }

    @Override
    public Attendance getOne(int id) {
        return attendanceService.getOne(id);
    }

    @Override
    public int generateID() {
        return attendanceService.generateID();
    }
}
