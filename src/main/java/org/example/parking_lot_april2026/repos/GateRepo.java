package org.example.parking_lot_april2026.repos;

import org.example.parking_lot_april2026.models.Gate;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class GateRepo {
    private Map<Long,Gate> gateMap = new TreeMap<>();

    public GateRepo() {
        Gate gate = new Gate();
        gate.setId(1L);
        gateMap.put(1L,gate);
    }

    public Optional<Gate> findGateById(Long id) {
        if(gateMap.containsKey(id)) {
            Gate gate = gateMap.get(id);
            return Optional.of(gate);
        }

        return Optional.empty();
    }
}
