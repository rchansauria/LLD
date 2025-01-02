package strategy.spotAssignmentStrategy;

import models.Gate;
import models.ParkingSpot;
import models.VehicleType;

public interface SpotAssignmentStrategy {

    ParkingSpot spotAssignment(VehicleType vehicleType, Gate gate);
}
