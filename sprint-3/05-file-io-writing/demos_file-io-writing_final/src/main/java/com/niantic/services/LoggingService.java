package com.niantic.services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LoggingService
{
    private String logType;

    public LoggingService(String logType)
    {
        this.logType = logType;

        ensureDirectoryExists(logType);
    }

    private void ensureDirectoryExists(String directoryName)
    {
        File directory = new File(directoryName);
        if(!directory.exists()) directory.mkdir();
    }

    private File getLogFile()
    {
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        String fileName = logType + "/" + today.format(formatter) + ".log";
        return new File(fileName);
    }

    public void logMessage(String message)
    {
        var file = getLogFile();
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        try(FileOutputStream stream = new FileOutputStream(file, true);
            PrintWriter out = new PrintWriter(stream))
        {
            out.printf("%s %s\n",now.format(formatter), message);
        }
        catch(Exception e)
        {
            // swallow
        }

    }

}
