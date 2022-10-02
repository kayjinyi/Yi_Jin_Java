package com.company;

public class App {
    public static void main(String[] args) {

        Constable constable1 = new Constable();
        System.out.println(constable1.strength);

        Base base1 = new Base("String properties", "String name", 20, 10,10, 10, 10,  false, false,"abc", "String attackAnotherCharacter");
        base1.running = true;
        System.out.println(base1.running);

    }
}
