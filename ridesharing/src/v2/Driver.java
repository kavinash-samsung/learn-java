package v2;
public class Driver extends User{
    private Vehicle vehicle;
    
    
    public Driver(String name, Vehicle vehicle, Location location){
        super(name, location);
        this.vehicle = vehicle;
        
    }
    public String getName() {
        return name;
    }
    public Vehicle getVehicle() {
        return vehicle;
    }

    public void notify(String msg){
        System.out.println("Driver :"+msg);
    }

}
