package com.niantic;

import com.niantic.application.StudentApplication;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Runnable app = new StudentApplication();
        app.run();
    }
}