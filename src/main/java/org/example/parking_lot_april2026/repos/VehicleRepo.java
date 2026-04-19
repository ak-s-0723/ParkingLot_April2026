package org.example.parking_lot_april2026.repos;

import org.example.parking_lot_april2026.models.Vehicle;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

//This will be singleton
public class VehicleRepo {
    private Map<Long,Vehicle> vehicleMap = new TreeMap<>();
    private static Long counter = 0L;

    public VehicleRepo() {
    }
    public Optional<Vehicle> findVehicleByNumber(String number) {
        return Optional.empty();
    }

    //The new vehicle object will be updated with id
    public Vehicle save(Vehicle vehicle) {
        counter++;
        vehicle.setId(counter);
        vehicleMap.put(counter,vehicle);
        return vehicle;
    }

    //Please complete VehicleRepo taking reference from GateRepo and TicketRepo
}
