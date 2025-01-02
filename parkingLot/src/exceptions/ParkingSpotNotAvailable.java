package exceptions;

public class ParkingSpotNotAvailable extends RuntimeException {
    public ParkingSpotNotAvailable(String message) {
        super(message);
    }
}
