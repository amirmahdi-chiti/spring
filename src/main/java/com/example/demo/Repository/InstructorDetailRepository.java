package com.example.demo.Repository;

import com.example.demo.Model.Instructor_detail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorDetailRepository extends JpaRepository<Instructor_detail,Long> {

}
