package com.upb.upb_employees.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "employees")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employees {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long employeeId;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "middle_name", nullable = false)
    private String middleName;

    @Column(name = "email", nullable = false)
    private String email;

    @ManyToOne
    @JoinColumn(name = "fk_department_id", referencedColumnName = "id", nullable = false)
    private Departments fkDepartmentId;

    @ManyToOne
    @JoinColumn(name = "fk_position_id", referencedColumnName = "id", nullable = false)
    private Positions fkPositionId;
}
