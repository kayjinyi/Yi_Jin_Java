package com.company;

public class Constable extends Base{
    private String jurisdiction;
    private String arrestAnotherCharacter;

    public Constable() {
        this.strength = 60;
        this.health = 100;
        this.stamina = 60;
        this.speed = 20;
        this.attackPower = 5;
    }

    public Constable(String properties, String name, int strength, int health, int stamina, int speed, int attackPower, boolean running, boolean arrested, String abilities, String attackAnotherCharacter, String jurisdiction,String arrestAnotherCharacter){
        super(properties, name, strength, health, stamina, speed, attackPower, running, arrested, abilities, attackAnotherCharacter);
        this.jurisdiction = jurisdiction;
        this.arrestAnotherCharacter = arrestAnotherCharacter;
        this.strength = 60;
        this.health = 100;
        this.stamina = 60;
        this.speed = 20;
        this.attackPower = 5;
    }

    public String getJurisdiction() {
        return jurisdiction;
    }

    public void setJurisdiction(String jurisdiction) {
        this.jurisdiction = jurisdiction;
    }

    public String getArrestAnotherCharacter() {
        return arrestAnotherCharacter;
    }

    public void setArrestAnotherCharacter(String arrestAnotherCharacter) {
        this.arrestAnotherCharacter = arrestAnotherCharacter;
    }
}
