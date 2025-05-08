package com.upb.upb_employees.services.service;

import com.upb.upb_employees.controller.request.DepartmentsRequest;
import com.upb.upb_employees.controller.response.DepartmentsResponse;
import com.upb.upb_employees.model.entity.Departments;

import java.util.List;

public interface DepartmentsService {
    List<Departments> getDepartmentsList();
    void deleteDepartmentById(Long departmentId);
    DepartmentsResponse searchDepartment(Long departmentId);
    void saveDepartment(DepartmentsRequest departmentsRequest);
    void updateDepartment(DepartmentsRequest departmentsRequest);
}
