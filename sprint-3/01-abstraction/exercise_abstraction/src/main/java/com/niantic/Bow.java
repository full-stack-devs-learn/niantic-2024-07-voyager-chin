package com.niantic;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

public class Bow extends Weapon
{
    private String arrowType;
    private int quiverSize;
    private int arrowCount;
    boolean isAttacking;

    public Bow(String name, int damage, String arrowType, int quiverSize)
    {
        super(name, damage);
        this.arrowType = arrowType;
        this.quiverSize = quiverSize;
        arrowCount = quiverSize;

        Timer timer = new Timer();
        TimerTask replenishArrow = new TimerTask() {
            @Override
            public void run() {
                if (arrowCount < quiverSize) {
                    arrowCount++;
                }
            }
        };
        // Arrows are replenished 1 at a time in 5 second intervals
        timer.schedule(replenishArrow, 5000);

        // percentCharge increases by 20% every 2 seconds
        TimerTask chargeIncrease = new TimerTask() {
            @Override
            public void run() {
                int currentCharge = getPercentCharged();
                if (currentCharge >= 80)
                {
                    currentCharge  = 100;
                }
                else if (currentCharge < 80)
                {
                    currentCharge += 20;
                }
                setPercentCharged(currentCharge);
            }
        };
        timer.schedule(chargeIncrease, 2000);
    }

    public String getArrowType() { return arrowType; }

    public int getQuiverSize() { return quiverSize; }

    public int getArrowCount() { return arrowCount; }

    public int attack()
    {
        String arrow = getArrowType();
        int damage = getDamage();
        arrowCount--;

        //Each attack shoots one arrow
        if(arrow.equalsIgnoreCase("standard"))
        {
            return damage;
        }
        else if (arrow.equalsIgnoreCase("poison"))
        {
            return damage * 2;
        }
        else if (arrow.equalsIgnoreCase("explosive"))
        {
            return damage * 3;
        }
        return 0;
    }

    public int powerAttack()
    {
        int damage = getDamage();
        int charge = getPercentCharged();

        if (charge == 100)
        {
            isAttacking = true;
            int totalDamage = 0;

            Timer timer = new Timer();
            TimerTask finishAttack = new TimerTask() {
                @Override
                public void run() {
                    isAttacking = false;
                }
            };

            timer.schedule(finishAttack, 5000);

            while(isAttacking)
            {
                totalDamage += damage * 2;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    e.printStackTrace();
                }
            }

            setPercentCharged(0);
            return totalDamage;
        }
        else
        {
            return 0;
        }
    }

    public int getRange() { return 20; }
}
