package com.niantic;

public class Character
{
    protected static final int attackDamage = 10;

    protected String name;
    protected int health;
    protected int level;
    protected int experience;


    public boolean isDefeated()
    {
        return health <= 0;
    }

    public String getName()
    {
        return name;
    }

    public int getHealth()
    {
        return health;
    }

    public int getLevel()
    {
        return level;
    }

    public int getExperience()
    {
        return experience;
    }

    public Character(String name, int health, int level, int experience)
    {
        this.name = name;
        this.health = health;
        this.level = level;
        this.experience = experience;
    }

    public void attack(Character target)
    {
        if (isDefeated())
        {
            System.out.println(this.name + " has been defeated and cannot attack another player.");
            return;
        }

        System.out.println(this.name + " attacks " + target.getName());

        // Basic attack logic, e.g., reducing the target's health
        target.takeDamage(attackDamage); // Example damage value
    }

    public void takeDamage(int damage)
    {
        this.health -= damage;
        if (isDefeated())
        {
            health = 0;
            System.out.println(this.name + " has been defeated!");
        }
        else
        {
            System.out.println(this.name + " now has " + this.health + " health remaining.");
        }
    }

    public void levelUp()
    {
        if(isDefeated())
        {
            System.out.println(this.name + " has been defeated!");
            return;
        }

        this.level++;
        this.health += 10;
        System.out.println(this.name + " has leveled up to level " + this.level + "!");
    }

    public String specialAbility()
    {
        return "Standard";
    }
}
