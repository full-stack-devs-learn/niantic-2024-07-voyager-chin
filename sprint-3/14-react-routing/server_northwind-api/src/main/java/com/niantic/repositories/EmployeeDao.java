package com.niantic.repositories;

import com.niantic.models.Employee;

import java.util.List;

public interface EmployeeDao
{
    List<Employee> getAllEmployees();

    Employee getEmployeeById(int id);

    Employee addEmployee(Employee employee);

    void updateEmployee(int id, Employee employee);

    void deleteEmployee(int id);
}
