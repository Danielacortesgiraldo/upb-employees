package com.upb.upb_employees.controller;

import com.upb.upb_employees.model.entity.Departments;
import com.upb.upb_employees.services.service.DepartmentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("departments/v1")
@RequiredArgsConstructor
public class DepartmentsRestController {
    private final DepartmentsService departmentsService;
    String message = "Operation completed successfully.";

    @GetMapping("/list")
    public ResponseEntity<List<Departments>> listDepartmentsApi() {
        List<Departments> departmentsList = departmentsService.getDepartmentsList();
        return new ResponseEntity<>(departmentsList, HttpStatus.ACCEPTED);
    }
}
