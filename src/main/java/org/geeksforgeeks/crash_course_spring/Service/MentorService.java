package org.geeksforgeeks.crash_course_spring.Service;

import org.geeksforgeeks.crash_course_spring.Entity.Mentor;
import org.geeksforgeeks.crash_course_spring.Repository.MentorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MentorService {
    private final MentorRepository mentorRepository;

    @Autowired
    public MentorService(MentorRepository mentorRepository){
        this.mentorRepository = mentorRepository;
    }

    public Mentor addMentor(Mentor mentor) {
        return this.mentorRepository.save(mentor);
    }

}
