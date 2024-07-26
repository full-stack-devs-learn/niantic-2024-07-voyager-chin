package com.nianatic;

public class Exercises
{
    /*
     * 1)
     * Return an array of 7 strings with the
     * names of the days of the week
     *
     * [Sunday, Monday, Tuesday, Wednesday, Thursday, Friday, Saturday]
     */

    public String[] daysOfTheWeek()
    {
        // returns all days of the week
        return new String[] {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

    }

    /*
     * 2)
     * Return an array of 12 strings with the
     * names of the months of the year
     *
     * [January, February, March, April, May, June, July, August, September, October, November, December]
     */
    public String[] monthsOfTheYear()
    {
        // returns all months of the year
        return new String[] {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    }

    /*
     * 3)
     * Return an array of 50 numbers from 1 to 50
     * (this will be best done with a loop)
     *
     * The first number of the array must be 1
     * The last number of the array must be 50
     *
     * [1, 2, 3, ... 50]
     */
    public int[] oneToFifty()
    {
        // Creates an array that holds 50 integer
        int[] arrayOf50 = new int[50];

        // Loops to insert value on each index of the integer array
        for (int i = 1; i <= arrayOf50.length; i++)
        {
            arrayOf50[i - 1] = i;
        }

        // Returns the array of 50 integers
        return arrayOf50;
    }

    /*
     * 4)
     * Return an array of 100 that includes
     * only the even numbers from 1 to 200
     *
     * The first number of the array must be 2
     * The last number of the array must be 200
     *
     * [2, 4, 6, ... 200]
     */
    public int[] evenNumbers()
    {
        //Creates an array that can hold 100 integers.
        int[] evenArrayTo200 = new int[100];

        //Creates a variable for the starting count and to store current even values
        int even = 2;

        //Loops to insert value per index of the even array
        for (int i = 0; i < evenArrayTo200.length; i++)
        {
            evenArrayTo200[i] = even;
            even += 2; // Increments by 2 to get next even number
        }

        // Returns the array of even numbers from 2-200
        return evenArrayTo200;
    }

    /*
     * 5)
     * This function accepts an array of strings
     * that represents all of the days of the week.
     *
     * You need to return the name of the FIRST
     * day of the week.
     *
     * The week might begin with a different day.
     * I.e. the full week begins on Sunday
     *      but the work week begins on Monday
     *
     * Example Expectations:
     * Input                                                                               Output
     * firstDayOfWeek([Sunday, Monday, Tuesday, Wednesday, Thursday, Friday, Saturday]) => Sunday
     * firstDayOfWeek([Monday, Tuesday, Wednesday, Thursday, Friday])                   => Monday
     */
    public String firstDayOfWeek(String[] daysOfTheWeek)
    {
        //Access the 0 index and return the FIRST day of the week
        return daysOfTheWeek[0];
    }

    /*
     * 6)
     * This function accepts an array of strings
     * that represents all of the days of the week.
     *
     * You need to return the name of the LAST
     * day of the week.
     *
     * The week might begin with a different day.
     * I.e. the full week begins on Sunday
     *      but the work week begins on Monday
     *
     * Example Expectations:
     * Input                                                                              Output
     * lastDayOfWeek([Sunday, Monday, Tuesday, Wednesday, Thursday, Friday, Saturday]) => Saturday
     * lastDayOfWeek([Monday, Tuesday, Wednesday, Thursday, Friday])                   => Friday
     */
    public String lastDayOfWeek(String[] daysOfTheWeek)
    {
        //Returns the LAST day based on parameter
        return daysOfTheWeek[daysOfTheWeek.length - 1];
    }

    /*
     * 7)
     * This function accepts 2 input parameters.
     * 1 - an array of strings (month names)
     * 2 - the number of the month of the year
     *
     * You need to return the name of the month
     * that corresponds with the number.
     *
     * Example Expectations:
     * Input                                                                          Output
     * monthName([Jan, Feb, Mar, Apr, May, Jun, Jul, Aug, Sep, Oct, Nov, Dec], 2)  => Feb
     * monthName([Jan, Feb, Mar, Apr, May, Jun, Jul, Aug, Sep, Oct, Nov, Dec], 8)  => Aug
     */
    public String monthName(String[] months, int monthNumber)
    {
        //Access selected month based on monthNumber argument and return selected month
        return months[monthNumber - 1];
    }

    /*
     * 8)
     * This function accepts 2 input parameters.
     * 1 - an array of names
     * 2 - a name to search for in the array
     *
     * Return true if the name is in the list,
     * and false if it does not.
     *
     * The search should not be case sensitive.
     *
     * Example Expectations:
     * Input                                                      Output
     * hasName(["Ron", "Lisa", "Kent", "Michelle"], "Kent")   =>  true
     * hasName(["Ron", "Lisa", "Kent", "Michelle"], "kent")   =>  true
     * hasName(["Ron", "Lisa", "Kent", "Michelle"], "Jenny")  =>  false
     */
    public boolean hasName(String[] names, String nameToFind)
    {
        //Start variable value to false, it will remain false if name is not found
        Boolean isNameFound = false;

        //Loops through the names array to compare nameToFind arg to current index of namesArray
        for (int i = 0; i < names.length; i++) {
            if(nameToFind.equalsIgnoreCase(names[i])) //Ignores case
            {
                //If the comparison becomes true at any index, the value of foundName will be replaced to true
                isNameFound = true;
            }
        }

        //Returns value of foundName after the loop whether true or false
        return isNameFound;
    }

    /*
     * 9)
     * This function accepts 2 input parameters.
     * 1 - an array of names
     * 2 - a name to search for in the array
     *
     * Return a count of how many times the name is found in the list.
     *
     * The search should not be case sensitive.
     *
     * Example Expectations:
     * Input                                                                  Output
     * countName(["Ron", "Michelle", "Lisa", "Kent", "Michelle"], "Ron")    =>  1
     * countName(["Ron", "Michelle", "Lisa", "Kent", "Michelle"], "kent")   =>  2
     * countName(["Ron", "Michelle", "Lisa", "Kent", "Michelle"], "Jenny")  =>  0
     */
    public int countName(String[] names, String nameToFind)
    {
        //Define a variable with a starting count of zero
        int nameCount = 0;

        //Loop to compare nameToFind with each index of namesArray
        for (int i = 0; i < names.length; i++) {
            if(nameToFind.equalsIgnoreCase(names[i])) // Ignores case
            {
                nameCount++; //add 1 to nameCount whenever comparison is true
            }
        }

        //Returns total count of matching names found
        return nameCount;
    }

    /*
     * 10)
     * Given an array of integers. Add all
     * numbers in the array and return the value.
     *
     * sumNumbers([1,2,3,4])    =>  10
     * sumNumbers([1,3,5])      =>  9
     * sumNumbers([1,1,2,3])    =>  7
     */
    public int sumNumbers(int[] numbers)
    {
        //Create variable with an initial value of 0
        int sum = 0;

        //Loop to add each number in numbers array to add each value to sum
        for(int num : numbers)
        {
            sum += num;
        }

        //Returns total sum of the input of numbers
        return sum;
    }

    /*
     * 11)
     * Given an array of integers. Add all EVEN
     * numbers in the array and double it.
     *
     * Return the answer.
     *
     * doubleEvens([1,2,3,4])  => 2 + 4 => 6 * 2   =>  12
     * doubleEvens([10,11,13]) => 10 * 2           =>  20
     */
    public int doubleEvens(int[] numbers)
    {
        //Create variable with an initial value of 0
        int sum = 0;

        //Loop to add each number in numbers array but only add EVEN numbers to the sum variable
        for (int num : numbers)
        {
            if (num % 2 == 0)
            {
                sum += num;
            }
        }

        //Returns total sum of even numbers and double the value
        return sum * 2;
    }

    /*
     * 12)
     * Given an array of integers. Add the
     * value of every third number in the
     * array and return the answer.
     *
     * sumEveryThird([1,2,3,4]) => 1 + 4                =>  5
     * sumEveryThird([1,3,5])                           =>  1
     * sumEveryThird([1,1,2,3,5,8,13]) => 1 + 3 + 13    =>  17
     */
    public int sumEveryThird(int[] numbers)
    {
        //Create sum variable with starting value of zero
        int sum = 0;

        //Loop for the numbersArray that will increment by 3
        for (int i = 0; i < numbers.length; i+=3)
        {
            sum += numbers[i]; //Add every third value to the sum
        }

        return sum; // Returns total sum of every third number in the array
    }

    /*
     * 13)
     * Given an array of prices, calculate
     * the average price.
     *
     * averagePrice([12.75, 10.25, 8.44, 9.2]) => sum / 4   =>  12.66
     * averagePrice([15.25, 2.34, 3.5])        => sum / 3   =>  7.03
     */
    public double averagePrice(double[] prices)
    {
        //Create variable w/ zero initial value to store the sum
        double sum = 0;

        //Loop to prices argument and add each value to sum variable
        for (double price : prices)
        {
            sum += price;
        }

        //Get average of sum using the array length
        double average = sum / prices.length;

        //Return the average price of the arguments
        return average;
    }

    /*
     * 14)
     * Given an array of prices, return the
     * highest price.
     *
     * highestPrice([12.75, 10.25, 8.44, 9.2])   =>  12.75
     * highestPrice([15.25, 21.34, 3.5])         =>  21.34
     */
    public double highestValue(double[] prices)
    {
        //Creates variable that will store the highest value
        double highest = 0;

        //Loop for each value in the array
        for (double price : prices)
        {
            //Compare the absolute value of prices
            if (Math.abs(price) > highest)
            {
                //Current price will be stored if it is higher than the previous value of the highest variable
                highest = price;
            }
        }

        //After the loop is done, return the highest value
        return highest;
    }

    /*
     * 15)
     * Given an array of prices, return the
     * lowest price.
     *
     * lowestPrice([-15.25, 15.25, 2.34, 3.50])                        =>  2.34
     * lowestPrice([12.75, -5.5, 10.25, 18.44, 4.23, -15.55, 9.20])    =>  -15.55
     */
    public double lowestValue(double[] prices)
    {
        //Create a variable that will store the lowest value
        //Initial value can be the first index to avoid errors when value is less than 0
        double lowest = prices[0];

        //Loop for each value in the array
        for (double price : prices )
        {
            //Current price will be stored if it is lower than the previous value of the lowest variable
            if (price < lowest)
            {
                lowest = price;
            }
        }

        //Return lowest price from the arguments
        return lowest;
    }

}
