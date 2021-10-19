package services.impl;

import models.Class;
import models.Session;
import org.junit.jupiter.api.Test;
import services.SessionService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import static org.junit.jupiter.api.Assertions.*;
class SessionServiceImplTest {

    @Test
    public void should_ReturnTrue_when_Added() throws ParseException {
        String stime="31-Dec-2021 10:00:00";
        String etime="31-Dec-2021 11:00:00";
        SimpleDateFormat formatter=new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
        SessionService sessionService=new SessionServiceImpl();
        Class cls=new Class(1,2,"class1","teacher1",null);
        Session session=new Session(1,cls,formatter.parse(stime),formatter.parse(etime));
        boolean val=sessionService.add(session);
        assertThat(val,is(true));
    }
//    @Test
//    public void should_Store_when_ASessionAdded() throws ParseException {
//        String stime="31-Dec-2021 10:00:00";
//        String etime="31-Dec-2021 11:00:00";
//        SimpleDateFormat formatter=new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
//        SessionService sessionService=new SessionServiceImpl();
//        Class cls=new Class(1,2,"class1","teacher1",null);
//        Session session=new Session(1,cls,formatter.parse(stime),formatter.parse(etime));
//        boolean val=sessionService.add(session);
//        assertThat(sessionService.getAll(),hasSize(1));
//    }
}