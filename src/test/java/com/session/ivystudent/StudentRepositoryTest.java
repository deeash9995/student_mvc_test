package com.session.ivystudent;

import com.session.ivystudent.student.Student;
import com.session.ivystudent.student.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setup(){
        entityManager.persist(new Student(1, "gaga", 23, "gaga@gmail.com"));
    }

    @Test
    public void findByIdTest(){
       Student student = studentRepository.findById(1).get();
        Assertions.assertEquals("gaga", student.getName());
    }

}
