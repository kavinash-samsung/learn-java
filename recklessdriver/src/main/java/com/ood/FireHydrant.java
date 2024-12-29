package com.ood;

public class FireHydrant extends SideObject {
    public FireHydrant(int damage, int cash){
        super(damage, cash);
    }

    @Override
    public void OnCollision(GameObject other) {
        // TODO Auto-generated method stub
        super.OnCollision(other);
    }

}
