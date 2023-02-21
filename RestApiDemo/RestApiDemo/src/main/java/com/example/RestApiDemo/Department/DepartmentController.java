package com.example.RestApiDemo.Department;

import com.example.RestApiDemo.Employee.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @GetMapping("")
    public ResponseEntity<List<Department>> saveDepartment(){
        return  new ResponseEntity<>(departmentService.getAllDepartments(), HttpStatus.OK);
    }
    @PostMapping("/register-department")
    public ResponseEntity<Department> saveDepartment(@RequestBody DepartmentDTO departmentDTO){
        return new ResponseEntity<>(departmentService.saveDepartment(departmentDTO),HttpStatus.CREATED);
    }
}
