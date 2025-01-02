package repositories;

import models.Gate;

import java.util.HashMap;
import java.util.Map;

public class GateRepository {
    Map<Long, Gate> gateMap;
    private Long id;

    public GateRepository() {
        gateMap = new HashMap<>();
        id = 0L;
    }

    public Gate save(Gate gate) {
        if (gate.getId() == 0) {
            gateMap.put(++id, gate);
            return gate;
        }
        gateMap.put(gate.getId(), gate);
        return gate;
    }
}
