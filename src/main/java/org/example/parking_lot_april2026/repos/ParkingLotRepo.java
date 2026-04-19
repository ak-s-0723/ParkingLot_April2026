package org.example.parking_lot_april2026.repos;

import org.example.parking_lot_april2026.models.Gate;
import org.example.parking_lot_april2026.models.ParkingLot;

import java.util.Optional;

public class ParkingLotRepo {

    Optional<ParkingLot> findByGate(Gate gate) {
        return Optional.empty();
    }
}
