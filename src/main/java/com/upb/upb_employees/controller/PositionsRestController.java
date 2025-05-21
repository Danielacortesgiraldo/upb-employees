package com.upb.upb_employees.controller;

import com.upb.upb_employees.model.entity.Departments;
import com.upb.upb_employees.model.entity.Positions;
import com.upb.upb_employees.services.service.PositionsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("positions/v1")
@RequiredArgsConstructor
public class PositionsRestController {
    private final PositionsService positionsService;

    @GetMapping("list")
    public ResponseEntity<List<Positions>> listPositionsApi() {
        List<Positions> positionsList = positionsService.getPositionsList();
        return new ResponseEntity<>(positionsList, HttpStatus.ACCEPTED);
    }
}
