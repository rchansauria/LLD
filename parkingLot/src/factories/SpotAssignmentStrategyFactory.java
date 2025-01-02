package factories;

import models.ParkingSpotAssignmentStrategy;
import strategy.spotAssignmentStrategy.CheapestSpotAssignmentStrategy;
import strategy.spotAssignmentStrategy.RandomSpotAssignmentStrategy;
import strategy.spotAssignmentStrategy.SpotAssignmentStrategy;

public class SpotAssignmentStrategyFactory {

    public static SpotAssignmentStrategy getSpotAssignmentStrategyFactory(ParkingSpotAssignmentStrategy parkingSpotAssignmentStrategy){
        if(parkingSpotAssignmentStrategy.equals(parkingSpotAssignmentStrategy.CHEAPEST)){
            return new CheapestSpotAssignmentStrategy();
        } else if (parkingSpotAssignmentStrategy.equals(parkingSpotAssignmentStrategy.RANDOM)) {
            return new RandomSpotAssignmentStrategy();
        }
        return null;
    }
}
