package com.example.RestApiDemo.Employee;

import com.example.RestApiDemo.Department.Department;
import com.example.RestApiDemo.Department.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee saveEmployee(EmployeeDTO employeeDTO){
        var department=departmentRepository.findById(employeeDTO.getDepartmentId()).orElse(null);
        Employee employee = new Employee();
        employee.setName(employeeDTO.getName());
        employee.setAge(employeeDTO.getAge());
        employee.setDepartment(department);
        employee=employeeRepository.save(employee);
        return employee;
    }

    public List<Employee> getEmployeeByDepartmentName(String name){
        return employeeRepository.findByDepartment_Name(name);
    }

    public HashMap<String,Object> getEmployeeAgeResponse(EmployeeDTO employeeDTO){
        HashMap<String,Object> response = new HashMap<>();
        HashMap<String,Object> response1= new HashMap<>();
        response1.put("message",employeeDTO.getAge()+" is not found");
        var employee =employeeRepository.findByAge(employeeDTO.getAge());
        if(!employee.isEmpty()) {
            response.put("isSuccess", true);
            response.put("message", employee);
            return response;
        }else{
            response.put("isSuccess", false);
            response.put("message",response1);
            return response;
        }
    }

    public HashMap<String,Object> updateEmployee(EmployeeDTO employeeDTO,Long id){
        HashMap<String,Object> response = new HashMap<>();
        HashMap<String,Object> response1= new HashMap<>();
        Employee employee = employeeRepository.findById(id).orElse(null);
         var department = departmentRepository.findById(employeeDTO.getDepartmentId());
         if(employee==null){
             response1.put("message","incorrect employee id "+id+", please enter the valid id!");
             response.put("isSuccess",false);
             response.put("message",response1);
             return response;
         }else {
            employee.setDepartment(department.get());
            employeeRepository.save(employee);
             response.put("isSuccess", true);
             response.put("message", employee);
             return response;
        }
    }


}
