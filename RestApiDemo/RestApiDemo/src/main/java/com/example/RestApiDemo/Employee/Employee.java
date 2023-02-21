package com.example.RestApiDemo.Employee;

import com.example.RestApiDemo.Department.Department;
import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;
    @ManyToOne
    private Department department;

//    public Employee(EmployeeDTO employeeDTO){
//        this.name=employeeDTO.getName();
//        this.age=employeeDTO.getAge();
//    }
}
