package org.example.parking_lot_april2026.models;

public class SupportedVehicleTypes {
    private VehicleType vehicleType;
    private int capacity;

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
