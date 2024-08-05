package com.niantic.objects;

public class TV
{
    private final int MAX_CHANNEL;
    private final int MIN_CHANNEL;
    private final int MAX_VOLUME;
    private final int MIN_VOLUME;
    private final int DEFAULT_CHANNEL;
    private final int DEFAULT_VOLUME;


    private int currentChannel;
    private int currentVolume;
    private boolean isOn = false;

    public TV()
    {
        MAX_CHANNEL = 13;
        MIN_CHANNEL =2;
        MAX_VOLUME = 50;
        MIN_VOLUME = 0;
        DEFAULT_CHANNEL = 2;
        DEFAULT_VOLUME = 3;
    }

    public TV(int maxChannel, int minChannel, int maxVolume, int minVolume, int defaultChannel, int defaultVolume)
    {
        MAX_CHANNEL = maxChannel;
        MIN_CHANNEL = minChannel;
        MAX_VOLUME = maxVolume;
        MIN_VOLUME = minVolume;
        DEFAULT_CHANNEL = defaultChannel;
        DEFAULT_VOLUME = defaultVolume;
    }

    public int getCurrentChannel() {
        return isOn ? currentChannel :0;
    }

    public int getCurrentVolume()
    {
        return isOn ? currentVolume : 0;
    }

    public boolean isOn() {
        return isOn;
    }

    public void turnOn()
    {
        currentChannel = DEFAULT_CHANNEL;
        currentVolume = DEFAULT_VOLUME;
        isOn = true;
    }

    public void turnOff()
    {
        isOn = false;
    }

    public int increaseVolume()
    {
        if(isOn && currentVolume < MAX_VOLUME)
        {
            currentVolume++;
        }

        return currentVolume;
    }

    public int decreaseVolume()
    {
        if(isOn && currentVolume > MIN_VOLUME)
        {
            currentVolume--;
        }

        return currentVolume;
    }

    public boolean changeChannel(int channel)
    {
        if(isOn && channel >= MIN_CHANNEL && channel <= MAX_CHANNEL)
        {
            currentChannel = channel;
            return true;
        }

        return false;
    }

    public int channelUp()
    {
        if(isOn)
        {
            if(currentChannel == MAX_CHANNEL)
            {
                currentChannel = MIN_CHANNEL;
            }
            else
            {
                currentChannel++;
            }
        }

        return getCurrentChannel();
    }

    public int channelDown()
    {
        if(isOn)
        {
            if(currentChannel == MIN_CHANNEL)
            {
                currentChannel = MAX_CHANNEL;
            }
            else
            {
                currentChannel--;
            }
        }

        return getCurrentChannel();
    }
}
