package com.upb.upb_employees.model.repository;

import com.upb.upb_employees.model.entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeesRepository extends JpaRepository<Employees, Long> {
    @Query(value = "SELECT * FROM employees", nativeQuery = true)
    List<Employees> employeesList();

    @Query(value = "SELECT * FROM employees WHERE id = :employeeId", nativeQuery = true)
    Employees searchEmployees(@Param("employeeId") Long employeeId);
}
