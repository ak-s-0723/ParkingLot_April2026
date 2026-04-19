package org.example.parking_lot_april2026.strategies;

import org.example.parking_lot_april2026.models.SlotAssigningStrategyType;

public class SlotAssignmentStrategyFactory {
    public static SlotAssigningStrategy getSlotAssigningStrategyByType(SlotAssigningStrategyType slotAssigningStrategyType) {
        if(slotAssigningStrategyType.equals(SlotAssigningStrategyType.NEAREST)){
            return new NearestSlotAssigningStrategy();
        } else if(slotAssigningStrategyType.equals(SlotAssigningStrategyType.RANDOM)) {
            return new RandomSlotAssigningStrategy();
        }

        return null;
    }
}
