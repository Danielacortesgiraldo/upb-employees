package com.upb.upb_employees.model.repository;

import com.upb.upb_employees.model.entity.Departments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DepartmentsRepository extends JpaRepository<Departments, Long> {
    @Query(value = "SELECT * FROM departments", nativeQuery = true)
    List<Departments> departmentsList();

    @Query(value = "SELECT * FROM departments WHERE id = :departmentId", nativeQuery = true)
    Departments searchDepartments(@Param("departmentId") Long departmentId);
}
