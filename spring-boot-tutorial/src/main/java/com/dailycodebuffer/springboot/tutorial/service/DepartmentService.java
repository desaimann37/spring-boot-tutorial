package com.dailycodebuffer.springboot.tutorial.service;

import com.dailycodebuffer.springboot.tutorial.entity.Department;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {
    Department saveDepartment(Department department);

    List<Department> fetchDepartmentList();

    Optional<Department> getSingleDepartment(long id);

    void deleteSingleDepartment(long departmentId);

    Department updateSingleDepartment(long departmentId , Department department);

    Department getDepartmentByName(String departmentName);

    Department getDepartmentBtNameUsingQuery(String departmentName);


}
