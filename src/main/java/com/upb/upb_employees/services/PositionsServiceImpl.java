package com.upb.upb_employees.services;

import com.upb.upb_employees.controller.request.PositionsRequest;
import com.upb.upb_employees.controller.response.PositionsResponse;
import com.upb.upb_employees.model.entity.Positions;
import com.upb.upb_employees.model.repository.PositionsRepository;
import com.upb.upb_employees.services.service.PositionsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PositionsServiceImpl implements PositionsService {
    private final PositionsRepository positionsRepository;

    @Override
    public List<Positions> getPositionsList() {
        return positionsRepository.positionsList();
    }

    @Override
    public void deletePositionById(Long positionId) {

    }

    @Override
    public PositionsResponse searchPosition(Long positionId) {
        return null;
    }

    @Override
    public void savePosition(PositionsRequest positionsRequest) {

    }

    @Override
    public void updatePosition(PositionsRequest positionsRequest) {

    }

}
