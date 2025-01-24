package v2;
public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        Location loc1 = new Location(12.88, 14.88);
        Location loc2 = new Location(15.88, 15.88);
        Location loc3 = new Location(18.88, 18.88);

        // create vehicles
        Vehicle car = new Car("AK7979");
        Vehicle bike = new Bike("KJHK90");

        Driver driver1 = new Driver("Alice", bike, loc3);
        Driver driver2 = new Driver("Bob", car, loc1);

        Passenger passenger1 = new Passenger("John", loc2);

        RideMatchingSystem rideMatchingSystem = new RideMatchingSystem();
        
        rideMatchingSystem.addDriver(driver1);
        rideMatchingSystem.addDriver(driver2);
        
        rideMatchingSystem.requestRide(passenger1, 5, new StandardfareStrategy());


    }
}
