package com.upb.upb_employees.controller;

import com.upb.upb_employees.controller.request.EmployeesRequest;
import com.upb.upb_employees.controller.response.EmployeesResponse;
import com.upb.upb_employees.model.entity.Employees;
import com.upb.upb_employees.services.service.EmployeesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("employees/v1")
@RequiredArgsConstructor
public class EmployeesRestController {
    private final EmployeesService employeesService;
    String message = "Operation completed successfully.";

    @GetMapping("/list")
    public  ResponseEntity<List<Employees>> listEmployeesApi() {
        List<Employees> employeesList = employeesService.getEmployeesList();
        return new ResponseEntity<>(employeesList, HttpStatus.ACCEPTED);
    }

    @GetMapping("/search/{employeeId}")
    public ResponseEntity<EmployeesResponse> searchEmployeeApi(@PathVariable Long employeeId) {
        EmployeesResponse employeesResponse = employeesService.searchEmployee(employeeId);
        return ResponseEntity.accepted().body(employeesResponse);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteEmployeeById(@RequestParam(name = "employeeId") Long employeeId) {
        employeesService.deleteEmployeeById(employeeId);
        return ResponseEntity.accepted().body(message);
    }

    @PostMapping("/save")
    public  ResponseEntity<String> saveEmployeeApi(@RequestBody EmployeesRequest employeesRequest) {
        employeesService.saveEmployee(employeesRequest);
        return ResponseEntity.accepted().body(message);
    }

    @PostMapping("/update")
    public ResponseEntity<String> updateEmployeeApi(@RequestBody EmployeesRequest employeesRequest) {
        employeesService.updateEmployee(employeesRequest);
        return ResponseEntity.accepted().body(message);
    }
}
