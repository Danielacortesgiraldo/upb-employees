package com.upb.upb_employees.controller.response;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentsResponse {
    public Long departmentId;
    public String departmentName;
}
