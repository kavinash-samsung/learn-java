import java.util.ArrayList;
import java.util.List;
import Driver;
import Passenger;

public class RideSharingAppService {
    private List<Driver> drivers = new ArrayList<>();
    private List<Passengers> passengers = new ArrayList<>();

    public void addDriver(Driver driver){
        drivers.add(driver);
    }
    public void addPassenger(Passenger passenger){
        passengers.add(passenger);
    }
    public void bookRide(Passenger passenger, double distance){
        if(drivers.isEmpty()){
            System.out.println("No drivers are available for "+passenger.name);
        }

        // Hard - coded assignment logic
        // find the nearest driver
        
    }
}
