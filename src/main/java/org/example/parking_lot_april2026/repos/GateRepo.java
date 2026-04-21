package org.example.parking_lot_april2026.repos;

import org.example.parking_lot_april2026.models.*;
import org.springframework.util.AutoPopulatingList;

import java.util.*;

public class GateRepo {
    private Map<Long,Gate> gateMap = new TreeMap<>();

    public GateRepo() {
        Gate gate = new Gate();
        gate.setId(1L);
        //gate.setGateStatus(GateStatus.OPEN);
        //gate.setCreatedAt(new Date());
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
