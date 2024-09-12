package com.niantic;

public abstract class Weapon
{
    private String name;
    private int damage;
    private int percentCharged = 0;

    public Weapon(String name, int damage)
    {
        this.name = name;
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

    public int getPercentCharged() {
        return percentCharged;
    }

    protected void setPercentCharged(int percentCharged) {
        this.percentCharged = percentCharged;
    }

    public abstract int attack();

    public abstract int powerAttack();

    public abstract int getRange();
}
