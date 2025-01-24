package v1;
public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        Location loc1 = new Location(12.88, 14.88);
        Location loc2 = new Location(15.88, 15.88);
        Location loc3 = new Location(18.88, 18.88);

        // create vehicles
        Vehicle car = new Vehicle("AXAS909", "Car");
        Vehicle bike = new Vehicle("AXAS909", "Bike");

        Driver driver1 = new Driver("Alice", bike, loc3);
        Driver driver2 = new Driver("Bob", car, loc2);

        Passenger passenger1 = new Passenger("John", loc1);
        Passenger passenger2 = new Passenger("Rahul", loc3);

        RideSharingAppService app = new RideSharingAppService();

        app.addDriver(driver2);
        app.addDriver(driver1);

        app.addPassenger(passenger1);
        app.addPassenger(passenger2);

        app.bookRide(passenger2, 10);
        app.bookRide(passenger1, 8);
        app.bookRide(passenger1, 8);


    }
}
