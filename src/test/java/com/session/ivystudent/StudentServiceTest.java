package com.session.ivystudent;

import com.session.ivystudent.student.Student;
import com.session.ivystudent.student.StudentRepository;
import com.session.ivystudent.student.StudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

@SpringBootTest
public class StudentServiceTest {
    @Autowired
    StudentService studentService;

    @MockBean
    private StudentRepository studentRepository;

    @BeforeEach
    void setup() {
        Optional<Student> student = Optional.of(new Student(1, "Ram", 17, "ram@gmail.com"));
        Mockito.when(studentRepository.findById(1)).thenReturn(student);
    }

    @Test
    public void testGetStudentById() {
        String studentName = "Ram";
        Student studentById = studentService.getStudentById(1);
        Assertions.assertEquals(studentById.getName(), studentName);
    }

}
