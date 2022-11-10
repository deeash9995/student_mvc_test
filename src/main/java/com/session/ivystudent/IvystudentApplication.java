package com.session.ivystudent;

import com.session.ivystudent.student.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
public class IvystudentApplication {

	public static void main(String[] args) {

		ApplicationContext apc = SpringApplication.run(IvystudentApplication.class, args);

//		for (String a : apc.getBeanDefinitionNames()) {
//			System.out.println(a);
//		}
	}


}
