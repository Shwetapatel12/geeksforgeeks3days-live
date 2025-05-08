package org.geeksforgeeks.crash_course_spring.Repository;

import org.geeksforgeeks.crash_course_spring.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
