package com.dailycodebuffer.springboot.tutorial.Controller;

import com.dailycodebuffer.springboot.tutorial.entity.Department;
import com.dailycodebuffer.springboot.tutorial.service.DepartmentService;
import com.dailycodebuffer.springboot.tutorial.service.DepartmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/departments")
    public Department saveDepartment(@RequestBody Department department){

        return departmentService.saveDepartment(department);

    }
    @GetMapping("/departments")
    public List<Department> fetchDepartmentList(){
        return departmentService.fetchDepartmentList();
    }
    @GetMapping("/departments/{id}")
    public Optional<Department> getSingleDepartment(@PathVariable("id") long departmentId){
        return departmentService.getSingleDepartment(departmentId);
    }
    @DeleteMapping("departments/delete/{id}")
    public String deleteSingleDepartment(@PathVariable("id") long departmentId){
        departmentService.deleteSingleDepartment(departmentId);
        return "Department is deleted Successfully with dept_id : " + Long.toString(departmentId);
    }
    @PutMapping("departments/update/{id}")
    public Department updateSingleDepartment(@PathVariable("id")long departmentId , @RequestBody Department department){

        return departmentService.updateSingleDepartment(departmentId , department);
    }
    @GetMapping("departments/deptname/{dept_name}")
    public Department getDepartmentByName(@PathVariable("dept_name")String departmentName){

        return departmentService.getDepartmentByName(departmentName);
    }
    @GetMapping("departments/deptname_usingQuery/{dept_name}")
    public Department getDepartmentBtNameUsingQuery(@PathVariable("dept_name") String departmentName){
        return departmentService.getDepartmentBtNameUsingQuery(departmentName);
    }



}
