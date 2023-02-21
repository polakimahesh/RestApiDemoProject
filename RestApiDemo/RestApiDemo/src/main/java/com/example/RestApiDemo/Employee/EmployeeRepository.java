package com.example.RestApiDemo.Employee;

import com.example.RestApiDemo.Department.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    List<Employee> findByDepartment_Name(String name);

    List<Employee> findByAge(int age);



}
