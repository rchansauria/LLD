package services;

import exceptions.GateNotFoundException;
import exceptions.ParkingSpotNotAvailable;
import factories.SpotAssignmentStrategyFactory;
import models.*;
import repositories.GateRepository;
import repositories.ParkingLotRepository;
import repositories.TicketRepository;
import repositories.VehicleRepository;
import strategy.spotAssignmentStrategy.SpotAssignmentStrategy;

import java.util.Optional;

public class TicketService {

    private GateRepository gateRepository;
    private VehicleRepository vehicleRepository;
    private ParkingLotRepository parkingLotRepository;
    private TicketRepository ticketRepository;

    public TicketService(GateRepository gateRepository, VehicleRepository vehicleRepository, ParkingLotRepository parkingLotRepository, TicketRepository ticketRepository) {
        this.gateRepository = gateRepository;
        this.vehicleRepository = vehicleRepository;
        this.parkingLotRepository = parkingLotRepository;
        this.ticketRepository = ticketRepository;
    }

    public Ticket issueTicket(Long gateId,
                              VehicleType vehicleType,
                              String vehicleNumber,
                              String ownerName) {
        Ticket ticket = new Ticket();
        ticket.setTicketNumber("123454");
        // Get the gate info
        Optional<Gate> gate = gateRepository.findById(gateId);
        if (gate.isEmpty()) {
            throw new GateNotFoundException("Gate does not exists!!");
        }
        ticket.setGeneratedAt(gate.get());
        // Get the vehicle info
        Optional<Vehicle> vehicle = vehicleRepository.findByNumber(vehicleNumber);
        Vehicle savedVehicle = null;
        if (vehicle.isEmpty()) {
            Vehicle newVehicle = new Vehicle();
            newVehicle.setVehicleNumber(vehicleNumber);
            newVehicle.setOwnerName(ownerName);
            newVehicle.setVehicleType(vehicleType);
            savedVehicle = vehicleRepository.save(newVehicle);
        } else {
            savedVehicle = vehicle.get();
        }

        ticket.setVehicle(savedVehicle);
        // Get the info of parkingLot object to get the assigment strategy
        ParkingLot parkingLot = parkingLotRepository.findByGate(gate.get());
        SpotAssignmentStrategy spotAssignmentStrategy = SpotAssignmentStrategyFactory.getSpotAssignmentStrategyFactory(parkingLot.getParkingSpotAssignmentStrategy());
        ParkingSpot parkingSpot = spotAssignmentStrategy.spotAssignment(vehicleType, gate.get());
        if (parkingSpot.getParkingSpotStatus().equals(ParkingSpotStatus.NOT_AVAILABLE)){
            throw new ParkingSpotNotAvailable("Parking spot not available");
        }
        ticket.setParkingSpot(parkingSpot);

        return ticketRepository.save(ticket);
    }
}
