# What is a Function?

A function is a block of re-usable code. 

If you find that you are writing the same lines of code, 
you should look for a repeatable pattern and instead of 
copying and pasting that pattern over and over again, you 
can turn that code into a function.

## DRY

This is the **DRY** principle - DON'T REPEAT YOURSELF

### Example

You want to display the number of points socred in each
quarter as well as the final score of the team 
for each top 10 team game this week. You have the 
list of all teams and their scores.

In the code below, notice how lines 4 - 20 are repeated once for each team.
Usually this is done by copying those 16 lines of code and pasting
them, then changing only the values that you want to change.

(We will only include the top 5 teams here for now)

|Rank|Team|Q1|Q2|Q3|Q4|
|----|----|--|--|--|--|
|1|Georgia|12|14|6|7|
|2|Alabama|14|17|10|14|
|3|Ohio State|21|10|14|7|
|4|Michigan|10|7|0|17|
|5|Clemson|14|6|8|10|

### Instructions

The top three teams are already include.

You need to add the code to display teams 4 and 5.

Open `Functions01.java` and execute the code. Add the code to display results for teams 4 and 5.

```java
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

```

### What potential problems do you see?

There has to be a better way to make this code easier to maintain.

Thankfully there is.
