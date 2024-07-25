package com.niantic;

public class BackyardBasketball
{
    /*
     * Teams that play in the backyard league want to be able
     * to calculate their winning percentage.
     *
     * Each team knows how many games they have won and how many
     * games they have lost. When they call this function they
     * will provide their wins and losses.
     *
     * You need to perform the calculation and return their
     * winning percentage as a whole number.
     *
     * Example:
     * If a team has won 7 games and lost 3 games their winning
     * percentage is 70%.
     *
     * calculateWinningPercentage(7, 3) -> 70
     * calculateWinningPercentage(5, 5) -> 50
     * calculateWinningPercentage(5, 10) -> 33
     *
     */
    public int calculateWinningPercentage(int gamesWon, int gamesLost)
    {
        return 0;
    }


    /*
     * The calculatePointsScored function should calculate
     * the number of points a player scored in a game.
     *
     * shotPercentage = the percent of shots made
     * shotsTaken = the number of shots the player took
     * isThree = if true, the player shot a 3 pointer otherwise a 2
     *
     * calculatePointsScored(70, 10, false) -> 14
     * calculatePointsScored(70, 10, true) -> 21
     * calculatePointsScored(67, 15, false) -> 20
     *
     */
    public int calculatePointsScored(int shotPercentage, int shotsTaken, boolean isThree)
    {
        return 0;
    }


    /*
     * Calculate the minimum number of shots that are required
     * to score the desired number of points.
     *
     * shotPercentage = the estimated % of shots that will go in (whole number)
     * desiredScore = the number of points you want to score
     * isThree = if true, the player will shoot a 3 pointer otherwise a 2
     *
     * Example:
     * If a player has a 50% scoring average, and he wants to score 10 points,
     * how many shots will he have to take (if he is NOT shooting 3 pointers)
     *
     * calculateShotsRequired(50, 10, false) -> 10
     *
     * calculateShotsRequired(50, 10, true) -> 8
     * calculateShotsRequired(75, 15, true) -> 7
     * calculateShotsRequired(80, 18, true) -> 8
     * calculateShotsRequired(67, 24, false) -> 18     *
     *
     */
    public int calculateShotsRequired(int shotPercentage, int desiredScore, boolean isThree)
    {
        // step 1: calculate needed baskets
        double madeBaskets;
        int requiredShots;

        if (isThree == true)
        {
            System.out.println("isThree is true");
            madeBaskets = desiredScore / 3.0;
            System.out.println("madeBaskets is " + madeBaskets);
        }
        else
        {
            System.out.println("isThree is false");
            madeBaskets = desiredScore / 2.0;
            System.out.println("madeBaskets is " + madeBaskets);
        }

        madeBaskets = Math.ceil(madeBaskets);
        System.out.println("madeBaskets is " + madeBaskets);

        // step 2:
        double actualPercentage = ((madeBaskets * 100) / shotPercentage);
        requiredShots = (int)Math.ceil(actualPercentage);

        return requiredShots;
    }

    public int calculateShotsRequiredIntegers(int shotPercentage, int desiredScore, boolean isThree)
    {
        // step 1: calculate needed baskets
        int madeBaskets;
        int actualScore;
        int requiredShots;

        if (isThree == true)
        {
            madeBaskets = desiredScore / 3;
            actualScore = madeBaskets * 3;
        }
        else
        {
            madeBaskets = desiredScore / 2;
            actualScore = madeBaskets * 2;
        }

        if(actualScore < desiredScore)
        {
            madeBaskets++;
        }

        // step 2:
        requiredShots = (madeBaskets * 100) / shotPercentage;

        return requiredShots;
    }
}