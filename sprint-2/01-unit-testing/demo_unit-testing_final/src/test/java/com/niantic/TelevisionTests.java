package com.niantic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TelevisionTests
{
    private Television tv;

    @BeforeEach
    public void setup()
    {
        tv = new Television();
    }

    @Test
    public void newTV_shouldBeOff_whenCreated()
    {
        // arrange
        // act
        // Television tv = new Television();

        // assert
        assertFalse(tv.isOn(), "Because a new TV should be off.");
    }

    @Test
    public void togglePower_shouldTurnTVOn_whenItIsOff()
    {
        // arrange
        // Television tv = new Television();
        int expectedChannel = 3;
        int expectedVolume = 2;

        // act
        tv.togglePower();

        // assert
        boolean isTvOn = tv.isOn();
        int actualChannel = tv.getCurrentChannel();
        int actualVolume = tv.getCurrentVolume();

        assertTrue(isTvOn, "Because the TV was off when I toggled the power.");
        assertEquals(expectedChannel, actualChannel, "Because the TV was just turned on and default channel should be 3.");
        assertEquals(expectedVolume, actualVolume, "Because the TV was just turned on and default volume should be 2.");

    }

    @Test
    public void togglePower_shouldTurnTVOff_whenItIsOn()
    {
        // arrange
        // Television tv = new Television();
        tv.togglePower();
        int expectedChannel = -1;
        int expectedVolume = -1;

        // act
        tv.togglePower();

        // assert
        boolean isTvOn = tv.isOn();
        int actualChannel = tv.getCurrentChannel();
        int actualVolume = tv.getCurrentVolume();

        assertFalse(isTvOn, "Because the TV was on when I toggled the power.");
        assertEquals(expectedChannel, actualChannel, "Because the TV was just turned off the channel should be -1.");
        assertEquals(expectedVolume, actualVolume, "Because the TV was just turned off the volume should be -1.");

    }

    @Test
    public void changeChannel_shouldSucceed_whenChannelIsInRange()
    {
        // arrange
        // Television tv  = new Television();
        int expectedChannel = 7;
        tv.togglePower();

        // act
        boolean didChannelChanged = tv.changeChannel(expectedChannel);

        // assert
        assertTrue(didChannelChanged, "Because the new channel was in the range of the available channels.");

        int actualChannel = tv.getCurrentChannel();
        assertEquals(expectedChannel, actualChannel, "Because the channel should have changed.");

    }

    @Test
    public void changeChannel_shouldSucceed_whenChannelIsUpperEdge()
    {
        // arrange
        // Television tv  = new Television();
        int expectedChannel = 15;
        tv.togglePower();

        // act
        boolean didChannelChanged = tv.changeChannel(expectedChannel);

        // assert
        assertTrue(didChannelChanged, "Because the new channel was in the range of the available channels.");

        int actualChannel = tv.getCurrentChannel();
        assertEquals(expectedChannel, actualChannel, "Because the channel should have changed.");

    }

    @Test
    public void changeChannel_shouldFail_whenChannelIsAboveUpperEdge()
    {
        // arrange
        // Television tv  = new Television();
        int newChannel = 16;
        int expectedChannel = 3;
        tv.togglePower();

        // act
        boolean didChannelChanged = tv.changeChannel(newChannel);

        // assert
        assertFalse(didChannelChanged, "Because the new channel was not in the range of the available channels.");

        int actualChannel = tv.getCurrentChannel();
        assertEquals(expectedChannel, actualChannel, "Because the channel should not have changed.");

    }


    @Test
    public void channelUp_shouldIncreaseChannel_whenPowerIsOn_andChannelIsBelowUpperEdge()
    {
        // arrange
        int expectedChannel = 4;
        tv.togglePower();

        // act
        int returnedChannel = tv.channelUp();

        // assert

        int actualChannel = tv.getCurrentChannel();

        assertEquals(expectedChannel, returnedChannel, "Because the TV was on and the channel was 3. Returned channel should be 4.");
        assertEquals(expectedChannel, actualChannel, "Because the TV was on and the channel was 3. Actual channel should be 4.");

    }


    @Test
    public void channelUp_shouldRollover_whenPowerIsOn_andChannelIsAtUpperEdge()
    {
        // arrange
        int expectedChannel = 3;
        tv.togglePower();
        tv.changeChannel(15);

        // act
        int returnedChannel = tv.channelUp();

        // assert

        int actualChannel = tv.getCurrentChannel();

        assertEquals(expectedChannel, returnedChannel, "Because the TV was on and the channel was 15. Returned channel should be 3.");
        assertEquals(expectedChannel, actualChannel, "Because the TV was on and the channel was 15. Actual channel should be 3.");

    }


    @Test
    public void channelUp_shouldNotChangeChannel_whenPowerIsOff()
    {
        // arrange
        int expectedChannel = -1;

        // act
        int returnedChannel = tv.channelUp();

        // assert

        int actualChannel = tv.getCurrentChannel();

        assertEquals(expectedChannel, returnedChannel, "Because the TV was off.");
        assertEquals(expectedChannel, actualChannel, "Because the TV was off.");

    }

}