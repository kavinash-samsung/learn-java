package v2;

public class SharedFareStrategy implements FareStrategy {
    public double calculateFare(Vehicle vehicle, double distance){
        return vehicle.getFarePerKilometer()*distance*0.5;
    }
}
