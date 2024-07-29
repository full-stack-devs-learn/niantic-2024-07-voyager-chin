package com.niantic;

public class Main
{
    public static void main(String[] args)
    {
        String formattedPhone = formatPhone2("(800)555-1234");
        System.out.println(formattedPhone);
    }

    // option 1 format Phone
    public static String formatPhone(String originalPhone)
    {
        char[] chars = new char[10];
        int count = 0;

        for(int i = 0; i < originalPhone.length(); i++)
        {
            char currentChar = originalPhone.charAt(i);
            if(Character.isDigit(currentChar))//;currentChar >= '0' && currentChar <= '9')
            {
                chars[count] = currentChar;
                count++;
            }
        }

        return new String(chars);
    }

    // option 2 format Phone
    public static String formatPhone2(String originalPhone)
    {
        String areaCode = originalPhone.substring(1,4);
        String prefix = originalPhone.substring(5,8);
        String lastFour = originalPhone.substring(9);

        return areaCode + prefix + lastFour;
    }
}