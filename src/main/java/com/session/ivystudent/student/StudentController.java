package com.session.ivystudent.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

//    @GetMapping
//    public Student getStudentById(){
//        return studentService.getStudentById(id);
//    }

    @GetMapping  //Get API to fetch the students
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    @PostMapping("/students/add")
    public void addStudents(@RequestBody  Student student){
        studentService.addStudents(student);
    }

    @DeleteMapping(path = "{studentId}")
    public void removeStudent(@PathVariable("studentId") Integer id){
        studentService.removeStudent(id);
    }

    @PutMapping(path = "{studentId}")
    public void updateStudent(
            @PathVariable("studentId") Integer studentId,
            @RequestParam(required=false) String name,
            @RequestParam(required=false) String email)
    {
        studentService.upadateStudent(studentId, name, email);
    }

}
