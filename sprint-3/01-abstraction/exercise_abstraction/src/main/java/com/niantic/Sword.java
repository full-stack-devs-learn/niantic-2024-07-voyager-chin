package com.niantic;

public class Sword extends Weapon
{
    public Sword(String name, int damage)
    {
        super(name, damage);
    }

    @Override
    public int attack()
    {
        int damage = getDamage();
        int currentCharge = getPercentCharged();

        if(currentCharge < 100)
        {
            int updatedCharge = currentCharge + 10;
            if(updatedCharge > 100)
            {
                updatedCharge = 100;
            }
            setPercentCharged(updatedCharge);
        }

        return damage;
    }

    @Override
    public int powerAttack()
    {
        int currentCharge = getPercentCharged();

        if(currentCharge == 100)
        {
            int damage = getDamage();
            setPercentCharged(0);

            return damage * 4;
        }
        else if (currentCharge > 50)
        {
            int damage = getDamage();
            currentCharge -= 50;
            setPercentCharged(currentCharge);

            return damage * 2;
        }
        else if (currentCharge > 0)
        {
            return getDamage();
        }

        return 0;
    }

    @Override
    public int getRange() { return 1; }
}
