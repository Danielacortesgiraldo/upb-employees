package com.upb.upb_employees.controller.response;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeesResponse {
    private Long employeeId;
    private String firstName;
    private String middleName;
    private String email;
    private DepartmentsResponse departmentsResponse;
    private PositionsResponse positionsResponse;
}
