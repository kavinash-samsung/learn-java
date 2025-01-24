package v2;

public class Passenger extends User{

    public Passenger(String name, Location location) {
        super(name, location);
    }

    public void notify(String msg){
        System.out.println("Passenger :" + msg);
    }

}
