public class Driver {
    String name;
    Location location;
    Vehicle vehicle;
    public Driver(String name){
        this.name = name;
    }
    public void setLocation(Location location){
        this.location = location;
    }
    public Location getLocation(){
        return this.location;
    }
}
