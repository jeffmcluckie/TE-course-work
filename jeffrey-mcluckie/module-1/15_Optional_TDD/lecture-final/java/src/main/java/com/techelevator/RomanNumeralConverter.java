package com.techelevator;

import java.util.HashMap;
import java.util.Map;

public class RomanNumeralConverter {

    private static String[] onesDigit = {"I","II","III","IV","V","VI","VII","VIII","IX"};
    private static Map<Integer,String> romanNumeralLetters = new HashMap<>();

    public static void fillMap(){
        romanNumeralLetters.put(1,"I");
        romanNumeralLetters.put(5,"V");
        romanNumeralLetters.put(10,"X");
    }

    public static String convertIntToRomanNumeral(int num){
        fillMap();
        //make num into an integer array and split by digit
        String result = "";
        //String strNum = ""+num;
        //String[] arrayOfDigits = strNum.split(".");  // 1 0  //100 1 0 0
        if (num>=50){
            result += "L";
            num -= 50;
        }
        if (num>=40){
            result += "XL";
            num -= 40;
        }
        while (num >= 10){
            result += "X";
            num -= 10;
        }
        //handle 1-9
        switch (num){
            case 1: result+="I";break;
            case 2: result+="II"; break;
            case 3: result+="III";break;
            case 4: result+="IV"; break;
            case 5: result+="V";break;
            case 6: result+="VI"; break;
            case 7: result+="VII";break;
            case 8: result+="VIII"; break;
            case 9: result+="IX"; break;
        }

        return  result;

    }

}
