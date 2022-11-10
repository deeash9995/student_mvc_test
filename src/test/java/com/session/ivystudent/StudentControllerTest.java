package com.session.ivystudent;

import com.session.ivystudent.student.Student;
import com.session.ivystudent.student.StudentController;
import com.session.ivystudent.student.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Optional;

@WebMvcTest(StudentController.class)
public class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentService studentService;

    @Test
    public void testAddStudents() throws Exception {
        Student student = new Student(1, "Ram", 17, "ram@gmail.com");

        Mockito.when(studentService.addStudents(student)).thenReturn(student);

        mockMvc.perform(MockMvcRequestBuilders.post("http://localhost:8080/api/students/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\r\n" + "\"id\" : 1, \r\n" + "\"name\":\"gaga\", \r\n\"age\": 23, \r\n"
                                + "\"email\":\"gaga@gmail.com\"\r\n}"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }



}
