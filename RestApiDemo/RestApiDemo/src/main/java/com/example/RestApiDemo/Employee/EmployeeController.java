package com.example.RestApiDemo.Employee;

import org.aspectj.weaver.ast.Var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    //get all the employees
    @GetMapping("/users")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.OK);
    }
    //save the employee
    @PostMapping("/register-employee")
    public ResponseEntity<Employee> saveEmployee(@RequestBody EmployeeDTO employeeDTO){
        return  new ResponseEntity<>(employeeService.saveEmployee(employeeDTO),HttpStatus.CREATED);
    }

    //get the employee with department name
    @GetMapping("/by-departmentName/{name}")
    public ResponseEntity<List<Employee>> getEmployeeByDepartmentName(@PathVariable String name){
        return  new ResponseEntity<>(employeeService.getEmployeeByDepartmentName(name),HttpStatus.OK);
    }

    //get the employee with employee age
    @PostMapping("/get-age")
    public ResponseEntity<Object> getEmployeeAge(@RequestBody EmployeeDTO employeeDTO) {
        var employee = employeeService.getEmployeeAgeResponse(employeeDTO);
        if(Boolean.TRUE.equals(employee.get("isSuccess"))){
            return ResponseEntity.ok(employee.get("message"));
        }else
             return ResponseEntity.badRequest().body(employee.get("message"));
    }
    @PostMapping("/update-employee/{id}")
    public  ResponseEntity<Object> updateEmployee(@RequestBody EmployeeDTO employeeDTO, @PathVariable Long id){
        HashMap<String, Object> employee= employeeService.updateEmployee(employeeDTO,id);

        if(Boolean.TRUE.equals(employee.get("isSuccess"))){
            return ResponseEntity.ok(employee.get("message"));
        }else
            return ResponseEntity.badRequest().body(employee.get("message"));
    }
}
