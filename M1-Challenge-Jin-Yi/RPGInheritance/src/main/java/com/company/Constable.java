package com.company;

public class Constable extends Base{
    private String jurisdiction;


    public Constable(String properties, String name){
        super(properties, name);
        this.setStrength(60);
        this.setHealth(100);
        this.setStamina(60);
        this.setSpeed(20);
        this.setAttackPower(5);
    }

    public String getJurisdiction() {
        return jurisdiction;
    }

    public void setJurisdiction(String jurisdiction) {
        this.jurisdiction = jurisdiction;
    }

    public void arrestAnotherCharacter(Base character1) {
        character1.arrested = false;
    }
}
