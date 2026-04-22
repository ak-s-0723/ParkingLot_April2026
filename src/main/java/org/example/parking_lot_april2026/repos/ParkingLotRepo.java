package org.example.parking_lot_april2026.repos;

import org.example.parking_lot_april2026.models.ParkingLot;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class ParkingLotRepo {
    private Map<Long,ParkingLot> parkingLotMap = new TreeMap<>();
    public ParkingLotRepo() {
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setId(1L);
        parkingLotMap.put(1L,parkingLot);
    }

    public Optional<ParkingLot> getParkingLotById(Long id) {
        if(parkingLotMap.containsKey(id)) {
            ParkingLot parkingLot = parkingLotMap.get(id);
            return Optional.of(parkingLot);
        }

        return Optional.empty();
    }
}
