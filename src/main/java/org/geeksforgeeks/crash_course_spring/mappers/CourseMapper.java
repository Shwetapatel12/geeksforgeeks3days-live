package org.geeksforgeeks.crash_course_spring.mappers;

import org.geeksforgeeks.crash_course_spring.dto.CourseDto;
import org.geeksforgeeks.crash_course_spring.Entity.Course;
import org.geeksforgeeks.crash_course_spring.Entity.Mentor;
import org.geeksforgeeks.crash_course_spring.exceptionhandling.NotFoundException;
import org.geeksforgeeks.crash_course_spring.Repository.CourseRepository;
import org.geeksforgeeks.crash_course_spring.Repository.MentorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CourseMapper {

    private final MentorRepository mentorRepository;

    @Autowired
    public CourseMapper(MentorRepository mentorRepository) {
        this.mentorRepository = mentorRepository;
    }

    public Course mapToModel(CourseDto dto) {
        Course course = new Course();
        Mentor mentor = this.mentorRepository.findById(dto.getMentorId()).orElseThrow(() ->  new NotFoundException("Cannot find mentor with ID: " + dto.getMentorId()));
        course.setName(dto.getName());
        course.setPrice(dto.getPrice());
        course.setCapacity(dto.getCapacity());
        course.setNoOfDays(dto.getNoOfDays());
        course.setStartDate(dto.getStartDate());
        course.setDescription(dto.getDescription());
        course.setMentor(mentor);
        course.setEnrolmentEndDate(dto.getEnrolmentEndDate());
        return course;
    }
}