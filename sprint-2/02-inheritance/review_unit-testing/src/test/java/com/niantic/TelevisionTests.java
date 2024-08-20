package com.niantic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class TelevisionTests
{
    private Television tv;

    @BeforeEach
    public void setup()
    {
        tv = new Television();
    }

    @ParameterizedTest
    @CsvSource({
            "2, false, 3",
            "3, true, 3",
            "4, true, 4",
            "5, true, 5",
            "6, true, 6",
            "7, true, 7",
            "8, true, 8",
            "9, true, 9",
            "10, true, 10",
            "11, true, 11",
            "12, true, 12",
            "13, true, 13",
            "14, true, 14",
            "15, true, 15",
            "16, false, 3"
    })
    public void changeChannel_shouldSucceed_whenChannelIsInRange(String inputIn, String successIn, String expectedIn)
    {
        // arrange
        int channelInput = Integer.parseInt(inputIn);
        boolean expectedSuccess = Boolean.parseBoolean(successIn);
        int expectedChannel = Integer.parseInt(expectedIn);

        tv.togglePower();

        // act
        boolean didChannelChanged = tv.changeChannel(channelInput);

        // assert
        assertEquals(expectedSuccess, didChannelChanged, "Because the input channel was : " + channelInput);

        int actualChannel = tv.getCurrentChannel();
        assertEquals(expectedChannel, actualChannel, "Because the input channel was : " + channelInput);

    }


}