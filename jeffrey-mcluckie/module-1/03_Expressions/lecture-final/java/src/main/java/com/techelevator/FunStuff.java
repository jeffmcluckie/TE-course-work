package com.techelevator;

public class FunStuff {
    public static void main(String[] args) {
        boolean isRainy = true;
        boolean isWeekday = true;

        if (isRainy) {
            System.out.println("It's rainy");
<<<<<<< HEAD
        }
        if (isWeekday) {
            System.out.println("It's a weekday");
        }
        else {
            System.out.println("It's a weekend");
        }
=======
            int weatherRating = 1;
            System.out.println("Weather rating is:" + weatherRating);
        }
        
        // weather rating is no longer in scope/doesn't exist
        //System.out.println("Weather rating is:" + weatherRating);

        if (isWeekday) {
            System.out.println("It's a weekday");
        } else {
            System.out.println("It's a weekend!");
        }

>>>>>>> 2fbda4903b3895c91ca01ea893de928ddaf4a326
    }
}
