package com.upb.upb_employees.controller.request;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeesRequest {
    private Long employeeId;
    private String firstName;
    private String middleName;
    private String email;
    private Long fkDepartmentId;
    private Long fkPositionId;
}
