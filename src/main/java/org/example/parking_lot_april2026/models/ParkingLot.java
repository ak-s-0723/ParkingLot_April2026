package org.example.parking_lot_april2026.models;

import java.util.List;

public class ParkingLot extends BaseModel {
    private List<ParkingFloor> parkingFloors;

    private List<Gate> entryGates;

    private List<Gate> exitGates;

    private ParkingLotStatus parkingLotStatus;

    private String address;

    private List<SupportedVehicleTypes> supportedVehicleTypes;

    public List<ParkingFloor> getParkingFloors() {
        return parkingFloors;
    }

    public void setParkingFloors(List<ParkingFloor> parkingFloors) {
        this.parkingFloors = parkingFloors;
    }

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

    public List<SupportedVehicleTypes> getSupportedVehicleTypes() {
        return supportedVehicleTypes;
    }

    public void setSupportedVehicleTypes(List<SupportedVehicleTypes> supportedVehicleTypes) {
        this.supportedVehicleTypes = supportedVehicleTypes;
    }
}


// For creating controllers, you should look at functionalities
// one of the functionality is issue Ticket - which model will be in focus
// on which CRUD operations is going to happen ? -  Ticket (creation)
// so can we say, main focus will be to have an object of ticket - so we
// can have a controller with name TicketController


// Lets assume we are going to add functionality of addingFloor, then which model
// will be in focus ? -> so the model for which API is, you can have controller with
// that name - FloorController