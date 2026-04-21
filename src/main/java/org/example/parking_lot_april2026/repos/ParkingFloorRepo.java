package org.example.parking_lot_april2026.repos;

import org.example.parking_lot_april2026.models.ParkingFloor;
import org.example.parking_lot_april2026.models.ParkingFloorStatus;
import org.example.parking_lot_april2026.models.ParkingSlot;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class ParkingFloorRepo {
    private Map<Long, ParkingFloor> parkingFloorMap = new TreeMap<>();

    public ParkingFloorRepo() {
        ParkingFloor parkingFloor = new ParkingFloor();
        parkingFloor.setId(1L);
        //parkingFloor.setParkingFloorNumber(1);
        parkingFloorMap.put(1L,parkingFloor);
    }

    public Optional<ParkingFloor> findParkingFloorById(Long id) {
        ParkingFloor parkingFloor = parkingFloorMap.getOrDefault(id,null);
        return Optional.ofNullable(parkingFloor);
    }
}
