package org.geeksforgeeks.crash_course_spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    @GetMapping("/add-two-numbers")
    public int add_two_number(@RequestParam int a,
                              @RequestParam int b){
        return a + b;
    }

    @GetMapping("/mul-two-numbers")
    public int mul_two_number(
            @RequestParam int a,
            @RequestParam int b
    ){
        return a*b;
    }
}
