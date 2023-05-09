package com.dailycodebuffer.springboot.tutorial.repository;

import com.dailycodebuffer.springboot.tutorial.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    public Department findByDepartmentName(String departmentName);

    @Query(value = "select * from department_table where department_name = ?1" , nativeQuery = true)
    public Department getDepartmentByNameUsingQuery(String departmentName);



}
