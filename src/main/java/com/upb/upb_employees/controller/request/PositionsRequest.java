package com.upb.upb_employees.controller.request;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PositionsRequest {
    private Long positionId;
    private String positionName;
}
