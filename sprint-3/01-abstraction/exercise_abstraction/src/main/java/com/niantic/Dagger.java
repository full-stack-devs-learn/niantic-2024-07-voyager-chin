package com.niantic;

public class Dagger extends Weapon
{
    private int daggerCount;

    public Dagger(String name, int damage, int daggerCount)
    {
        super(name, damage);
        this.daggerCount = daggerCount;
    }

    public int getDaggerCount() { return daggerCount; }

    @Override
    public int attack()
    {
        if (daggerCount > 0)
        {
            int percentCharge = getPercentCharged();
            percentCharge += 20;
            setPercentCharged(percentCharge);
            return getDamage();
        }
        else
        {
            return 0;
        }
    }

    @Override
    public int powerAttack()
    {
        int percentCharge = getPercentCharged();
        int powerDamage = getDamage() * 3;

        if (percentCharge == 100)
        {
            if(daggerCount > 0)
            {
                daggerCount -= 1;
                return powerDamage;
            }
        }
        return 0;
    }

    @Override
    public int getRange() { return 10; }

    public void addDagger() { daggerCount++; }
}
