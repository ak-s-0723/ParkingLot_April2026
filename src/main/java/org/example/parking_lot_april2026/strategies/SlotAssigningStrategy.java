package org.example.parking_lot_april2026.strategies;

import org.example.parking_lot_april2026.models.ParkingLot;
import org.example.parking_lot_april2026.models.ParkingSlot;
import org.example.parking_lot_april2026.models.VehicleType;

public interface SlotAssigningStrategy {

    ParkingSlot assignSlot(ParkingLot parkingLot, VehicleType vehicleType);
}
