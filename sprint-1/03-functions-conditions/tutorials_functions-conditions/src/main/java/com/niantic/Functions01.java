package com.niantic;

public class Functions01
{
    public static void main(String[] args)
    {
        String teamName;
        int rank, q1, q2, q3, q4, finalScore;

        /* start repeatable code */
        // Georgia
        teamName = "Georgia";
        rank = 1;
        q1 = 12;
        q2 = 14;
        q3 = 6;
        q4 = 7;
        finalScore = q1 + q2 + q3 + q4;

        System.out.printf("(%d) %s \n", rank, teamName);
        System.out.println("-------------------------------");
        System.out.println(" Q1  Q2  Q3  Q4  Final");
        System.out.println(" --- --- --- --- -----");
        System.out.printf(" %-2d  %-2d  %-2d  %-2d  %d \n",q1, q2,q3,q4,finalScore);
        System.out.println();
        /* end repeatable code */


        /* start repeatable code */
        // Alabama
        teamName = "Alabama";
        rank = 2;
        q1 = 14;
        q2 = 17;
        q3 = 10;
        q4 = 14;
        finalScore = q1 + q2 + q3 + q4;

        System.out.printf("(%d) %s \n", rank, teamName);
        System.out.println("-------------------------------");
        System.out.println(" Q1  Q2  Q3  Q4  Final");
        System.out.println(" --- --- --- --- -----");
        System.out.printf(" %-2d  %-2d  %-2d  %-2d  %d \n",q1, q2,q3,q4,finalScore);
        System.out.println();
        /* end repeatable code */


        /* start repeatable code */
        // Ohio State
        teamName = "Ohio State";
        rank = 3;
        q1 = 21;
        q2 = 10;
        q3 = 14;
        q4 = 7;
        finalScore = q1 + q2 + q3 + q4;

        System.out.printf("(%d) %s \n", rank, teamName);
        System.out.println("-------------------------------");
        System.out.println(" Q1  Q2  Q3  Q4  Final");
        System.out.println(" --- --- --- --- -----");
        System.out.printf(" %-2d  %-2d  %-2d  %-2d  %d \n",q1, q2,q3,q4,finalScore);
        System.out.println();
        /* end repeatable code */

        /* Add your code here */
    }
}
