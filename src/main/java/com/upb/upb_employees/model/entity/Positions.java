package com.upb.upb_employees.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "positions")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Positions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long positionId;

    @Column(name = "position_name", nullable = false)
    private String positionName;
}