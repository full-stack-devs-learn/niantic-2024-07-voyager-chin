package com.niantic;

public class Knight extends Character
{
    private int armor;

    public Knight(String name, int health, int level, int experience, int armor)
    {
        super(name, health, level, experience);

        this.armor = armor;
    }

    // getArmor() returns the amount of mana of the wizard
    public int getArmor()
    {
        return armor;
    }

    //@Override takeDamage() is overriden to add logic to allow the armor to deflect a blow
    @Override
    public void takeDamage(int damage)
    {
//        super.takeDamage(damage);

    //The armor / shield should deflect the amount of damage that the armor can handle
        if (!isDefeated())
        {
            if(armor >= 10)
            {
                armor -= damage;
                System.out.println(this.name + " now has " + armor + " armor remaining.");
            }
            else if (armor > 0)
            {
                damage -= armor;
                health -= damage;
            }
            else
            {
                super.takeDamage(damage);
            }
        }

    //Any additional damage should be removed from the health of the knight.
    //The armor's level does not decrease, but can be re-used
    //If the armor is more powerful than the attack, then no damage is sustained by the knight

    }

    //@Override levelUp() should perform all of the levelUp functions of a character
    //levelUp() should also increase the armor by 5 points
    @Override
    public void levelUp()
    {
        super.levelUp();

        if(!isDefeated())
        {
            armor += 5;
        }
    }

    //@Override specialAbility() for the wizard should return Armor Shield
    @Override
    public String specialAbility()
    {
        return "Armor Shield";
    }
}
