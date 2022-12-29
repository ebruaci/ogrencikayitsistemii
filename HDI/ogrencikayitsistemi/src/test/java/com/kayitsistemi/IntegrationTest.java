package com.kayitsistemi;

import com.kayitsistemi.model.Student;
import com.kayitsistemi.service.StudentService; 
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = {"spring.profiles.active=dev"})
public class IntegrationTest {

    @Autowired
    private StudentService studentService;

    @Test
    public void testFindStudent(){
        List<Student> studentList =  studentService.getStudentList();
        MatcherAssert.assertThat(studentList.size(), Matchers.equalTo(3));

    }
}
