package com.upb.upb_employees.services.service;

import com.upb.upb_employees.controller.request.PositionsRequest;
import com.upb.upb_employees.controller.response.PositionsResponse;
import com.upb.upb_employees.model.entity.Positions;

import java.util.List;

public interface PositionsService {
    List<Positions> getPositionsList();
    void deletePositionById(Long positionId);
    PositionsResponse searchPosition(Long positionId);
    void savePosition(PositionsRequest positionsRequest);
    void updatePosition(PositionsRequest positionsRequest);
}
