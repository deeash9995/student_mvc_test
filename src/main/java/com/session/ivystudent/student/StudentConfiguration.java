package com.session.ivystudent.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class StudentConfiguration {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository){

        return args -> {
                  Student deepika =  new Student(1, "Deepika", 27, "deepika@gmail.com");
                  Student samu = new Student(2, "Samu", 27, "samu@gmail.com");
                  studentRepository.saveAll(List.of(deepika,samu));
        };

    }

}
