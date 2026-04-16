package org.example.parking_lot_april2026.models;

public class Vehicle extends BaseModel {
    private String vehicleNumber;
    private VehicleType vehicleType;
    private VehicleFuelType vehicleFuelType;

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public VehicleFuelType getVehicleFuelType() {
        return vehicleFuelType;
    }

    public void setVehicleFuelType(VehicleFuelType vehicleFuelType) {
        this.vehicleFuelType = vehicleFuelType;
    }
}
