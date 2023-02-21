package com.example.RestApiDemo.Department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Department> getAllDepartments(){
        return  departmentRepository.findAll();
    }

    public Department saveDepartment(DepartmentDTO departmentDTO){
        var department = new Department();
        department.setName(departmentDTO.getName());
        department=departmentRepository.save(department);
        return  department;
    }
}
