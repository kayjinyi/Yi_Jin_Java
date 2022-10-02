package com.company;

public class Farmer extends Base{

    private boolean plowing;
    private boolean harvesting;


    public Farmer() {

        this.strength = 75;
        this.health = 100;
        this.stamina = 75;
        this.speed = 10;
        this.attackPower =1;
        this.plowing = false;
        this.harvesting = false;
    }

    public Farmer(String properties, String name, int strength, int health, int stamina, int speed, int attackPower, boolean running, boolean arrested, String abilities, String attackAnotherCharacter, boolean plowing,boolean harvesting){
        super(properties, name, strength, health, stamina, speed, attackPower,running, arrested, abilities, attackAnotherCharacter);
        this.strength = 75;
        this.health = 100;
        this.stamina = 75;
        this.speed = 10;
        this.attackPower =1;
        this.plowing = false;
        this.harvesting = false;

    }

    public boolean isPlowing() {
        return plowing;
    }

    public void setPlowing(boolean plowing) {
        this.plowing = plowing;
    }

    public boolean isHarvesting() {
        return harvesting;
    }

    public void setHarvesting(boolean harvesting) {
        this.harvesting = harvesting;
    }


}
