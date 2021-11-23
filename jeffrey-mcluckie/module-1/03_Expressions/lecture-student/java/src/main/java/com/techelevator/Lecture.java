package com.techelevator;

public class Lecture {
    /*
    1. This method is named returnNotOne and it returns an int. Change
    it so that it returns something other than a 1.
    */
    public int returnNotOne() {
<<<<<<< HEAD
<<<<<<< HEAD

        return 0;
=======
        return 10;
>>>>>>> 2fbda4903b3895c91ca01ea893de928ddaf4a326
=======
        return 1;
>>>>>>> 98cb075e13f9fad5bf046ca858fb55418bcfde94
    }

    /*
    2. This method is named returnNotHalf and it returns a double. Change
    it so that it returns something other than a 0.5.
    */
    public double returnNotHalf() {
        return 0.5;
    }

    /*
    3. This method needs to return a String. Fix it to return a valid String.
    */
    public String returnName() {
<<<<<<< HEAD
<<<<<<< HEAD
        return "String";
=======
        return "Hello";
>>>>>>> 2fbda4903b3895c91ca01ea893de928ddaf4a326
=======
        return null;
>>>>>>> 98cb075e13f9fad5bf046ca858fb55418bcfde94
    }

    /*
    4. This method currently returns an int. Change it so that it returns a double.
    */
<<<<<<< HEAD
    public double returnDoubleOfTwo() {
<<<<<<< HEAD
        return 2.0;
=======
=======
    public int returnDoubleOfTwo() {
>>>>>>> 98cb075e13f9fad5bf046ca858fb55418bcfde94
        return 2;
>>>>>>> 2fbda4903b3895c91ca01ea893de928ddaf4a326
    }

    /*
    5. This method should return the language that you're learning. Change
    it so that it does that.
    */
    public boolean returnNameOfLanguage() {
        return false;
    }

    /*
    6. This method uses an if statement to define what to return. Have it
    return true if the if statement passes.
    */
    public boolean returnTrueFromIf() {
        if (true) {
            return false;
        }

        return false;
    }

    /*
    7. This method uses an if to check to make sure that one is equal
    to one. Make sure it returns true when one equals one.
    */
    public boolean returnTrueWhenOneEqualsOne() {
        if (1 == 1) {
            return false;
        }

        return false;
    }

    /*
    8. This method checks a parameter passed to the method to see if it's
    greater than 5 and returns true if it is.
    */
    public boolean returnTrueWhenGreaterThanFive(int number) {
        if (number > 5) {

        } else {

        }
<<<<<<< HEAD
<<<<<<< HEAD

=======
        //return false;
>>>>>>> 2fbda4903b3895c91ca01ea893de928ddaf4a326
=======
        return false;
>>>>>>> 98cb075e13f9fad5bf046ca858fb55418bcfde94
    }

    /*
    9. If you think about it, we really don't need the if statement above.
    How can we rewrite exercise 8 to have only one line of code?
    */
    public boolean returnTrueWhenGreaterThanFiveInOneLine(int number) {
<<<<<<< HEAD
<<<<<<< HEAD
        return (number > 5) ? true : false; // What can we put here that returns a boolean that we want?
=======
        // What can we put here that returns a boolean that we want?
        //return ( number>5 ) ? true : false;
        return number>5 ; // even better!!!
>>>>>>> 2fbda4903b3895c91ca01ea893de928ddaf4a326
=======
        return false; // What can we put here that returns a boolean that we want?
>>>>>>> 98cb075e13f9fad5bf046ca858fb55418bcfde94
    }

    /*
    10. This method will take a number and do the following things to it:
    * If addThree is true, we'll add three to that number
    * If addFive is true, we'll add five to that number
    * We'll then return the result
    */
    public int returnNumberAfterAddThreeAndAddFive(int number, boolean addThree, boolean addFive) {
        if (addThree) {
<<<<<<< HEAD
            number = number + 3;
<<<<<<< HEAD
=======
            //number += 3  // same thing
            // Don't want to return here, cuz both could be true.
>>>>>>> 2fbda4903b3895c91ca01ea893de928ddaf4a326
=======
            number = number + 1;
>>>>>>> 98cb075e13f9fad5bf046ca858fb55418bcfde94
        }

        // We can't use an else here. They could both be true, so we have to check each one.

        if (addFive) {
            number += 1;
        }

        return number;
    }

    /*
    11. Write an if statement that returns "Fizz" if the parameter is 3 and returns an empty String for anything else.
    */
    public String returnFizzIfThree(int number) {
        return "";
    }
    /*
    12. Now write the above using the Ternary operator ?:. If you're not sure what this is, you can Google it.
    */
    public String returnFizzIfThreeUsingTernary(int number) {
        return "";
    }

    /*
    13. Write an if/else statement that returns "Fizz" if the parameter is 3, "Buzz" if the parameter is 5 and an empty String for anything else.
    */
    public String returnFizzOrBuzzOrNothing(int number) {
<<<<<<< HEAD
<<<<<<< HEAD
        if (number ==3) {
            return "Fizz";
        }
        if (number == 5) {
            return "Buzz";
        }
        return "";
=======
        if (number == 3){
            return "Fizz";
        } else if (number == 5) {
            return "Buzz";
        } else {
            return "";
        }
//        if (number == 3){
//            return "Fizz";
//        }
//        if (number == 5) {
//            return "Buzz";
//        }
//        return "";
>>>>>>> 2fbda4903b3895c91ca01ea893de928ddaf4a326
=======
        return "";
>>>>>>> 98cb075e13f9fad5bf046ca858fb55418bcfde94
    }

    /*
    14. Write an if statement that checks if the parameter number is either equal to or greater than 18. Return "Adult" if it is or "Minor" if it's not.
    */
    public String returnAdultOrMinor(int number) {
        if (true) {
            return "Adult";
        } else {
            return "Minor";
        }
    }

    /*
    15. Now, do it again with a different boolean opeation.
    */
    public String returnAdultOrMinorAgain(int number) {
<<<<<<< HEAD
<<<<<<< HEAD
        if (number < 18) {
=======
        if (18 <= number) {
=======
        if (true) {
>>>>>>> 98cb075e13f9fad5bf046ca858fb55418bcfde94
            return "Adult";
        } else {
>>>>>>> 2fbda4903b3895c91ca01ea893de928ddaf4a326
            return "Minor";
        } else {
            return "Adult";
        }
    }

    /*
    16. Return as above, but also return "Teen" if the number is between 13 and 17 inclusive.
    */
    public String returnAdultOrMinorOrTeen(int number) {
<<<<<<< HEAD
<<<<<<< HEAD
        if (number >=18) {
            return "Adult";
        } else if (number > 12 && number < 18) {
=======
        if (number >= 18) {
            return "Adult";
        } else if (number>=13 && number<=17) {
>>>>>>> 2fbda4903b3895c91ca01ea893de928ddaf4a326
=======
        if (true) {
            return "Adult";
        } else if (true) {
>>>>>>> 98cb075e13f9fad5bf046ca858fb55418bcfde94
            return "Teen";
        } else {
            return "Minor";
        }
    }

}