package org.geeksforgeeks.crash_course_spring.controller;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.geeksforgeeks.crash_course_spring.Entity.Mentor;
import org.geeksforgeeks.crash_course_spring.Service.MentorService;
import org.geeksforgeeks.crash_course_spring.exceptionhandling.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/mentor")
@Getter
@Setter
public class MentorController {

    private final MentorService mentorService;


    public MentorController(MentorService mentorService){
        this.mentorService = mentorService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addMentor(@RequestBody @Valid Mentor mentor) {
        try {
            return new ResponseEntity<>(this.mentorService.addMentor(mentor), HttpStatus.CREATED);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(Map.of("message", e.getMessage()), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(Map.of("error", e.getMessage()));
        }
    }
}
