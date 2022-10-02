package com.company;

public class Warrior extends Base{
    private int shieldStrength;

    public Warrior() {
        this.shieldStrength = 100;
        this.strength = 75;
        this.health = 100;
        this.stamina = 100;
        this.speed = 50;
        this.attackPower = 10;
    }

    public Warrior(String properties, String name, int strength, int health, int stamina, int speed, int attackPower, boolean running, boolean arrested, String abilities, String attackAnotherCharacter, int shieldStrength){
        super(properties, name, strength, health, stamina, speed, attackPower, running, arrested, abilities, attackAnotherCharacter);
        this.shieldStrength = 100;
        this.strength = 75;
        this.health = 100;
        this.stamina = 100;
        this.speed = 50;
        this.attackPower = 10;
    }

    public int getShieldStrength() {
        return shieldStrength;
    }

    public void setShieldStrength(int shieldStrength) {
        this.shieldStrength = shieldStrength;
    }
}
