package com.niantic.ui;

public final class ColorCodes 
{
    public static final String RESET = "\u001B[0m";
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m"; // docs say it's blue
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String GRAY = "\u001B[37m";
    public static final String DARK_GRAY = "\u001B[90m";

    public static final String BLACK_BACKGROUND = "\u001B[40m";
    public static final String RED_BACKGROUND = "\u001B[41m";
    public static final String GREEN_BACKGROUND = "\u001B[42m";
    public static final String YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ORANGE_BACKGROUND = "\u001B[44m"; // docs say it's blue
    public static final String PURPLE_BACKGROUND = "\u001B[45m";
    public static final String CYAN_BACKGROUND = "\u001B[46m";
    public static final String GRAY_BACKGROUND = "\u001B[47m";
    public static final String WHITE_BACKGROUND = "\u001B[7m";

    public static final String BOLD = "\u001B[1m";
    public static final String UNDERLINE_REGULAR = "\u001B[4m";
    public static final String ITALIC = "\u001B[3m";
    public static final String STRIKE_THROUGH = "\u001B[9m";
    public static final String UNDERLINE_HEAVY = "\u001B[21m";
    public static final String OUTLINE = "\u001B[51m";

    private ColorCodes(){}
    
}
