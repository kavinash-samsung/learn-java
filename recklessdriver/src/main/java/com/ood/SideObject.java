package com.ood;

public class SideObject extends GameObject {
    private int damage;
    private int cash;
    private int count;
    public SideObject(int damage, int cash){
        this.damage = damage;
        this.cash = cash;
        this.count = 0;
    }
    
    public final int getDamage() {
        return damage;
    }
    public final void setDamage(int damage) {
        this.damage = damage;
    }
    public final int getCash() {
        return cash;
    }
    public final void setCash(int cash) {
        this.cash = cash;
    }
    public final int getCount() {
        return count;
    }
    public final void setCount(int count) {
        this.count = count;
    }
}
