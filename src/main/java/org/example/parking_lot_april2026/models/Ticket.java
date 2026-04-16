package org.example.parking_lot_april2026.models;

import java.util.Date;

public class Ticket extends BaseModel {
    private Date entryTime;
    private Gate entryGate;
    private Operator operator;
    private ParkingSlot parkingSlot;
    private Vehicle vehicle;

    //commission_per_ticket for explaining Dto

    public Date getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    public Gate getEntryGate() {
        return entryGate;
    }

    public void setEntryGate(Gate gate) {
        this.entryGate = gate;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public ParkingSlot getParkingSlot() {
        return parkingSlot;
    }

    public void setParkingSlot(ParkingSlot parkingSlot) {
        this.parkingSlot = parkingSlot;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
