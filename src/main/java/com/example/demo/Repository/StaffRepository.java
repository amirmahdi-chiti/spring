package com.example.demo.Repository;

import com.example.demo.Model.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Long> {

    @Query("from Staff s where s.firstName = :name")
    List<Staff> getSpeicalStaff(@Param("name") String name);

    @Query("from Staff s where s.email like %:email")
    List<Staff> getSpeicalStaff2(@Param("email") String email);
}
