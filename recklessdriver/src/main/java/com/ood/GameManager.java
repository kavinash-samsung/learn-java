package com.ood;

public class GameManager {
    private int cash;
    
    public int GetCash(){
        return cash;
    }
    public void AddCash(int amount){
        cash += amount;
    }
    public void NewGame(){
        // choose Vehicle 
        PlayerVehicle vehicle = new PlayerVehicle("Sedan", 5, 70, 4);
        Player player = new Player(100, vehicle);
        player.setName("Player");
        // create player object
        // prepare scenary
        // Run loop
        while(player.IsAlive()){
            // player will drive the car
            
            // Generate game object 
            // repeat until health become zero

        }
    }
    public void EndGame(){
        System.out.println(String.format("Total cash Accumulated : %d", cash));
    }
}
