package org.example.parking_lot_april2026.repos;

import org.example.parking_lot_april2026.models.*;
import org.springframework.util.AutoPopulatingList;

import java.util.*;

public class GateRepo {
    private Map<Long,Gate> gateMap = new TreeMap<>();

    public GateRepo() {
        // create some demo gates and save in tree map
        ParkingSlot parkingSlot = new ParkingSlot();
        parkingSlot.setId(1L);
        parkingSlot.setParkingSlotStatus(ParkingSlotStatus.EMPTY);
        parkingSlot.setVehicleType(VehicleType.TWO_WHEELER);
        List<ParkingSlot> parkingSlots = new ArrayList<>();
        parkingSlots.add(parkingSlot);
        ParkingLot parkingLot =  new ParkingLot();
        parkingLot.setId(1L);
        ParkingFloor parkingFloor = new ParkingFloor();
        parkingFloor.setId(1L);
        parkingFloor.setParkingSlots(parkingSlots);
        List<ParkingFloor> parkingFloorList =new ArrayList<>();
        parkingFloorList.add(parkingFloor);
        parkingLot.setParkingFloors(parkingFloorList);
        parkingLot.setSlotAssigningStrategy(SlotAssigningStrategyType.RANDOM);
        Gate gate = new Gate();
        gate.setId(1L);
        gate.setParkingLot(parkingLot);
        gate.setGateStatus(GateStatus.OPEN);
        gate.setCreatedAt(new Date());
        gateMap.put(1L,gate);
    }

    public Optional<Gate> findGateById(Long id) {
        Gate gate = gateMap.getOrDefault(id,null);
        return Optional.ofNullable(gate);
    }

    //You might not find a gate with id, so in that case best way is to return
    //optional<Gate> instead of null object.

    //If you will return null from here, we can say the calling party might or might
    //not check for null, but as a developer my duty to void nulls or have proper and
    //safe checks for these.


}

// now we need to mock db
//which ds is very close to db  ?
// map -> TreeMap (because data is sorted by Ids in DB and we want same here
