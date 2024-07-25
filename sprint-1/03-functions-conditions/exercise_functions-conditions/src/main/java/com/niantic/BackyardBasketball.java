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
        int totalGames = gamesWon + gamesLost;
        int totalPercentage = 100;
        double winningPercentage = ( (double) gamesWon / totalGames ) * totalPercentage;

        return (int) winningPercentage;
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
        double decimalPercentage = (double) shotPercentage / 100;
        double shotsWithPoints = decimalPercentage * shotsTaken;
        double pointsScored = 0;

        // if true, multiply shots by 3 points, ShotsWithPoints multiply to 3 points
        // else, multiply shot by 2 points, shotsWithPoints multiply to 2 points
        if (isThree) {
            pointsScored = shotsWithPoints * 3;
        } else {
            pointsScored = shotsWithPoints * 2;
        }

        return (int) pointsScored;
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
        double points3 = 3;
        double points2 = 2;

        double decimalPercentage = (double) shotPercentage / 100;

        double targetPointShots;

        if (isThree) {
            targetPointShots = Math.ceil(desiredScore / points3);
        } else {
            targetPointShots = Math.ceil(desiredScore / points2);
        }

        double shotsRequired = Math.ceil(targetPointShots / decimalPercentage);

        return (int) shotsRequired;

//        double points3 = 3;
//        double points2 = 2;
//
//        double decimalPercentage = (double) shotPercentage / 100;
//
//        double targetFullScore = Math.ceil(desiredScore / decimalPercentage);
//
//        double shotsRequired = 0;
//        double probableScore;
//
//        if (isThree) {
//            shotsRequired = Math.ceil(targetFullScore / points3);
//            probableScore = shotsRequired * points3;
//        } else {
//            shotsRequired = Math.ceil(targetFullScore / points2);
//            probableScore = shotsRequired * points2;
//        }
//
//
//        if (probableScore <= desiredScore) {
//            shotsRequired += 1;
//        }
//
//        return (int) shotsRequired;













//        double decimalPercentage = (double) shotPercentage / 100;
//        double target3PointShots = Math.ceil(desiredScore / 3);
//        double target2PointShots = Math.ceil(desiredScore / 2);
//
//        double shotsRequired = 0;
//
//        if (isThree) {
//            shotsRequired = Math.ceil((target3PointShots / shotPercentage) * 100);
//        } else {
//            shotsRequired = Math.ceil((target2PointShots / shotPercentage) * 100);
//        }
//
//        return (int) shotsRequired;

       // double multiplier = ( (double) shotPercentage + 100) / 100; //get multiplier - 1.5

//        //shotPercentage = 50%, desiredScore = 10 , pointsPerShot = 3
//        //10/3 = 4
//
//        double target3PointShots = Math.floor(desiredScore / 3);
//        double target2PointShots = Math.floor(desiredScore / 2);
//        double decimalPercentage = shotPercentage / 100;
//
//        double shotsRequired = 0;
//
//        if (isThree) {
//            shotsRequired = ((desiredScore / decimalPercentage)/ target3PointShots) * target3PointShots;
//        } else {
//            shotsRequired = ((desiredScore / decimalPercentage)/ target2PointShots) * target2PointShots;
//        }
//
//        return (int) shotsRequired;

    }
}