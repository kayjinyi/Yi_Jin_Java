package com.company;

public class Farmer extends Base{

    private boolean plowing;
    private boolean harvesting;



    public Farmer(String properties, String name ){
        super(properties, name);
        this.setStrength(75);
        this.setHealth(100);
        this.setStamina(75);
        this.setSpeed(10);
        this.setAttackPower(1);
        this.setPlowing(false);
        this.setHarvesting(false);

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
