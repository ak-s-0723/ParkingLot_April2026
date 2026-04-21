package org.example.parking_lot_april2026.models;

import org.example.parking_lot_april2026.strategies.RandomSlotAssigningStrategy;
import org.example.parking_lot_april2026.strategies.SlotAssigingStrategy;

import java.util.HashMap;
import java.util.List;

public class ParkingLot extends BaseModel {
    private List<Gate> entryGates;
    private List<Gate> exitGates;
    private ParkingLotStatus parkingLotStatus;
    private String address;
    private List<ParkingFloor> parkingFloors;
    private HashMap<VehicleType,Integer> allowedVehicleTypes;

    public SlotAssigingStrategy getSlotAssigingStrategy() {
        //ToDo : Implement factory of strategies and remove this hardcoding
        return new RandomSlotAssigningStrategy();
    }

    public void setSlotAssigingStrategy(SlotAssigingStrategy slotAssigingStrategy) {
        this.slotAssigingStrategy = slotAssigingStrategy;
    }

    private SlotAssigingStrategy slotAssigingStrategy;

    public List<Gate> getEntryGates() {
        return entryGates;
    }

    public void setEntryGates(List<Gate> entryGates) {
        this.entryGates = entryGates;
    }

    public List<Gate> getExitGates() {
        return exitGates;
    }

    public void setExitGates(List<Gate> exitGates) {
        this.exitGates = exitGates;
    }

    public ParkingLotStatus getParkingLotStatus() {
        return parkingLotStatus;
    }

    public void setParkingLotStatus(ParkingLotStatus parkingLotStatus) {
        this.parkingLotStatus = parkingLotStatus;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<ParkingFloor> getParkingFloors() {
        return parkingFloors;
    }

    public void setParkingFloors(List<ParkingFloor> parkingFloors) {
        this.parkingFloors = parkingFloors;
    }

    public HashMap<VehicleType, Integer> getAllowedVehicleTypes() {
        return allowedVehicleTypes;
    }

    public void setAllowedVehicleTypes(HashMap<VehicleType, Integer> allowedVehicleTypes) {
        this.allowedVehicleTypes = allowedVehicleTypes;
    }
}
