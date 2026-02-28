package com.narxoz.rpg.hero;

public class Warrior implements Hero {
    private final String name;
    private int hp;
    private final int power;

    public Warrior(String name, int hp, int power) {
        this.name = name;
        this.hp = hp;
        this.power = power;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getPower() {
        return power;
    }

    @Override
    public void receiveDamage(int amount) {
        hp -= amount;
    }

    @Override
    public boolean isAlive() {
        return hp > 0;
    }
}