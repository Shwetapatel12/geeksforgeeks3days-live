package org.geeksforgeeks.crash_course_spring.Service;

import org.geeksforgeeks.crash_course_spring.Entity.Student;
import org.geeksforgeeks.crash_course_spring.exceptionhandling.NotFoundException;
import org.geeksforgeeks.crash_course_spring.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student addStudent(Student student) {
        return this.studentRepository.save(student);
    }

    public Student getStudentById(long studentId) {
        Optional<Student> optionalValue = this.studentRepository.findById(studentId);
        return optionalValue.orElseThrow(() -> new NotFoundException("Student with ID: " + studentId + " was not found."));
    }

    public Student updateStudent(Student student) {
//        Student existingStudent = this.getStudentById(student.getId());
//        existingStudent.getClass(student.getFirstName());
//        existingStudent.setLastName(student.getLastName());
//        return this.studentRepository.save(existingStudent);
        return null;
    }

    public void deleteStudentById(long studentId) {
        this.studentRepository.deleteById(studentId);
    }
}