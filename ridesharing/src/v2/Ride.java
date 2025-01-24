package v2;

enum RideStatus{
    SCHEDULED, ONGOING, COMPLETED;
}

public class Ride {
    private Driver driver;
    private Passenger passenger;
    private double distance;
    private FareStrategy fareStrategy;
    private double fare;
    
    private RideStatus rideStatus;

    public Ride(Passenger passenger, Driver driver, double distance, FareStrategy fareStrategy){
        this.passenger = passenger;
        this.driver = driver;
        this.distance = distance;
        this.fareStrategy = fareStrategy;
        this.rideStatus = RideStatus.SCHEDULED;
    }
    public double getFare(){
        return this.fare;
    }
    public void updateStatus(RideStatus status){
        this.rideStatus = status;
        notifyUsers(status);
    }
    public void calculateFare(){
        this.fare =  fareStrategy.calculateFare(driver.getVehicle(), distance);
    }
    private void notifyUsers(RideStatus status){
        passenger.notify("Your ride is "+status);
        driver.notify("Ride status "+status);
    }
}
