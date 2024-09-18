package com.niantic.services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogService
{
    private String logType;

    private void ensureDirectoryExists(String path)
    {
        File directory = new File(path);
        if(!directory.exists())
        {
            directory.mkdir();
        }
    }

    public LogService(String logType) {
        this.logType = logType;

        ensureDirectoryExists(logType);
    }

    private File getLogFile()
    {
        String fileName = logType + "/" + getDateTime("date") + ".log";
        return new File(fileName);
    }

    public void logMessage(String message)
    {
        var file = getLogFile();
        String dateTime = getDateTime("dateTime");

        try(FileOutputStream stream = new FileOutputStream(file, true);
            PrintWriter out = new PrintWriter(stream))
        {
            out.printf("%s %s\n", dateTime, message);
        }
        catch (Exception e)
        {

        }
    }

    private String getDateTime(String format)
    {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        if(format.equalsIgnoreCase("date"))
        {
            return now.format(dateFormat);
        }
        else
        {
            return now.format(dateTimeFormat);
        }

    }
}
