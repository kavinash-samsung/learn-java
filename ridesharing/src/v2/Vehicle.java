package v2;

public abstract class Vehicle {
    
    protected String numberPlate;
    
    
    public Vehicle(String numberPlate){
        this.numberPlate = numberPlate;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public abstract double getFarePerKilometer();
}
