package com.niantic;

import com.niantic.application.GradingApplication;

public class Main
{
    public static void main(String[] args)
    {
        Runnable app = new GradingApplication();
        app.run();
    }
}