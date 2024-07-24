package com.niantic;

public class Functions02Solution
{
    public static void main(String[] args)
    {
        // add your code here
        displayTeamScores(1, "Georgia", 12, 14, 6, 7);
        displayTeamScores(2, "Alabama", 14, 17, 10, 14);
        displayTeamScores(3, "Ohio State", 21, 17, 10, 14);
        displayTeamScores(4, "Michigan", 10, 7, 0, 17);
        displayTeamScores(5, "Clemson", 14, 6, 8, 10);
    }
    
    public static void displayTeamScores(int rank, String teamName, int q1, int q2, int q3, int q4)
    {
        int finalScore = q1 + q2 + q3 + q4;

        System.out.printf("(%d) %s \n", rank, teamName);
        System.out.println("-------------------------------");
        System.out.println(" Q1  Q2  Q3  Q4  Final");
        System.out.println(" --- --- --- --- -----");
        System.out.printf(" %-2d  %-2d  %-2d  %-2d  %d \n",q1, q2,q3,q4,finalScore);
        System.out.println();
    }
}
