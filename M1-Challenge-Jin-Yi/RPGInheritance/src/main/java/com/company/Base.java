package com.company;

public class Base {

    protected String properties;
    protected String name;
    protected int strength;
    protected int health;
    protected int stamina;
    protected int speed;
    protected int attackPower;
    protected boolean running = false;
    protected boolean arrested = false;
    protected String abilities;
    protected String attackAnotherCharacter;

    public Base() {

    }

    public Base(String properties, String name) {
        this.properties = properties;
        this.name = name;
    }

    public Base(String properties, String name, int strength, int health, int stamina, int speed, int attackPower, boolean running, boolean arrested, String abilities, String attackAnotherCharacter) {

    }


    public String getProperties() {
        return properties;
    }

    public void setProperties(String properties) {
        this.properties = properties;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public boolean isArrested() {
        return arrested;
    }

    public void setArrested(boolean arrested) {
        this.arrested = arrested;
    }

    public String getAbilities() {
        return abilities;
    }

    public void setAbilities(String abilities) {
        this.abilities = abilities;
    }

    public String getAttackAnotherCharacter() {
        return attackAnotherCharacter;
    }

    public void setAttackAnotherCharacter(String attackAnotherCharacter) {
        this.attackAnotherCharacter = attackAnotherCharacter;
    }
}
