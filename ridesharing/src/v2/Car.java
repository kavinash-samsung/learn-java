package v2;

public class Car extends Vehicle {
    public Car(String numberPlate){
        super(numberPlate);
    }

    @Override
    public double getFarePerKilometer(){
        return 20;
    }
}
