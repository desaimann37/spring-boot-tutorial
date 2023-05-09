package com.dailycodebuffer.springboot.tutorial.service;

import com.dailycodebuffer.springboot.tutorial.entity.Department;
import com.dailycodebuffer.springboot.tutorial.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartmentList() {
        return departmentRepository.findAll();
    }

    @Override
    public Optional<Department> getSingleDepartment(long id) {
        return departmentRepository.findById(id);
    }

    @Override
    public void deleteSingleDepartment(long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department updateSingleDepartment(long departmentId , Department department) {

        Department updated_Dept = departmentRepository.findById(departmentId).get();

        if(Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName())){
            updated_Dept.setDepartmentName(department.getDepartmentName());
        }
        if(Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode())){
            updated_Dept.setDepartmentCode(department.getDepartmentCode());
        }
        if(Objects.nonNull(department.getDepartmentAddress()) && !"".equalsIgnoreCase(department.getDepartmentAddress())){
            updated_Dept.setDepartmentAddress(department.getDepartmentAddress());
        }
    return departmentRepository.save(updated_Dept);
    }

    @Override
    public Department getDepartmentByName(String departmentName) {
        return departmentRepository.findByDepartmentName(departmentName);
    }

    @Override
    public Department getDepartmentBtNameUsingQuery(String departmentName) {
        return departmentRepository.getDepartmentByNameUsingQuery(departmentName);
    }




}
