package com.upb.upb_employees.model.repository;

import com.upb.upb_employees.model.entity.Positions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PositionsRepository extends JpaRepository<Positions, Long> {
    @Query(value = "SELECT * FROM positions", nativeQuery = true)
    List<Positions> positionsList();

    @Query(value = "SELECT * FROM positions WHERE id = :positionId")
    Positions searchPositions(@Param("positionId") Long positionId);
}
