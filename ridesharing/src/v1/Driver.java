package v1;
public class Driver {
    private String name;
    private Location location;
    private Vehicle vehicle;
    
    
    public Driver(String name, Vehicle vehicle, Location location){
        this.name = name;
        this.vehicle = vehicle;
        this.location = location;
    }
    public String getName() {
        return name;
    }
    public Vehicle getVehicle() {
        return vehicle;
    }
    public void setLocation(Location location){
        this.location = location;
    }
    public Location getLocation(){
        return this.location;
    }
}
