package org.example.parking_lot_april2026.repos;

import org.example.parking_lot_april2026.models.Vehicle;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class VehicleRepo {
    private Map<String,Vehicle> vehicleMap = new TreeMap<>();

    private static Long counter = 0L;

    public Optional<Vehicle> getVehicleByVehicleNumber(String vehicleNumber){
        if(vehicleMap.containsKey(vehicleNumber)) {
            Vehicle vehicle = vehicleMap.get(vehicleNumber);
            return Optional.of(vehicle);
        }
        return Optional.empty();
    }

    public Vehicle save(Vehicle vehicle) {
       counter++;
       vehicle.setId(counter);
       vehicleMap.put(vehicle.getVehicleNumber(), vehicle);
      return vehicle;
    }
}
