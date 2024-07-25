package com.niantic;

public class Main
{
    public static void main(String[] args)
    {
        examples();
        section01();
        section02();
        section03();
        clairesCookies();
        elliotsYardCare();
    }

    public static void examples()
    {
        // i. Create a variable that stores the name of the best
        // programming language.
        String bestLanguage;
        bestLanguage = "Java";

        System.out.println("i) Best Programming Language");
        System.out.println("language: " + bestLanguage);
        System.out.println();



        // ii. Create a variable to store the speed limit in
        // a school zone.
        int speedLimit;
        speedLimit = 20;

        System.out.println("ii) Speed Limit");
        System.out.println("speedLimit: " + speedLimit);
        System.out.println();
    }

    public static void section01()
    {
        /******************** Section 1 ********************/
        System.out.println();
        System.out.println("**********************************************");
        System.out.println("Section 1: Declaring Variables");
        System.out.println("**********************************************");
        System.out.println();
        System.out.println();



        // 1. Declare a new variable to hold your name.
        // Variable name: name
        // Data Type: string (names/words are strings)
        String name;
        name = "Gregor";

        System.out.println("1) Programmer Name");
        System.out.println("name: " + name);
        System.out.println();



        // 2. Declare a variable to hold your age.
        // Variable name: age
        // Data Type: int (age is a whole number)
        int age;
        age = 47;

        System.out.println("2) Programmer Age");
        System.out.println("age: " + age);
        System.out.println();



        // 3. Declare a variable that holds the first 5 digits of PI.
        // Variable name: pi
        // Data Type: double (pi is a number with decimal places)
        double pi = 3.14159;

        System.out.println("4) Value of PI");
        System.out.println("pi: " + pi);
        System.out.println();



        // 4. Declare a variable holds the price of
        // an adult meal at the buffet.
        // Variable name: price
        // Data Type: double (price contains a dollar and cent value)

        double price = 11.95;

        System.out.println("4) Buffet Price");
        System.out.println("price: $" + price);
        System.out.println();
    }

    public static void section02()
    {

        /******************** Section 2 ********************/
        System.out.println();
        System.out.println("**********************************************");
        System.out.println("Section 2: Selecting DataTypes");
        System.out.println("**********************************************");
        System.out.println();
        System.out.println();

        // From this point forward you will need to choose
        // the variable name for each of your variables
        // as well as the DataType that will be used for
        // each variable.



        // 5. Declare a variable to store the name of your
        // favorite super hero.

        // Hint: You cannot use the same variable name
        // as a variable that you have used before.
        String hero = "Thor";

        System.out.println("5) Favorite Super Hero:");
        System.out.println("hero: " + hero);
        System.out.println();



        // 6. Declare a variable to hold the value of
        // value of a test score. The test has 100
        // questions and each question is worth 1 point.
        // (You can choose the score)
        int testScore = 92;

        System.out.println("6) Test Score:");
        System.out.println("testScore: " + testScore);
        System.out.println();



        // 7. Declare a variable that holds the current
        // population in the United States.
        // (search what the population is today)
        int populationUS = 333132160;

        System.out.println("7) Current Population in the US");
        System.out.println("populationUS: " + populationUS);
        System.out.println();



        // 8. Declare a variable that holds the current
        // population in China.
        // (search what the population is today)
        int populationChina = 141539758;

        System.out.println("8) Current Population in China");
        System.out.println("populationChina: " + populationChina);
        System.out.println();



        // 9. Declare a variable that holds the current
        // population in the world.
        // (search what the population is today)
        long populationTotal = 7922694067l;

        System.out.println("9) Current total world population");
        System.out.println("populationTotal: " + populationTotal);
        System.out.println();



        // 10. Declare a variable that specifies whether
        // or not your mouse is wireless.
        boolean isMouseWireless = true;

        System.out.println("10) Is my mouse wireless?");
        System.out.println("isMouseWireless: " + isMouseWireless);
        System.out.println();



        // 11. Search what the Latitude and Longitude of your
        // home town are. Then declare 2 variables
        // to store the Latitude and Longitude.
        double latitudeGrantsville = 40.599941;
        double longitudeGrantsville = -112.464401;

        System.out.println("11) Lat/Lon of Grantsville");
        System.out.println("Latitude: " + latitudeGrantsville);
        System.out.println("Longitude: " + longitudeGrantsville);
        System.out.println();



        // 12. Create a variable that holds the current
        // Microsoft stock price.
        float stockPriceMicrosoft = 237.92f;

        System.out.println("12) Microsoft Current Stock Price");
        System.out.println("stockPriceMicrosoft: $" + stockPriceMicrosoft);
        System.out.println();
    }
    
    public static void section03()
    {
        /******************** Section 3 ********************/
        System.out.println();
        System.out.println("**********************************************");
        System.out.println("Section 3: Expressions and Arithmetic");
        System.out.println("**********************************************");
        System.out.println();
        System.out.println();

        /*
         * In this section you are expected to create
         * multiple variables in each exercise. You should
         * create as many variables as you need in order to
         * solve each problem.
         *
         * Make sure that your variable names are meaningful
         * and that the name describes the purpose of the
         * variable. Also, your code should not have any
         * "magic numbers" but anyone who reads the code
         * should be able to understand your code and
         * the calculations.
         */

        System.out.println("----------------------------");
        System.out.println("Backyard Basketball");
        System.out.println("-----------------------------");
        System.out.println();


        // 13. In his last basketball game Pete made 7 shots,
        // but missed 3 of his shots.

        // How many shots did Pete take?
        int madeShots = 7;
        int missedShots = 4;
        int totalShots = madeShots + missedShots;

        System.out.println("13) Total Basketball Shots");
        System.out.println("madeShots:   " + madeShots);
        System.out.println("missedShots: " + missedShots);
        System.out.println("totalShots:  " + totalShots);
        System.out.println();



        // 14. In his previous basketball game Pete took 20 shots.
        // He missed 6 shots, and he made 3 three point shots.

        // How many 2 point shots did Pete make?\
        int shotsTaken = 20;
        int missedShotsTaken = 6;
        int threePointShots = 3;
        int totalTwoPointShots = shotsTaken - missedShotsTaken - threePointShots;

        System.out.println("14) Total 2 Point Shots Taken");
        System.out.println("shotsTaken:         " + shotsTaken);
        System.out.println("missedShotsTaken:   " + missedShotsTaken);
        System.out.println("threePointShots:    " + threePointShots);
        System.out.println("totalTwoPointShots: " + totalTwoPointShots);
        System.out.println();



        // 15. Pete and Pat are teammates. Pete made 6 shots.
        // Pat made twice as many shots as Pete.

        // How many total shots did they make?
        int peteShots = 6;
        int patShots = peteShots * 2;
        int combinedShots = peteShots + patShots;

        System.out.println("15) Pet and Pat Combined Shots");
        System.out.println("peteShots:     " + peteShots);
        System.out.println("patShots:      " + patShots);
        System.out.println("combinedShots: " + combinedShots);
        System.out.println();



        // 16. Pete has made 13 shots, Pat has made 9.
        // If both Pete and Pat make 1 more shot each
        // before the game ends, how many total shots
        // did the Terrifying Twosome make in the game?
        peteShots = 13;
        patShots = 9;
        peteShots++;
        patShots++;
        combinedShots = peteShots + patShots;

        System.out.println("16) Pet and Pat Combined Shots Part 2");
        System.out.println("peteShots:     " + peteShots);
        System.out.println("patShots:      " + patShots);
        System.out.println("combinedShots: " + combinedShots);
        System.out.println();



        // 17. In his last game Pete made 11 shots.
        // he missed 4 shots.

        // What percentage of his shots did he make?
        int peteMadeShots = 11;
        int peteMissedShots = 4;
        double peteTotalShots = peteMadeShots + peteMissedShots;
        int petePercentMade = (int)((peteMadeShots / peteTotalShots) * 100);

        System.out.println("17) Pete Percent Shots Made");
        System.out.println("peteMadeShots:   " + peteMadeShots);
        System.out.println("peteMissedShots: " + peteMissedShots);
        System.out.println("peteTotalShots:  " + peteTotalShots);
        System.out.println("petePercentMade: " + petePercentMade + "%");
        System.out.println();




        // 18. Pete and Pat have decided to only take 3 point
        // shots in their next game. Together they make 70%
        // of their 3 point shots.

        // The team that they are playing scores 31 points a game.

        // How many shots do Pete and Pat have to take to win
        // this game?
        double percentMade = .7;
        int basketsNeeded = 11;
        int shotsNeeded = (int)(basketsNeeded / percentMade);

        System.out.println("18) Baskets Needed to Win");
        System.out.println("percentMade:   " + percentMade);
        System.out.println("basketsNeeded: " + basketsNeeded);
        System.out.println("shotsNeeded:   " + shotsNeeded);
        System.out.println();
    }
    
    public static void clairesCookies()
    {

        System.out.println();
        System.out.println();
        System.out.println("----------------------------");
        System.out.println("Claire's Cookies");
        System.out.println("-----------------------------");
        System.out.println();



        // 19. Claire sells cookies by the dozen. Sean has 14 students
        // in his class. He has bought 3 dozen cookies for his class.

        // Sean wants to divide the cookies evenly between
        // his students. How many cookies will each student
        // receive? (Students can only receive whole cookies)
        int dozensOfCookies = 3;
        int numberOfCookies = 12 * dozensOfCookies;
        int numberOfStudents = 14;
        int cookiesPerStudent = numberOfCookies / numberOfStudents;

        System.out.println("19) How Many Cookies Per Student");
        System.out.println("dozensOfCookies:   " + dozensOfCookies);
        System.out.println("numberOfCookies:   " + numberOfCookies);
        System.out.println("numberOfStudents:  " + numberOfStudents);
        System.out.println("cookiesPerStudent: " + cookiesPerStudent);
        System.out.println();



        // 20. Sean has 14 students in his class.
        // He has bought 3 dozen cookies for his class.

        // Sean wants to divide the cookies evenly between
        // his students. After giving the students their
        // cookies, how many cookies will be left over?
        int remainingCookies = numberOfCookies % numberOfStudents;

        System.out.println("20) Remaining Cookies");
        System.out.println("dozensOfCookies:   " + dozensOfCookies);
        System.out.println("numberOfCookies:   " + numberOfCookies);
        System.out.println("numberOfStudents:  " + numberOfStudents);
        System.out.println("remainingCookies:  " + remainingCookies);
        System.out.println();



        // 21. Sean's class has earned a cookie party.

        // If Sean has 14 students, how many dozen cookies
        // does he need to buy from Claire's Cookies so that
        // each student can receive 3 cookies.
        cookiesPerStudent = 3;
        int totalCookies = numberOfStudents * cookiesPerStudent;
        int dozensOfCookiesNeeded = (int)Math.ceil(totalCookies / 12.0);

        System.out.println("21) Dozens of Cookies Needed");
        System.out.println("cookiesPerStudent:     " + cookiesPerStudent);
        System.out.println("numberOfStudents:      " + numberOfStudents);
        System.out.println("totalCookies:          " + totalCookies);
        System.out.println("dozensOfCookiesNeeded: " + dozensOfCookiesNeeded);
        System.out.println();



        // 22. Sean's class has earned a cookie party. The number
        // of cookies that a student receives depends on
        // the score that they received on the cookie test.
        // Sean has 14 students.

        // 100 = 4 cookies
        // 90+ = 3 cookies
        // everyone else 2 cookies

        // Sean has 14 students. Chuck and Andrea scored
        // a perfect 100 on the test. Regina, Glen, Tony and Lorrie
        // all scored above 90. The rest of the class scored
        // below 90.

        // How many dozen cookies does Sean need to buy.
        int fourCookieStudents = 2;
        int threeCookieStudents = 4;
        int twoCookieStudents = numberOfStudents - fourCookieStudents - threeCookieStudents;
        int fourCookies = 4 * fourCookieStudents;
        int threeCookies = 3 * threeCookieStudents;
        int twoCookies = 2 * twoCookieStudents;
        totalCookies = fourCookies + threeCookies + twoCookies;
        dozensOfCookiesNeeded = (int)Math.ceil(totalCookies / 12.0);

        System.out.println("22) Test Cookie Party");
        System.out.println("fourCookieStudents:    " + fourCookieStudents);
        System.out.println("threeCookieStudents:   " + threeCookieStudents);
        System.out.println("twoCookieStudents:     " + twoCookieStudents);
        System.out.println("fourCookies:           " + fourCookies);
        System.out.println("threeCookies:          " + threeCookies);
        System.out.println("twoCookies:            " + twoCookies);
        System.out.println("totalCookies:          " + totalCookies);
        System.out.println("dozensOfCookiesNeeded: " + dozensOfCookiesNeeded);
        System.out.println();



        // 23. If Claire's Cookies sells each dozen cookies for 12.99,
        // how much will it cost Sean to buy 4 dozen cookies.
        double costPerDozen = 12.99;
        dozensOfCookies = 4;
        double totalCost = dozensOfCookies * costPerDozen;

        System.out.println("23) Cost For 4 Dozen Cookies");
        System.out.println("costPerDozen:    $" + costPerDozen);
        System.out.println("dozensOfCookies: " + dozensOfCookies);
        System.out.println("totalCost:       $" + totalCost);
        System.out.println();



        // (Use this information for the next several questions)
        // Claire now charges different prices for different
        // types of cookies as follows:

        // Snicker Doodles = $12.99 / dz
        // Chocolate Chip = $13.99 / dz
        // Frosted Chocolate Chip = $15.99 / dz

        // Each dozen cookies must be the same type of cookie.

        // Sean has allowed his students to choose 3
        // cookies each. Here is what they have selected

        // Snicker Doodles | Chocolate Chip | Frosted Chocolate Chip
        // ---------------------------------------------------------
        // 9                 15               18

        // 24. How many total dozen cookies does Sean need to buy?\
        int numberOfSnickerDoodles = 9;
        int numberOfChocolateChip = 15;
        int numberOfFrosted = 18;
        int dozenOfSnickerDoodles = (int)Math.ceil(numberOfSnickerDoodles / 12.0);
        int dozenOfChocolateChip = (int)Math.ceil(numberOfChocolateChip / 12.0);
        int dozenOfFrosted = (int)Math.ceil(numberOfFrosted / 12.0);
        dozensOfCookiesNeeded = dozenOfSnickerDoodles + dozenOfChocolateChip + dozenOfFrosted;

        System.out.println("24) Dozens of Varieties Needed");
        System.out.println("numberOfSnickerDoodles:   " + numberOfSnickerDoodles);
        System.out.println("numberOfChocolateChip:    " + numberOfChocolateChip);
        System.out.println("numberOfFrosted:          " + numberOfFrosted);
        System.out.println("dozenOfSnickerDoodles:    " + dozenOfSnickerDoodles);
        System.out.println("dozenOfChocolateChip:     " + dozenOfChocolateChip);
        System.out.println("dozenOfFrosted:           " + dozenOfFrosted);
        System.out.println("dozensOfCookiesNeeded:    " + dozensOfCookiesNeeded);
        System.out.println();



        // 25. What is the total cost of this order?
        double priceOfSnickerDoodles = 12.99;
        double priceOfChocolateChip = 13.99;
        double priceOfFrosted = 15.99;
        double totalPriceOfSnickerDoodles = priceOfSnickerDoodles * dozenOfSnickerDoodles;
        double totalPriceOfChocolateChip = priceOfChocolateChip * dozenOfChocolateChip;
        double totalPriceOfFrosted = priceOfFrosted * dozenOfFrosted;
        double totalCostOfCookies = totalPriceOfSnickerDoodles + totalPriceOfChocolateChip + totalPriceOfFrosted;

        System.out.println("25) Total Price of Cookies");
        System.out.println("priceOfSnickerDoodles:      $" + priceOfSnickerDoodles);
        System.out.println("priceOfChocolateChip:       $" + priceOfChocolateChip);
        System.out.println("priceOfFrosted:             $" + priceOfFrosted);
        System.out.println("totalPriceOfSnickerDoodles: $" + totalPriceOfSnickerDoodles);
        System.out.println("totalPriceOfChocolateChip:  $" + totalPriceOfChocolateChip);
        System.out.println("totalPriceOfFrosted:        $" + totalPriceOfFrosted);
        System.out.println("totalCostOfCookies:         $" + totalCostOfCookies);
        System.out.println();



        // 26. How many cookies will be left over of each type of cookie?
        // (Snicker Doodles, Chocolate Chip, Frosted Chocolate Chip)
        int totalNumberOfSnickerDoodles = dozenOfSnickerDoodles * 12;
        int totalNumberOfChocolateChip = dozenOfChocolateChip * 12;
        int totalNumberOfFrosted = dozenOfFrosted * 12;
        int remainingSnickerDoodles = totalNumberOfSnickerDoodles - numberOfSnickerDoodles;
        int remainingChocolateChip = totalNumberOfChocolateChip - numberOfChocolateChip;
        int remainingFrosted = totalNumberOfFrosted - numberOfFrosted;

        System.out.println("26) Remaining Cookies");
        System.out.println("numberOfSnickerDoodles:        " + numberOfSnickerDoodles);
        System.out.println("numberOfChocolateChip:         " + numberOfChocolateChip);
        System.out.println("numberOfFrosted:               " + numberOfFrosted);
        System.out.println("totalNumberOfSnickerDoodles:   " + totalNumberOfSnickerDoodles);
        System.out.println("totalNumberOfChocolateChip:    " + totalNumberOfChocolateChip);
        System.out.println("totalNumberOfFrosted:          " + totalNumberOfFrosted);
        System.out.println("remainingSnickerDoodles:       " + remainingSnickerDoodles);
        System.out.println("remainingChocolateChip:        " + remainingChocolateChip);
        System.out.println("remainingFrosted:              " + remainingFrosted);
        System.out.println();



        // 27. How much money could Sean have saved if he would
        // have bought: 2 dz Frosted Chocolate Chip
        //              1 dz Chocolate Chip
        //              1 dz Snicker Doodle
        double possiblePriceSnickerDoodle = 12.99;
        double possiblePriceChocolateChip = 13.99;
        double possiblePriceFrosted = 15.99 * 2;
        double possibleTotalPrice = possiblePriceSnickerDoodle + possiblePriceChocolateChip + possiblePriceFrosted;
        double possibleSavings = totalCostOfCookies - possibleTotalPrice;

        System.out.println("27) Possible Savings");
        System.out.println("totalCostOfCookies: $" + totalCostOfCookies);
        System.out.println("possibleTotalPrice: $" + possibleTotalPrice);
        System.out.println("possibleSavings:    $" + possibleSavings);
        System.out.println();
    }


    // bonus - challenge
    public static void elliotsYardCare()
    {

        System.out.println();
        System.out.println();
        System.out.println("----------------------------");
        System.out.println("Elliot's Yard Care");
        System.out.println("----------------------------");
        System.out.println();

        // Use the following information to answer the remaining questions.

        // Elliot runs a yard care business named "Elliot's Yard Care".
        // He charges $30 to mow and trim a medium size lawn (100 ft x 50 ft).
        // Elliot takes pride in his work and his lawns look
        // immaculate. In order to maintain such a quality reputation
        // his services include grass clipping removal and
        // complete sweeping of the property after the lawn
        // is mowed.

        // Elliot's goal is to earn at least $10 per hour.
        // It costs him about $2.50 in materials and gas per 1000 sq ft.
        // On average elliot has calculated that it takes him roughly
        // 45 minutes to fully maintain 1000 sq ft.


        // 28. What is the total cost to Elliot when
        // he mows a yard that is 100 x 50 feet?
        double costPerThousand = 2.5;
        int yardWidth = 100;
        int yardLength = 50;

        double yardArea = yardWidth * yardLength;
        double yardCost = (yardArea / 1000) * costPerThousand;

        System.out.println("28) Material Cost for yard");
        System.out.println("yardWidth:  " + yardWidth);
        System.out.println("yardLength: " + yardLength);
        System.out.println("yardArea:   " + yardArea);
        System.out.println("yardCost:   $" + yardCost);
        System.out.println();



        // 29. How much total money does Elliot earn
        // to maintain a 100 x 50 ft yard?
        double yardFee = 30;
        double incomePerYard = yardFee - yardCost;

        System.out.println("29) Income Per Yard");
        System.out.println("yardArea:        " + yardArea);
        System.out.println("incomePerYard:   $" + incomePerYard);
        System.out.println();



        // 30. How much time does it take Elliot to mow
        // a 100 x 50 ft yard?
        double timePerThousand = .75;
        double timePerYard = yardArea / 1000 * timePerThousand;

        System.out.println("30) Time Per Yard");
        System.out.println("yardArea:      " + yardArea);
        System.out.println("timePerYard:   " + timePerYard);
        System.out.println();



        // 31. How much money does Elliot earn per hour
        // on a 100 x 50 foot yard?
        double incomePerHour = incomePerYard / timePerYard;

        System.out.println("31) Income Per Yard");
        System.out.println("yardArea:        " + yardArea);
        System.out.println("timePerYard:     " + timePerYard);
        System.out.println("incomePerYard:   $" + incomePerYard);
        System.out.println("incomePerHour:   $" + incomePerHour);
        System.out.println();



        // 32. What is Elliot's cost per hour on a medium
        // sized yard?
        double costPerHour = yardCost / timePerYard;

        System.out.println("32) Cost Per Hour");
        System.out.println("costPerHour: $" + costPerHour);
        System.out.println();



        // 33. How much money should Elliot charge for a medium yard
        // in order to earn $10 per hour?
        double desiredIncomePerHour = 10;
        double suggestedPricePerHour = desiredIncomePerHour + costPerHour;
        double suggestedPrice = suggestedPricePerHour * timePerYard;

        System.out.println("33) Suggested Price");
        System.out.println("desiredIncomePerHour:  $" + desiredIncomePerHour);
        System.out.println("suggestedPricePerHour: $" + suggestedPricePerHour);
        System.out.println("suggestedPrice:        $" + suggestedPrice);


    }
}