package com.niantic.objects;

public class TVMain
{
    public static void main(String[] args)
    {
        TV tv = new TV();

        System.out.println(tv.isOn());
        System.out.println(tv.getCurrentVolume());
        tv.increaseVolume();
        System.out.println(tv.getCurrentVolume());
        tv.turnOn();
        tv.increaseVolume();
        System.out.println(tv.getCurrentVolume());

        System.out.println();
        System.out.println(tv.getCurrentChannel());
        tv.channelUp();
        System.out.println(tv.getCurrentChannel());
        tv.channelUp();
        System.out.println(tv.getCurrentChannel());
        tv.channelUp();
        System.out.println(tv.getCurrentChannel());
        tv.channelUp();
        System.out.println(tv.getCurrentChannel());
        tv.channelUp();
        System.out.println(tv.getCurrentChannel());
        tv.channelUp();
        System.out.println(tv.getCurrentChannel());
        tv.channelUp();
        System.out.println(tv.getCurrentChannel());
        tv.channelUp();
        System.out.println(tv.getCurrentChannel());
        tv.channelUp();
        System.out.println(tv.getCurrentChannel());
        tv.channelUp();
        System.out.println(tv.getCurrentChannel());
        tv.channelUp();
        System.out.println(tv.getCurrentChannel());
        tv.channelUp();
        System.out.println(tv.getCurrentChannel());
        tv.channelUp();
        System.out.println(tv.getCurrentChannel());
    }
}
