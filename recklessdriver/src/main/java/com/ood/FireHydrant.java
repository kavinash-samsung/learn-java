package com.ood;

public class FireHydrant extends SideObject {

    public FireHydrant(){
        super();
    }
    public FireHydrant(String name, int damage){
        super(name, damage);
    }
    @Override
    public void onCollision(GameObject other){

    }
}
