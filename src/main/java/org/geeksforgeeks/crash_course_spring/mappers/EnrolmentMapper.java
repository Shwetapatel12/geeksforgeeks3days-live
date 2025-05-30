package org.geeksforgeeks.crash_course_spring.mappers;

import org.geeksforgeeks.crash_course_spring.Entity.Enrolment;
import org.geeksforgeeks.crash_course_spring.dto.EnrolmentDto;
import org.geeksforgeeks.crash_course_spring.Entity.Course;
import org.geeksforgeeks.crash_course_spring.Entity.Student;
import org.geeksforgeeks.crash_course_spring.exceptionhandling.NotFoundException;
import org.geeksforgeeks.crash_course_spring.Repository.CourseRepository;
import org.geeksforgeeks.crash_course_spring.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EnrolmentMapper {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    @Autowired
    public EnrolmentMapper(StudentRepository studentRepository, CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    public Enrolment mapToModel(EnrolmentDto dto) {
        Student student = this.studentRepository.findById(dto.getStudentId())
                .orElseThrow(() -> new NotFoundException("Student with ID: " + dto.getStudentId() + " doesn't exist"));
        Course course = this.courseRepository.findById(dto.getCourseId())
                .orElseThrow(() -> new NotFoundException("Course with ID: " + dto.getCourseId() + " doesn't exist"));
        Enrolment enrolment = new Enrolment();
        enrolment.setCourse(course);
        enrolment.setStudent(student);
        enrolment.setEnrolmentDate(dto.getEnrolmentDate());
        enrolment.setStatus(dto.getStatus());
        return enrolment;

    }
}