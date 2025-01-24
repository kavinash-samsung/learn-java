package v1;

import java.util.ArrayList;
import java.util.List;

public class RideSharingAppService {
    private List<Driver> drivers = new ArrayList<>();
    private List<Passenger> passengers = new ArrayList<>();

    public void addDriver(Driver driver){
        drivers.add(driver);
    }
    public void addPassenger(Passenger passenger){
        passengers.add(passenger);
    }
    public void bookRide(Passenger passenger, double distance){
        if(drivers.isEmpty()){
            System.out.println("No drivers are available for "+passenger.getName());
        }

        // Hard - coded assignment logic
        // find the nearest driver
        Driver assignedDriver = null;
        double minDistance = Double.MAX_VALUE;
        for(Driver driver: drivers){
            // find nearest driver
            double current_driver_distance  = calcDistance(passenger.getLocation(), driver.getLocation());
            if(current_driver_distance < minDistance){
                minDistance = current_driver_distance;
                assignedDriver = driver;
            }
        }

        // Fare Calculation
        double expectedFare = calcFare(assignedDriver.getVehicle(), distance);

        System.out.println("Ride booked for "+passenger.getName()+" with driver "+assignedDriver.getName()+" with fare calcuated "+ expectedFare);
        System.out.println("Driver is on the way");
    }
    
    private double calcDistance(Location from, Location to){
        // Euclidean Distance
        double dx = from.getLatitude() - to.getLatitude();
        double dy = from.getLongitude() - to.getLongitude();
        return Math.sqrt(dx*dx + dy*dy);
    }

    public double calcFare(Vehicle vehicle, double distance){
        if(vehicle.getType().equals("Car")){
            return distance*20;
        }else if(vehicle.getType().equals("Bike")){
            return distance*10;
        }else{
            return distance*8;
        }
    }
}
