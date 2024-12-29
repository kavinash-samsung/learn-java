package com.ood;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SideObject extends GameObject{
    private int damage;
    public SideObject(String name, int damage){
        super(name);
        this.damage = damage;
    }
}
