package com.narxoz.rpg.enemy;

public class Goblin implements Enemy {
    private final String title;
    private int hp;
    private final int damage;

    public Goblin(String title, int hp, int damage) {
        this.title = title;
        this.hp = hp;
        this.damage = damage;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public void applyDamage(int amount) {
        hp -= amount;
    }

    @Override
    public boolean isDefeated() {
        return hp <= 0;
    }
}