package com.dailycodebuffer.Springboot.tutorial.service;

import com.dailycodebuffer.Springboot.tutorial.exception.DepartmentNotFoundException;
import com.dailycodebuffer.Springboot.tutorial.model.Department;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {
    Department saveDepartment(Department department);
    List<Department> getAll();
    Optional<Department> findById(Long departmentId) throws DepartmentNotFoundException;
    void deleteDepartmentById(Long departmentId);
    Department updateDataById(Long departmentId,Department department);

    Department findByName(String name);
}
