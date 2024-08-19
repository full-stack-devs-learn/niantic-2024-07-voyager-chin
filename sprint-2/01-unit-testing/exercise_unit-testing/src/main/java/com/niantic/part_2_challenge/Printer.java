package com.niantic.part_2_challenge;

public class Printer
{
    private static final int MAX_SHEET_CAPACITY = 500;
    private static final int MAX_TONER = 1000;

    private int sheets;
    private int toner;

    public int getSheets()
    {
        return sheets;
    }

    public int getToner()
    {
        return toner;
    }

    public Printer(int sheets, int toner)
    {
        this.sheets = sheets;
        this.toner = toner;
    }

    public int print(int pages)
    {
        int maxCapacity = Math.min(sheets, toner);
        int pagesPrinted = Math.min(pages, maxCapacity);

        toner -= pagesPrinted;
        sheets -= pagesPrinted;

        return pagesPrinted;
    }

    public void addPaper(int paper)
    {
        if(paper > MAX_SHEET_CAPACITY)
        {
            sheets = MAX_SHEET_CAPACITY;
        }
        else
        {
            sheets += paper;
        }
    }

    public void replaceToner()
    {
        this.toner += MAX_TONER;
    }
}
