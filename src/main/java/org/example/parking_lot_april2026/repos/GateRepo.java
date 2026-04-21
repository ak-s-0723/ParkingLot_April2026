package org.example.parking_lot_april2026.repos;

import org.example.parking_lot_april2026.models.Gate;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class GateRepo {
    private Map<Long,Gate> gateMap = new TreeMap<>();

    public GateRepo() {
    }

    public Optional<Gate> findGateById(Long id) {
        //return gateMap.get(id);
        return Optional.empty();
    }
}
