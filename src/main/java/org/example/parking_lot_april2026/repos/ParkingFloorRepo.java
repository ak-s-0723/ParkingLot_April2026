package org.example.parking_lot_april2026.repos;

import org.example.parking_lot_april2026.models.ParkingFloor;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class ParkingFloorRepo {
    private Map<Long,ParkingFloor> parkingFloorMap = new TreeMap<>();
    public ParkingFloorRepo() {
        ParkingFloor parkingFloor =new ParkingFloor();
        parkingFloor.setId(1L);
        parkingFloorMap.put(1L,parkingFloor);
    }

    public Optional<ParkingFloor> getParkingFloorById(Long id) {
        if(parkingFloorMap.containsKey(id)){
            return Optional.of(parkingFloorMap.get(id));
        }

        return Optional.empty();
    }


}
