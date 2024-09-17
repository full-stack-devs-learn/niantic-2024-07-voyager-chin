# FileIO Writing to Files

In this exercise, you will write student reports to text files. You will also create a LogService file which will allow you to log errors and application events

## Learning objectives

After completing this exercise, you'll understand how to:

* Open a file stream to write to text files

## Evaluation criteria and functional requirements

* The project must compile (it cannot have any build errors).
* The application must create files with the correct names 
* The applciation must write the correct information to the files.

## Getting started

1. Continue working on the `exercise_file-io-exceptions` project in IntelliJ.


# Exercises

## 1: Create a Student Summary Report

Your first task is to create a student summary report. You should allow a user to select
a students assignment file, then create a summary report.

* Add a new menu item to the user interface "Create Student Summary Report"
* Allow the user to select a file name
* Create a new text file for the report
  * The file should be created in the `reports` folder
  * The file name should should have the current date followed by the student name `2024-09-16_david_jones.txt`

Minimally the file should have the following information
```
david jones
----------------------------------------
Low Score                          83
High Score                         100
Average Score                      90  

```

**Challenge (optional)** - the file should contain the names of the assignments for the
scores. For the average, include any assignment within a -1 to +1 range of the average score
```
david jones
----------------------------------------

----------------------------------------
Low Score                          83
----------------------------------------
15  Math Review                    83   

----------------------------------------
High Score                         100
----------------------------------------
3   Multiplication Practice        100  

----------------------------------------
Average Score                      90
----------------------------------------
4   Division Practice              91   
8   Basic Algebra                  90   
12  Probability                    91   

```

## 2: Create an All Students Report

* Add a new menu item to the user interface "Create All Students Report"
* Load all assignments into memory
* Create a new text file for the report
  * The file should be created in the `reports` folder
  * The file name should should have the current date followed by the student name `2024-09-16_all_students.txt`

```
All Assignments
------------------------------------------------------------
Total Students                                         5
Total Assignments                                      15
------------------------------------------------------------
Low Score                                               80
High Score                                              100
Average Score                                           89 
------------------------------------------------------------
```

**Challenge (optional)** include the names of the assignment and student with the
low, high and average scores. For average scores, include all 
assignments within a -1 to +1 range of the average score
```
All Assignments
------------------------------------------------------------
Total Students                                         5
Total Assignments                                      15

------------------------------------------------------------
Low Score                                               80
------------------------------------------------------------
2   Subtraction Practice           joshua martin        80   

------------------------------------------------------------
High Score                                              100
------------------------------------------------------------
3   Multiplication Practice        david jones          100  
14  Money Problems                 laura brown          100  
8   Basic Algebra                  joshua martin        100  
10  Statistics Introduction        joshua martin        100  

------------------------------------------------------------
Average Score                                           89
------------------------------------------------------------
2   Subtraction Practice           anna williams        90   
3   Multiplication Practice        anna williams        88   
7   Word Problems                  anna williams        89   
11  Graphing                       anna williams        88   
12  Probability                    anna williams        90   
1   Addition Practice              david jones          88   
5   Fractions                      david jones          88   
6   Decimals                       david jones          88   
8   Basic Algebra                  david jones          90   
2   Subtraction Practice           laura brown          88   
2   Subtraction Practice           eric walker          88   
6   Decimals                       eric walker          88   
7   Word Problems                  eric walker          88   
10  Statistics Introduction        eric walker          90  
```



# Exercises - Optional / Challenge

## 3a: Create a LogService

* Create a new `LogService` class in the `services` package
* The constructor should include the name of the type of service `error` or `application`
  * `error` logs should be created in the `error` folder
  * `application` logs should be created in the `application` folder
* Ensure that the `error` and `application` folders exist (do this in code)
* A new log file should be created for each day with the date as the name - `2024-09-06.log`
* Each log entry should include the date the time and the message
  * `2024-09-16 09:13:24 some error message`

## 3b: Log Error Messages

* Throughout your application, wherever you use a try catch block use the 
  catch block to log the error message to the `error` log
  * `errorLogger.logMessage(e.getMessage());`

## 3c: Log Application Messages

In the main application file, create an instance of the LogService as an `applicationLogger`

* Log every selection made by the user
  * I.e. if the user selects option 1, log a message similar to "Display List of Files"




