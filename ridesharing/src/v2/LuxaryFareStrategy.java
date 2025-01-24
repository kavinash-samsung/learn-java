package v2;

public class LuxaryFareStrategy implements FareStrategy {
    public double calculateFare(Vehicle vehicle, double distance){
        return vehicle.getFarePerKilometer()*distance*1.5;
    }
}
