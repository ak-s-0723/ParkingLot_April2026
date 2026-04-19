package org.example.parking_lot_april2026.models;

import java.util.HashMap;
import java.util.List;

public class ParkingFloor extends BaseModel {
    private ParkingFloorStatus parkingFloorStatus;
    private List<ParkingSlot> parkingSlots;
    private HashMap<VehicleType,Integer> allowedVehicleTypes;
    private int parkingFloorNumber;

    public ParkingFloorStatus getParkingFloorStatus() {
        return parkingFloorStatus;
    }

    public void setParkingFloorStatus(ParkingFloorStatus parkingFloorStatus) {
        this.parkingFloorStatus = parkingFloorStatus;
    }

    public List<ParkingSlot> getParkingSlots() {
        return parkingSlots;
    }

    public void setParkingSlots(List<ParkingSlot> parkingSlots) {
        this.parkingSlots = parkingSlots;
    }

    public HashMap<VehicleType, Integer> getAllowedVehicleTypes() {
        return allowedVehicleTypes;
    }

    public void setAllowedVehicleTypes(HashMap<VehicleType, Integer> allowedVehicleTypes) {
        this.allowedVehicleTypes = allowedVehicleTypes;
    }

    public int getParkingFloorNumber() {
        return parkingFloorNumber;
    }

    public void setParkingFloorNumber(int parkingFloorNumber) {
        this.parkingFloorNumber = parkingFloorNumber;
    }


}
