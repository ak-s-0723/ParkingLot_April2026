package org.example.parking_lot_april2026.models;

public class Vehicle extends BaseModel {
    private VehicleType vehicleType;
    private String vehicleNumber;
    private VehicleFuelType vehicleFuelType;

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public VehicleFuelType getVehicleFuelType() {
        return vehicleFuelType;
    }

    public void setVehicleFuelType(VehicleFuelType vehicleFuelType) {
        this.vehicleFuelType = vehicleFuelType;
    }
}
