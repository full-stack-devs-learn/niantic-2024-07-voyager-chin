package com.niantic.adventure;

public class Archer extends Character
{
    private int arrows;

    public Archer(String name, int health, int level, int experience, int arrows)
    {
        super(name, health, level, experience);

        this.arrows = arrows;
    }

    public void addArrow()
    {
        arrows++;
        System.out.println(this.getName() + " added an arrow and now has " + this.arrows + " arrows");
    }

    @Override
    public void attack(Character target)
    {
        for (int i = 0; i < arrows; i++)
        {
            super.attack(target);
        }
    }

    @Override
    public void levelUp()
    {
        super.levelUp();
        if(!isDefeated()) addArrow();
    }

    @Override
    public void specialAbility()
    {
        System.out.println("Attack once for each arrow in the quiver");
    }
}
