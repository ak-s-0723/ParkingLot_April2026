package org.example.parking_lot_april2026.repos;

import org.example.parking_lot_april2026.models.Vehicle;

import java.util.Optional;

public class VehicleRepo {

    public Optional<Vehicle> getVehicleByVehicleNumber(String vehicleNumber){
        return Optional.empty();
    }

    public Vehicle save(Vehicle vehicle) {
        //Add body here
      return vehicle;
    }
}
