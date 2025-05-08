package org.geeksforgeeks.crash_course_spring.controller;

import org.geeksforgeeks.crash_course_spring.Entity.Student;
import org.geeksforgeeks.crash_course_spring.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @PostMapping("/student/add")
    public Student addStudent(Student student){
        return this.studentService.addStudent(student);
    }

    @GetMapping("/student/{sID}")
    public Student getStudent(@PathVariable(name = "sId") long studentId){
        return this.studentService.getStudnetById(studentId);
    }
    @PutMapping("/student/{studenId}")
    public Student updateStudent(@PathVariable  long studentId, @RequestBody Student student) {
        if(studentId != student.getId()) {
            // throw some error
        }
        return this.studentService.updatedStudent(student);
    }

    @DeleteMapping("/delete/{studentId}")
    public void deleteStudent(long studentId){
        this.studentService.deleteStudentById(studentId);
    }
}
