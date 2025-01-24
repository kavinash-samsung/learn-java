package v2;

public class Bike extends Vehicle {
    public Bike(String numberPlate){
        super(numberPlate);
    }

    @Override
    public double getFarePerKilometer(){
        return 10;
    }
}
