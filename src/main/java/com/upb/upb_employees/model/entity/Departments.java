package com.upb.upb_employees.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "departments")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Departments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long departmentId;

    @Column(name = "department_name", nullable = false)
    private String departmentName;
}
