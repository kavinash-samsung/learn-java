package v2;

public class StandardfareStrategy implements FareStrategy{

    @Override
    public double calculateFare(Vehicle vehicle, double distance) {
        return vehicle.getFarePerKilometer()*distance;
    }
    
}
