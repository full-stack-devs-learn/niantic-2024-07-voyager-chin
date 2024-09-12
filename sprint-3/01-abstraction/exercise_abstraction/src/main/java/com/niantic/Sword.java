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

        //Percent charged cannot exceed 100%
        if(currentCharge < 100)
        {
            //Each attack adds 10% to the percentCharged
            setPercentCharged(currentCharge + 10);
        }

        return damage;
    }

    @Override
    public int powerAttack()
    {
        int currentCharge = getPercentCharged();

        //100% delivers a 4x blow to the other character and reduces the charge to 0
        if(currentCharge == 100)
        {
            int damage = getDamage();
            setPercentCharged(0);

            return damage * 4;
        }
        //50% - 90% delivers a double blow to the other character and reduces the charge by 50%
        else if (currentCharge > 50)
        {
            int damage = getDamage();
            int updatedCharge = currentCharge - (int) (currentCharge * .5);
            setPercentCharged(updatedCharge);

            return damage * 2;
        }
        //a power attack can only be used if the sword has a charge
        //< 50% just performs a regular attack
        else if (currentCharge > 0)
        {
            return getDamage();
        }

        return 0;
    }

    @Override
    public int getRange() { return 1; }
}
