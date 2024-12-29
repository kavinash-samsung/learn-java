package com.ood;

public class Sedan extends TrafficCar{

    public Sedan(int damage, int cash){
        super(damage, cash);
    }
    @Override
    public void OnCollision(GameObject other) {
        // TODO Auto-generated method stub
        super.OnCollision(other);
    }
}
