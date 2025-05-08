package com.upb.upb_employees.services.service;

import com.upb.upb_employees.controller.request.EmployeesRequest;
import com.upb.upb_employees.controller.response.EmployeesResponse;
import com.upb.upb_employees.model.entity.Employees;

import java.util.List;

public interface EmployeesService {
    List<Employees> getEmployeesList();
    void deleteEmployeeById(Long employeeId);
    EmployeesResponse searchEmployee(Long employeeId);
    void saveEmployee(EmployeesRequest employeesRequest);
    void updateEmployee(EmployeesRequest employeesRequest);
}
