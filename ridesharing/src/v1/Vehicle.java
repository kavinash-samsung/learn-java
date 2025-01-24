package v1;

public class Vehicle {
    public String getNumberPlate() {
        return numberPlate;
    }

    private String numberPlate;
    private String type;

    public String getType() {
        return type;
    }

    public Vehicle(String numberPlate, String type){
        this.numberPlate = numberPlate;
        this.type = type;
    }
}
