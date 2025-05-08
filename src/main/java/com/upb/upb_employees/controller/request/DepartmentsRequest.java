package com.upb.upb_employees.controller.request;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentsRequest {
    private Long departmentId;
    private String departmentName;
}
