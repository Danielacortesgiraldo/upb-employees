package com.upb.upb_employees.controller.response;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeesResponse {
    public Long employeeId;
    public String firstName;
    public String middleName;
    public String email;
    public DepartmentsResponse departmentsResponse;
    public PositionsResponse positionsResponse;
}
