package com.upb.upb_employees.services;

import com.upb.upb_employees.controller.request.EmployeesRequest;
import com.upb.upb_employees.controller.response.DepartmentsResponse;
import com.upb.upb_employees.controller.response.EmployeesResponse;
import com.upb.upb_employees.controller.response.PositionsResponse;
import com.upb.upb_employees.model.entity.Departments;
import com.upb.upb_employees.model.entity.Employees;
import com.upb.upb_employees.model.entity.Positions;
import com.upb.upb_employees.model.repository.EmployeesRepository;
import com.upb.upb_employees.services.service.EmployeesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeesServiceImpl implements EmployeesService {
    private final EmployeesRepository employeesRepository;

    @Override
    public List<Employees> getEmployeesList() {
        return employeesRepository.employeesList();
    }

    @Override
    public void deleteEmployeeById(Long employeeId) {
        employeesRepository.deleteById(employeeId);
    }

    @Override
    public EmployeesResponse searchEmployee(Long employeeId) {
        Employees employees = employeesRepository.searchEmployees(employeeId);

        return  Objects.nonNull(employees)
                ? buildEmployeesResponse(employees)
                : EmployeesResponse.builder().build();
    }

    @Override
    public void saveEmployee(EmployeesRequest employeesRequest) {
        if(Objects.nonNull(employeesRequest)) {
            Employees employees = buildEmployeesEntity(employeesRequest);
            employeesRepository.save(employees);
        }
    }

    @Override
    public void updateEmployee(EmployeesRequest employeesRequest) {
        if (Objects.nonNull(employeesRequest)) {
            Optional<Employees> employees = employeesRepository.findById(employeesRequest.getEmployeeId());
            if (employees.isPresent()) {
                Employees updateEmployee = buildEmployeesEntity(employeesRequest);
                employeesRepository.save(updateEmployee);
            }
        }
    }

    private static EmployeesResponse buildEmployeesResponse(Employees employees) {
        return  EmployeesResponse.builder()
                .employeeId(employees.getEmployeeId())
                .firstName(employees.getFirstName())
                .middleName(employees.getMiddleName())
                .email(employees.getEmail())
                .departmentsResponse(buildDepartmentsResponse(employees.getFkDepartmentId()))
                .positionsResponse(buildPositionsResponse(employees.getFkPositionId()))
                .build();
    }

    private static Employees buildEmployeesEntity(EmployeesRequest employeesRequest) {
        return Employees.builder()
                .employeeId(employeesRequest.getEmployeeId())
                .firstName(employeesRequest.getFirstName())
                .middleName(employeesRequest.getMiddleName())
                .email(employeesRequest.getEmail())
                .fkDepartmentId(buildDepartmentsEntity(employeesRequest))
                .fkPositionId(buildPositionsEntity(employeesRequest))
                .build();
    }

    private static DepartmentsResponse buildDepartmentsResponse(Departments departments) {
        return DepartmentsResponse.builder()
                .departmentId(departments.getDepartmentId())
                .departmentName(departments.getDepartmentName())
                .build();
    }

    private static Departments buildDepartmentsEntity(EmployeesRequest employeesRequest) {
        return Departments.builder()
                .departmentId(employeesRequest.getFkDepartmentId())
                .build();
    }

    private static PositionsResponse buildPositionsResponse(Positions positions) {
        return PositionsResponse.builder()
                .positionId(positions.getPositionId())
                .positionName(positions.getPositionName())
                .build();
    }

    private static Positions buildPositionsEntity(EmployeesRequest employeesRequest) {
        return Positions.builder()
                .positionId(employeesRequest.getFkPositionId())
                .build();
    }
}
