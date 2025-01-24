package v2;

public class Location {
    private double latitude;
    
    private double longitude;

    
    public Location(double lat, double lon){
        this.latitude = lat;
        this.longitude = lon;
    }
    public double getLatitude() {
        return latitude;
    }
    public double getLongitude() {
        return longitude;
    }

    public double calcDistance(Location location){
        // Euclidean Distance
        double dx = this.getLatitude() - location.getLatitude();
        double dy = this.getLongitude() - location.getLongitude();
        return Math.sqrt(dx*dx + dy*dy);
    }
}
