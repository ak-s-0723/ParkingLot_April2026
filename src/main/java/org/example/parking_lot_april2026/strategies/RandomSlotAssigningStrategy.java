package org.example.parking_lot_april2026.strategies;

import org.example.parking_lot_april2026.models.*;

public class RandomSlotAssigningStrategy implements SlotAssigingStrategy {
    @Override
    public ParkingSlot assignSlot(ParkingLot parkingLot, VehicleType vehicleType) {
        for(ParkingFloor parkingFloor : parkingLot.getParkingFloors()) {
            for(ParkingSlot parkingSlot : parkingFloor.getParkingSlots()) {
                if(parkingSlot.getParkingSlotStatus()
                        .equals(ParkingSlotStatus.EMPTY) &&
                        parkingSlot.getVehicleType().equals(vehicleType)) {
                    return parkingSlot;
                }
            }
        }
        return null;
    }
}
