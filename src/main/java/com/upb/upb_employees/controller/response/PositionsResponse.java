package com.upb.upb_employees.controller.response;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PositionsResponse {
    public Long positionId;
    public String positionName;
}
