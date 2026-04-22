package org.example.parking_lot_april2026.repos;

import org.example.parking_lot_april2026.models.ParkingSlot;
import org.example.parking_lot_april2026.models.ParkingSlotStatus;
import org.example.parking_lot_april2026.models.VehicleType;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class ParkingSlotRepo {
    private Map<Long, ParkingSlot> parkingSlotMap = new TreeMap<>();

    public ParkingSlotRepo() {
        ParkingSlot parkingSlot =new ParkingSlot();
        parkingSlot.setId(1L);
        parkingSlot.setParkingSlotNumber("2B");
        parkingSlot.setParkingSlotStatus(ParkingSlotStatus.EMPTY);
        parkingSlot.setVehicleType(VehicleType.TWO_WHEELER);
        parkingSlotMap.put(1L,parkingSlot);
    }

    public Optional<ParkingSlot> getParkingSlotById(Long id) {
        if(parkingSlotMap.containsKey(id)) {
            return Optional.of(parkingSlotMap.get(id));
        }

        return Optional.empty();
    }
}
