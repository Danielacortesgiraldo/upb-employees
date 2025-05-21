package com.upb.upb_employees.services;

import com.upb.upb_employees.controller.request.DepartmentsRequest;
import com.upb.upb_employees.controller.response.DepartmentsResponse;
import com.upb.upb_employees.model.entity.Departments;
import com.upb.upb_employees.model.repository.DepartmentsRepository;
import com.upb.upb_employees.services.service.DepartmentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DepartmentsServiceImpl implements DepartmentsService {
    private final DepartmentsRepository departmentsRepository;

    @Override
    public List<Departments> getDepartmentsList() {
        return departmentsRepository.departmentsList();
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentsRepository.deleteById(departmentId);
    }

    @Override
    public DepartmentsResponse searchDepartment(Long departmentId) {
        Departments departments = departmentsRepository.searchDepartments(departmentId);

        return Objects.nonNull(departments)
                ? buildDepartmentsResponse(departments)
                : DepartmentsResponse.builder().build();
    }

    @Override
    public void saveDepartment(DepartmentsRequest departmentsRequest) {
        if (Objects.nonNull(departmentsRequest)) {
            Departments departments = buildDepartmentsEntity(departmentsRequest);
            departmentsRepository.save(departments);
        }
    }
    @Override
    public void updateDepartment(DepartmentsRequest departmentsRequest) {
        if (Objects.nonNull(departmentsRequest)) {
            Optional<Departments> departments = departmentsRepository.findById(departmentsRequest.getDepartmentId());
            if (departments.isPresent()) {
                Departments updateDepartments = buildDepartmentsEntity(departmentsRequest);
                departmentsRepository.save(updateDepartments);
            }
        }
    }

    private static DepartmentsResponse buildDepartmentsResponse(Departments departments) {
        return DepartmentsResponse.builder()
                .departmentId(departments.getDepartmentId())
                .departmentName(departments.getDepartmentName())
                .build();
    }

    private static Departments buildDepartmentsEntity(DepartmentsRequest departmentsRequest) {
        return Departments.builder()
                .departmentId(departmentsRequest.getDepartmentId())
                .departmentName(departmentsRequest.getDepartmentName())
                .build();
    }
}
