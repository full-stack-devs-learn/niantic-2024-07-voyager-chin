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
        String name = "Chin Antalan";
        System.out.println("Name: " + name);



        // 2. Declare a variable to hold your age.
        // Variable name: age
        // Data Type: int (age is a whole number)
        int age = 33;
        System.out.println("Age: " + age);



        // 3. Declare a variable that holds the first 5 digits of PI.
        // Variable name: pi
        // Data Type: double (pi is a number with decimal places)
        double pi = 3.1415;
        System.out.println("Pi value is: " + pi);



        // 4. Declare a variable holds the price of
        // an adult meal at the buffet.
        // Variable name: price
        // Data Type: double (price contains a dollar and cent value)
        double price = 19.99;
        System.out.println("The price per adult at the buffet is: $" + price);
        // NOTE: the decimal data type  is not automatically recognized
        // see lecture notes
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
        String favoriteSuperHero = "Deadpool";
        System.out.println("My favorite super hero is: " + favoriteSuperHero);

        // Hint: You cannot use the same variable name
        // as a variable that you have used before.



        // 6. Declare a variable to hold the value of
        // value of a test score. The test has 100
        // questions and each question is worth 1 point.
        // (You can choose the score)
        byte testScore = 85;
        System.out.println("The test score is: " + testScore);



        // 7. Declare a variable that holds the current
        // population in the United States.
        // (search what the population is today)
        int currentPopulationUS = 336799535;
        System.out.println("The current United States  is around: " + currentPopulationUS);


        // 8. Declare a variable that holds the current
        // population in China.
        // (search what the population is today)
        int currentPopulationChina = 1412175000;
        System.out.println("The current China population is around: " + currentPopulationChina);



        // 9. Declare a variable that holds the current
        // population in the world.
        // (search what the population is today)
        long currentPopulationWorld = 8061927100L;
        System.out.println("The current world population is around: " + currentPopulationWorld);



        // 10. Declare a variable that specifies whether
        // or not your mouse is wireless.
        boolean isMouseWireless = true;
        System.out.println("Is my mouse wireless? " + isMouseWireless);



        // 11. Search what the Latitude and Longitude of your
        // home town are. Then declare 2 variables
        // to store the Latitude and Longitude.
        double latitudeSF = 37.773972;
        double longitudeSF = 122.431297;
        System.out.println("The Latitude of my home town in San Francisco is " + latitudeSF + " and the Longitude is " + longitudeSF);




        // 12. Create a variable that holds the current
        // Microsoft stock price.
        float stockPriceMicrosoft = 444.85F;
        System.out.println("The current Microsoft stock price is $" + stockPriceMicrosoft);
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

        // PETE Previous GameStatistics
        byte shotsMadePete = 7;
        byte shotsMissedPete = 3;


        // How many shots did Pete take?
        System.out.println("Shots taken by Pete: " + shotsMadePete);



        // 14. In his previous basketball game Pete took 20 shots.
        // He missed 6 shots, and he made 3 three point shots.
        shotsMadePete = 20;
        shotsMissedPete = 6;
        byte shots3PointsPete = 3;

        // How many 2 point shots did Pete make?\
        int shots2PointsPete = shotsMadePete - shotsMissedPete - shots3PointsPete;
        System.out.println("Pete's number of 2 point shots: " + shots2PointsPete);



        // 15. Pete and Pat are teammates. Pete made 6 shots.
        // Pat made twice as many shots as Pete.
        shotsMadePete = 6;
        int shotsMadePat = shotsMadePete * 2;

        // How many total shots did they make?
        System.out.println("Total shots that Pete and Pat made: " + (shotsMadePete + shotsMadePat));



        // 16. Pete has made 13 shots, Pat has made 9.
        // If both Pete and Pat make 1 more shot each
        // before the game ends, how many total shots
        // did the Terrifying Twosome make in the game?
        shotsMadePete = 13;
        shotsMadePat = 9;

        //If both Pete and Pat make 1 more shot each before the game ends
        shotsMadePete++;
        shotsMadePat++;

        System.out.println("If Pete and Pat make 1 more shot each before the game ends, they Terrifying Twosome will have the total shots of " + (shotsMadePete + shotsMadePat));


        // 17. In his last game Pete made 11 shots.
        // he missed 4 shots.
        shotsMadePete = 11;
        shotsMissedPete = 4;

        // What percentage of his shots did he make?

        float shotsMadePercentagePete = ((float) shotsMadePete / (shotsMadePete + shotsMissedPete)) * 100;
        System.out.println("Percentage of shots Pete made: " + shotsMadePercentagePete + "%");




        // 18. Pete and Pat have decided to only take 3 point
        // shots in their next game. Together they make 70%
        // of their 3 point shots.

        // The team that they are playing scores 31 points a game.

        // How many shots do Pete and Pat have to take to win
        // this game?

        double percentage3PointShots = .70F;
        double opponentPointsPerGame = 31F;
        double targetPointsPerShot = 3F;
        double goal3PointShotsToWin = Math.ceil(opponentPointsPerGame / targetPointsPerShot);
        double rawTotalShotsToWin = Math.ceil(goal3PointShotsToWin / percentage3PointShots);
        int totalShotsToWin;
        totalShotsToWin = (int) rawTotalShotsToWin;
        System.out.println("To win this game, Pete and Pat need to do at least " + totalShotsToWin + " shots.");

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

        int dozenCookies = 12;
        int noOfStudents = 14;
        int dozenCookiesBought = 3;
        int totalCookiesBought = dozenCookiesBought * dozenCookies;

        // Sean wants to divide the cookies evenly between
        // his students. How many cookies will each student
        // receive? (Students can only receive whole cookies)

        double rawCookiesPerStudent = Math.floor(totalCookiesBought / noOfStudents);
        int cookiesPerStudent = (int) rawCookiesPerStudent;

        System.out.println("Each student of Sean will receive " + cookiesPerStudent + " cookies.");



        // 20. Sean has 14 students in his class.
        // He has bought 3 dozen cookies for his class.

        // Sean wants to divide the cookies evenly between
        // his students. After giving the students their
        // cookies, how many cookies will be left over?
        int remainingCookies = totalCookiesBought % noOfStudents;

        System.out.println("Sean will have " + remainingCookies + " left over cookies.");


        // 21. Sean's class has earned a cookie party.

        // If Sean has 14 students, how many dozen cookies
        // does he need to buy from Claire's Cookies so that
        // each student can receive 3 cookies.
        int targetCookiePerStudent = 3;
        double rawCookieDozenNeeded = Math.floor(noOfStudents * targetCookiePerStudent / dozenCookies);
        int cookieDozenNeeded = (int) rawCookieDozenNeeded;

        System.out.println("Sean needs to buy " + cookieDozenNeeded + " dozens of cookies from Claire so each student can receive " + targetCookiePerStudent + " cookies.");




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
        String[] studentsWithScore100 = { "Chuck", "Andrea" };
        String[] studentsWithScore90 = { "Regina", "Glen", "Tony", "Lorrie"}; // students who scored about 90-99

        int studentCountScore100 = studentsWithScore100.length;
        int studentCountScore90 = studentsWithScore90.length;
        int studentCountBelow90 = noOfStudents - studentCountScore100 - studentCountScore90;

        int cookiesFor100 = 4;
        int cookiesFor90 = 3;
        int cookiesForBelow90 = 2;



        // How many dozen cookies does Sean need to buy.
        cookieDozenNeeded = (
                studentCountScore100 * cookiesFor100 + studentCountScore90 * cookiesFor90 + studentCountBelow90 * cookiesForBelow90
                ) / dozenCookies; // Total # of cookies divided by 12

        System.out.println("Sean needs to buy " + cookieDozenNeeded + " dozens of cookies for the cookie party!");



        // 23. If Claire's Cookies sells each dozen cookies for 12.99,
        // how much will it cost Sean to buy 4 dozen cookies.

        float costPerDozen = 12.99F;
        cookieDozenNeeded = 4;
        float totalCookieCost = (float) costPerDozen * cookieDozenNeeded;

        System.out.println("If Claire's cookie costs $12.99 per dozen, it will cost Sean $" + totalCookieCost + " to buy " + cookieDozenNeeded + " dozen of cookies.");



        // (Use this information for the next several questions)
        // Claire now charges different prices for different
        // types of cookies as follows:

        // Snicker Doodles = $12.99 / dz
        // Chocolate Chip = $13.99 / dz
        // Frosted Chocolate Chip = $15.99 / dz

        double snickerDoodlesPrice = 12.99;
        double chocolateChipPrice = 13.99;
        double frostedChocolateChipPrice = 15.99;

        // Each dozen cookies must be the same type of cookie.

        // Sean has allowed his students to choose 3
        // cookies each. Here is what they have selected

        // Snicker Doodles | Chocolate Chip | Frosted Chocolate Chip
        // ---------------------------------------------------------
        // 9                 15               18

        int snickerDoodlesNeeded = 9;
        int chocolateChipNeeded = 15;
        int frostedChocolateChipNeeded = 18;

        // 24. How many total dozen cookies does Sean need to buy?
        // Each order = 1 dozen cookies
        double snickerDoodlesOrder = Math.ceil((double) snickerDoodlesNeeded / dozenCookies);
        double chocolateChipOrder = Math.ceil((double) chocolateChipNeeded / dozenCookies);
        double frostedChocolateChipOrder = Math.ceil((double) frostedChocolateChipNeeded / dozenCookies);

        System.out.println("Sean needs to buy " + (int) snickerDoodlesOrder + " dozen of Snicker Doodles, " + (int) chocolateChipOrder + " dozen of Chocolate Chip, and " + (int) frostedChocolateChipOrder + " dozen of Frosted Chocolate Chip cookies.");



        // 25. What is the total cost of this order?
        double totalSnickerDoodlesCost = snickerDoodlesOrder * snickerDoodlesPrice;
        double totalChocolateChipCost = chocolateChipOrder * chocolateChipPrice;
        double totalFrostedChocolateChipCost = frostedChocolateChipOrder * frostedChocolateChipPrice;
        double totalOrderCost = totalSnickerDoodlesCost + totalChocolateChipCost + totalFrostedChocolateChipCost;


        System.out.println("The total order cost for the different types of cookies is $" + totalOrderCost + ".");



        // 26. How many cookies will be left over of each type of cookie?
        // (Snicker Doodles, Chocolate Chip, Frosted Chocolate Chip)
        int snickerDoodlesLeft = (int) snickerDoodlesOrder * dozenCookies - snickerDoodlesNeeded;
        int chocolateChipLeft = (int) chocolateChipOrder * dozenCookies - chocolateChipNeeded;
        int frostedChocolateChipLeft = (int) frostedChocolateChipOrder * dozenCookies - frostedChocolateChipNeeded;

        System.out.println("There will be " + snickerDoodlesLeft + " Snicker Doodles left, " + chocolateChipLeft + " Chocolate Chip left, and " + frostedChocolateChipLeft + " Frosted Chocolate Chip cookies left.");



        // 27. How much money could Sean have saved if he would
        // have bought: 2 dz Frosted Chocolate Chip
        //              1 dz Chocolate Chip
        //              1 dz Snicker Doodle
        frostedChocolateChipOrder = 2;
        chocolateChipOrder = 1;
        snickerDoodlesOrder = 1;

        double changeOrderSavings = totalOrderCost - (frostedChocolateChipOrder * frostedChocolateChipPrice + chocolateChipOrder * chocolateChipPrice + snickerDoodlesOrder * snickerDoodlesPrice);

        System.out.println("If Sean would have bought 2dz Frosted Chocolate Chip, 1 dz Chocolate Chip, and 1 dz Snicker Doodle, he could save $" + Math.round(changeOrderSavings) + ".");


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



        // 29. How much total money does Elliot earn
        // to maintain a 100 x 50 ft yard?



        // 30. How much time does it take Elliot to mow
        // a 100 x 50 ft yard?



        // 31. How much money does Elliot earn per hour
        // on a 100 x 50 foot yard?



        // 32. What is Elliot's cost per hour on a medium
        // sized yard?



        // 33. How much money should Elliot charge for a medium yard
        // in order to earn $10 per hour?


    }
}