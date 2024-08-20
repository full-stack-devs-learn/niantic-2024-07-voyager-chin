package com.niantic;

public class Wizard extends Character
{
    private int mana;

    public Wizard(String name, int health, int level, int experience, int mana)
    {
        super(name, health, level, experience);

        this.mana = mana;
    }

    // getMana() returns the amount of mana of the wizard
    public int getMana()
    {
        return mana;
    }

    //castSpell() is a powerful attack that causes 2 times the damage of a normal attack
    public void castSpell(Character target)
    {
        //A wizard can only use a spell if they have at least 10 mana points
        //A wizard that has been defeated cannot cast spells
        if (mana >= 10 && !isDefeated())
        {
            for (int i = 0; i < 2; i++)
            {
                super.attack(target);
            }
        }

        //Each time the wizard casts a spell their mana is decreased by 10 points
        mana -= 10;
    }

    //regenerateMana() increases the mana points of the wizard
    public void regenerateMana(int mana)
    {
        //A wizard's mana can only increase if they have not been defeated
        if (!isDefeated())
        {
            this.mana += 10;
        }
    }

    //@Override levelUp() should perform all of the levelUp functions of a character
    @Override
    public void levelUp()
    {
        super.levelUp();
        //levelUp() should also increase the mana by 10 points
        if (!isDefeated()) { mana += 10; }
    }

    //@Override specialAbility() for the wizard should return Cast Spells
    @Override
    public String specialAbility() {
        return "Cast Spells";
    }
}
