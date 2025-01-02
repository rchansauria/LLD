package models;

import java.util.List;

public class ParkingLot extends BaseModel{

    private List<ParkingFloor> parkingFloors;
    private List<Gate> gates;
    List<VehicleType> supportedVehicleTypes;
    private FeeCalculationStrategy feeCalculationStrategy;
    private ParkingSpotAssignmentStrategy parkingSpotAssignmentStrategy;

    public List<ParkingFloor> getParkingFloors() {
        return parkingFloors;
    }

    public void setParkingFloors(List<ParkingFloor> parkingFloors) {
        this.parkingFloors = parkingFloors;
    }

    public List<Gate> getGates() {
        return gates;
    }

    public void setGates(List<Gate> gates) {
        this.gates = gates;
    }

    public List<VehicleType> getSupportedVehicleTypes() {
        return supportedVehicleTypes;
    }

    public void setSupportedVehicleTypes(List<VehicleType> supportedVehicleTypes) {
        this.supportedVehicleTypes = supportedVehicleTypes;
    }

    public FeeCalculationStrategy getFeeCalculationStrategy() {
        return feeCalculationStrategy;
    }

    public void setFeeCalculationStrategy(FeeCalculationStrategy feeCalculationStrategy) {
        this.feeCalculationStrategy = feeCalculationStrategy;
    }

    public ParkingSpotAssignmentStrategy getParkingSpotAssignmentStrategy() {
        return parkingSpotAssignmentStrategy;
    }

    public void setParkingSpotAssignmentStrategy(ParkingSpotAssignmentStrategy parkingSpotAssignmentStrategy) {
        this.parkingSpotAssignmentStrategy = parkingSpotAssignmentStrategy;
    }
}
