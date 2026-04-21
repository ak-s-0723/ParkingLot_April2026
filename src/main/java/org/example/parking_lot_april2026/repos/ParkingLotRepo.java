package org.example.parking_lot_april2026.repos;

import org.example.parking_lot_april2026.models.*;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class ParkingLotRepo {
    private Map<Long,ParkingLot> parkingLotMap = new TreeMap<>();

    public ParkingLotRepo() {
        ParkingLot parkingLot =  new ParkingLot();
        parkingLot.setId(1L);
        //parkingLot.setAddress("SOME ADDRESS");
        parkingLot.setSlotAssigningStrategy(SlotAssigningStrategyType.RANDOM);
        parkingLotMap.put(1L,parkingLot);
    }

    Optional<ParkingLot> findByGate(Gate gate) {
        return Optional.empty();
    }

    public Optional<ParkingLot> findParkingLotById(Long id) {
        ParkingLot parkingLot = parkingLotMap.getOrDefault(id,null);
        return Optional.ofNullable(parkingLot);
    }
}
