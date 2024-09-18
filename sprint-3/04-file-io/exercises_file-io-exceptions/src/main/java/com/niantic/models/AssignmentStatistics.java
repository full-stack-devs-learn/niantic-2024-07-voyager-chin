package com.niantic.models;
import java.util.ArrayList;
import java.util.List;

public class AssignmentStatistics
{
    private List<Assignment> assignments;
    private List<String> students;

    public AssignmentStatistics(List<Assignment> assignments) {
        this.assignments = assignments;
    }

    public List<Assignment> getAssignments() {
        return assignments;
    }

    public int getLowScore()
    {
        int lowScore = assignments.stream().mapToInt(Assignment::getScore).min().orElse(-1);
        return lowScore;
    }

    public int getHighScore()
    {
        int highScore = assignments.stream().mapToInt(Assignment::getScore).max().orElse(-1);
        return highScore;
    }

    public int getAverageScore()
    {
        int avgScore = (int) assignments.stream().mapToInt(Assignment::getScore).average().orElse(-1);
        return avgScore;
    }

    public List<Assignment> getLowScoreAssignments()
    {
        List<Assignment> lowScores = new ArrayList<>();

        for(Assignment assignment: assignments)
        {
            if(assignment.getScore() == getLowScore())
            {
                lowScores.add(assignment);
            }
        }
        return lowScores;
    }

    public List<Assignment> getHighScoreAssignments()
    {
        List<Assignment> highScores = new ArrayList<>();

        for(Assignment assignment: assignments)
        {
            if(assignment.getScore() == getHighScore())
            {
                highScores.add(assignment);
            }
        }
        return highScores;
    }

    public List<Assignment> getAverageAssignments()
    {
        List<Assignment> averageScores = new ArrayList<>();
        int averageScore = getAverageScore();

        for(Assignment a: assignments)
        {
            if(a.getScore() >= averageScore - 1 && a.getScore() <= averageScore + 1)
            {
                averageScores.add(a);
            }
        }
        return averageScores;
    }

    public int getAssignmentCount()
    {
        int count = 0;

        for(Assignment assignment: assignments)
        {
            if(count < assignment.getNumber())
            {
                count = assignment.getNumber();
            }
        }
        return count;
    }
}
