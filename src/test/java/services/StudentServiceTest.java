package services;

import org.junit.jupiter.api.Test;
import services.impl.StudentServiceImpl;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.is;

public class StudentServiceTest {
    @Test
    public void should_when_(){
        StudentService studentService =  new StudentServiceImpl();
        assertThat(studentService.getAll(),is(empty()));
    }
}
