package com.session.ivystudent.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Transient;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public Student getStudentById(Integer id){
        Optional<Student> byId =  studentRepository.findById(id);
        return byId.get();
    }

    public Student addStudents(Student student) {
        Optional<Student> studentByEmail = studentRepository.findByEmail(student.getEmail());

        if(studentByEmail.isPresent()){
            throw new IllegalArgumentException("Email already exists!..");
        }

        studentRepository.save(student);
        return student;
    }

    public void removeStudent(Integer id) {

        boolean exists = studentRepository.existsById(id);

        if(!exists){
            throw new IllegalStateException("Student with id " +id+ " does not exists!");
        }

        studentRepository.deleteById(id);

    }
    @Transactional
    public void upadateStudent(Integer studentId, String name, String email) {

        Student student = studentRepository.findById(studentId).orElseThrow(
                ()-> new IllegalStateException("Student with id \"+studentId+\" does not exists!.."));

        if(name != null && name.length() > 0 && !Objects.equals(student.getName(), name)){
            student.setName(name);
        }

        if(email != null && email.length() > 0 && !Objects.equals(student.getEmail(), email)){
            Optional<Student> studentByEmail = studentRepository.findByEmail(email);
            if(studentByEmail.isPresent()){
                throw new IllegalStateException("Student with email " + email + " is already taken!..");
            }
            student.setEmail(email);
        }
    }
}
