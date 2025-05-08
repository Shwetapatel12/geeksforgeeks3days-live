package org.geeksforgeeks.crash_course_spring.Service;

import org.geeksforgeeks.crash_course_spring.Entity.Student;
import org.geeksforgeeks.crash_course_spring.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student addStudent(Student student) {
        return this.studentRepository.save(student);
    }

    public Student getStudnetById(long studentId){
        Optional<Student> optionalValue =  this.studentRepository.findById(studentId);
        if (optionalValue.isPresent()) {
            return optionalValue.get();
        }
        return null;
    }

    public Student updatedStudent(Student student) {
        Student existingStudent = this.getStudnetById(student.getId());
        if(existingStudent == null) {
            return null;
        }
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        return this.studentRepository.save(existingStudent);
    }

    public void deleteStudentById(long studentId) {
        this.studentRepository.deleteById(studentId);
    }

}
