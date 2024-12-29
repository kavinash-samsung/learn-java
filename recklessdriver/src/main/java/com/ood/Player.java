package com.ood;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Player {
    private int health;
    private PlayerVehicle vehicle;

    public void ApplyDamage(int damage, int cash){
        health -= damage - vehicle.getStrength();
    }
    public boolean IsAlive(){
        return health > 0;
    }
    public void Accelerate(){
        vehicle.Up();
    }
    public void Brake(){
        vehicle.Down();
    }
    public void SteerLeft(){
        vehicle.Left();
    }
    public void SteerRight(){
        vehicle.Right();
    }
}