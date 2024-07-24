package com.niantic;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class BackyardBasketballTest
{


    public static Stream<Arguments> calculateWinningPercentageArgs() {
        return Stream.of(
                Arguments.of(5,5,50),
                Arguments.of(3,7,30),
                Arguments.of(10,0,100),
                Arguments.of(3,6,33)
        );
    }

    @ParameterizedTest
    @CsvSource(value = {
            "5, 5, 50",
            "3, 7, 30",
            "10, 0, 100",
            "3, 6, 33"
    }, ignoreLeadingAndTrailingWhitespace = true)
    public void calculateWinningPercentage_ShouldCalculatePercentage_FromWinsAndLosses(String winsIn, String lossesIn, String expectedIn)
    {
        // arrange
        int wins = Integer.parseInt(winsIn);
        int losses = Integer.parseInt(lossesIn);
        int expected = Integer.parseInt(expectedIn);
        BackyardBasketball hoops = new BackyardBasketball();

        // act
        int actual = hoops.calculateWinningPercentage(wins, losses);

        // assert
        String message = String.format("because there were %d wins and %d losses => %d / %d", wins, losses, wins, wins+losses);
        assertEquals(expected, actual, .2, message);
    }

    @ParameterizedTest
    @CsvSource({
            "70,10,false,14",
            "70,10,true,21",
            "67,15,false,20"
    })
    public void calculatePointsScored_ShouldCalculateTotalPoint_FromPercentageOfShotsMade(String percentIn, String shotsIn, String isThreeIn, String expectedIn)
    {
        // arrange
        int percentage = Integer.parseInt(percentIn);
        int shots = Integer.parseInt(shotsIn);
        boolean isThree = Boolean.parseBoolean(isThreeIn);
        int expected = Integer.parseInt(expectedIn);
        BackyardBasketball hoops = new BackyardBasketball();

        // act
        int actual = hoops.calculatePointsScored(percentage, shots, isThree);

        // assert
        String message = String.format("\nbecause these were the inputs:\n -- %d shots\n -- three pointers: %s\n -- shooting average: %d %%\n",
                shots, isThree, percentage);
        assertEquals(expected, actual, .2, message);
    }
    @ParameterizedTest
    @CsvSource({
            "50,10,false,10",
            "50,10,true,8",
            "75,15,true,7",
            "80,18,true,8",
            "67,24,false,18"
    })
    public void calculateShotsRequired_ShouldCalculateShotsNeeded_FromShootingPercentage(String percentIn, String pointsIn, String isThreeIn, String expectedIn)
    {
        // arrange
        int percentage = Integer.parseInt(percentIn);
        int points = Integer.parseInt(pointsIn);
        boolean isThree = Boolean.parseBoolean(isThreeIn);
        int expected = Integer.parseInt(expectedIn);
        BackyardBasketball hoops = new BackyardBasketball();

        // act
        int actual = hoops.calculateShotsRequired(percentage, points, isThree);

        // assert
        String message = String.format("\nInputs:\n -- points needed: %d\n -- three point attempts: %s\n -- shooting percentage: %d %%\n",
                points, isThree, percentage);
        assertEquals(expected, actual, .2, message);
    }
}