package com.company;

public class Constable extends Base{
    private String jurisdiction;
    private String arrestAnotherCharacter;


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

    public String getArrestAnotherCharacter() {
        return arrestAnotherCharacter;
    }

    public void setArrestAnotherCharacter(String arrestAnotherCharacter) {
        this.arrestAnotherCharacter = arrestAnotherCharacter;
    }
}
