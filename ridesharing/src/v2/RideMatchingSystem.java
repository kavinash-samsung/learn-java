package v2;

import java.util.ArrayList;
import java.util.List;

public class RideMatchingSystem {
    private List<Driver> availableDrivers = new ArrayList<>();

    public void addDriver(Driver driver){
        availableDrivers.add(driver);
    }

    public void requestRide(Passenger passenger, double distance, FareStrategy fareStrategy){
        if(availableDrivers.isEmpty()){
            passenger.notify("No drivers are available");
            return;
        }
        // find nearest driver

        Driver nearestdriver = findNearestDriver(passenger.getLocation());
        
        // remove driver from active list
        availableDrivers.remove(nearestdriver);

        Ride ride = new Ride(passenger, nearestdriver, distance, fareStrategy);
        ride.calculateFare();

        passenger.notify("Ride scheduled with fare "+ride.getFare()+" with driver " + nearestdriver.getName());
        nearestdriver.notify("You have a new ride request for "+ride.getFare()+" with passenger " + passenger.getName());
        // add driver again after ride finished
        try{
            Thread.sleep(1000);
        } catch (Exception e) {

        }
        ride.updateStatus(RideStatus.ONGOING);
        try{
            Thread.sleep(1000);
        } catch (Exception e) {

        }
        ride.updateStatus(RideStatus.COMPLETED);
        availableDrivers.add(nearestdriver);
    }

    private Driver findNearestDriver(Location location){
        Driver assignedDriver = null;
        double minDist = Double.MAX_VALUE;
        for(Driver driver: availableDrivers){
            double dist = driver.getLocation().calcDistance(location);
            if(dist < minDist){
                minDist = dist;
                assignedDriver = driver;
            }
        }
        return assignedDriver;
    }
}
