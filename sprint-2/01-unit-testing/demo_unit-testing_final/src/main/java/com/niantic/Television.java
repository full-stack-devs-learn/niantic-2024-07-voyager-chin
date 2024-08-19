package com.niantic;

public class Television
{
    public static final int MIN_CHANNEL = 3;
    public static final int MAX_CHANNEL = 15;
    public static final int DEFAULT_CHANNEL = MIN_CHANNEL;
    public static final int MIN_VOLUME = 0;
    public static final int MAX_VOLUME = 10;
    public static final int DEFAULT_VOLUME = 2;

    private boolean isOn = false;
    private int currentChannel = DEFAULT_CHANNEL;
    private int currentVolume = DEFAULT_VOLUME;

    public boolean isOn()
    {
        return isOn;
    }

    public int getCurrentChannel()
    {
        if(!isOn)
        {
            return -1;
        }
        return currentChannel;
    }

    public int getCurrentVolume()
    {
        if(!isOn)
        {
            return -1;
        }
        return currentVolume;
    }

    public void togglePower()
    {
        isOn = !isOn;
        currentChannel = DEFAULT_CHANNEL;
        currentVolume = DEFAULT_VOLUME;
    }

    public boolean changeChannel(int newChannel)
    {
        if (newChannel < MIN_CHANNEL || newChannel > MAX_CHANNEL)
        {

            return false;
        }

        currentChannel = newChannel;

        return true;
    }

    public int channelUp()
    {
        if (isOn)
        {
            if(currentChannel < MAX_CHANNEL)
            {
                currentChannel++;
            }
            else {
                currentChannel = MIN_CHANNEL;
            }
        }

        return getCurrentChannel();
    }

    public int channelDown()
    {
        if (isOn)
        {
            if(currentChannel > MIN_CHANNEL)
            {
                currentChannel--;
            }
            else {
                currentChannel = MAX_CHANNEL;
            }
        }

        return getCurrentChannel();
    }

    public boolean changeVolume(int newVolume)
    {
        boolean isInRange = newVolume >= MIN_VOLUME && newVolume <= MAX_VOLUME;

        if (isOn && isInRange)
        {
            currentVolume = newVolume;
            return true;
        }

        return false;
    }

    public int volumeUp()
    {
        if (isOn && currentVolume < MAX_VOLUME)
        {
            currentVolume++;
        }

        return getCurrentVolume();
    }

    public int volumeDown()
    {
        if (isOn && currentVolume > MIN_VOLUME)
        {
            currentVolume--;
        }

        return getCurrentVolume();
    }
}
