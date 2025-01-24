package v2;

public abstract class User {
    protected String name;
    protected Location location;

    public User(String name, Location location){
        this.name = name;
        this.location = location;
    }

    public abstract void notify(String msg);
    public String getName(){
        return this.name;
    }
    public Location getLocation(){
        return this.location;
    }

    public void setLocation(Location location){
        this.location = location;
    }
}
