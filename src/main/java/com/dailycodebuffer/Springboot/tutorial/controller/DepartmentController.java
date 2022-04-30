package com.dailycodebuffer.Springboot.tutorial.controller;

import com.dailycodebuffer.Springboot.tutorial.exception.DepartmentNotFoundException;
import com.dailycodebuffer.Springboot.tutorial.model.Department;
import com.dailycodebuffer.Springboot.tutorial.service.DepartmentServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class DepartmentController {

    private final Logger LOGGER =
            LoggerFactory.getLogger(DepartmentController.class);
    private final DepartmentServiceImpl departmentService;

    public DepartmentController(DepartmentServiceImpl departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department){
        LOGGER.info("Inside saveDepartment of DepartmentController");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/getAll")
    public List<Department> getAll(){
        LOGGER.info("Inside getAll of DepartmentController");
        return departmentService.getAll();
    }

    @GetMapping("/getById/{id}")
    public Optional<Department> getById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
        return departmentService.findById(departmentId);
    }

    @DeleteMapping("deleteById/{id}")
    public String deleteById(@PathVariable("id") Long departmentId){
        departmentService.deleteDepartmentById(departmentId);
        return "Department deleted successfully";
    }

    @PutMapping("updateById/{id}")
    public Department updateById(@PathVariable("id") Long id,@RequestBody Department department){
        return departmentService.updateDataById(id,department);
    }

    @GetMapping("getByName/{name}")
    public Department getByName(@PathVariable("name") String name){
        return departmentService.findByName(name);
    }
}
