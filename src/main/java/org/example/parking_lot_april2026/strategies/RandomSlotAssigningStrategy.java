package org.example.parking_lot_april2026.strategies;

import org.example.parking_lot_april2026.models.*;

public class RandomSlotAssigningStrategy implements SlotAssigningStrategy {
    @Override
    public ParkingSlot assignSlot(ParkingLot parkingLot, VehicleType vehicleType) {
        for(ParkingFloor parkingFloor : parkingLot.getParkingFloors()) {
            for(ParkingSlot parkingSlot : parkingFloor.getParkingSlots()) {
                if (parkingSlot.getParkingSlotStatus().equals(ParkingSlotStatus.EMPTY) && parkingSlot.getVehicleType().equals(vehicleType)) {
                    return parkingSlot;
                }
            }
        }
        return null;
    }
}

// for enums  == , is more optimized in java
// Parking Lot : all the floors           // we are not sure, how floors are stored in list , whether in sequential order
    // for a floor -> all the slots
        // if slot is empty and it supports vehicle type
            // return slot