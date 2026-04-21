package org.example.parking_lot_april2026.repos;

import org.example.parking_lot_april2026.models.Gate;
import org.example.parking_lot_april2026.models.ParkingSlot;
import org.example.parking_lot_april2026.models.ParkingSlotStatus;
import org.example.parking_lot_april2026.models.VehicleType;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class ParkingSlotRepo {
    private Map<Long, ParkingSlot> parkingSlotMap = new TreeMap<>();

    public ParkingSlotRepo() {
        ParkingSlot parkingSlot = new ParkingSlot();
        parkingSlot.setId(1L);
        parkingSlot.setParkingSlotStatus(ParkingSlotStatus.EMPTY);
        parkingSlot.setVehicleType(VehicleType.TWO_WHEELER);
        parkingSlot.setParkingSlotNumber("2B");
        parkingSlotMap.put(1L,parkingSlot);
    }

    public Optional<ParkingSlot> findParkingSlotById(Long id) {
        ParkingSlot parkingSlot = parkingSlotMap.getOrDefault(id,null);
        return Optional.ofNullable(parkingSlot);
    }
}
