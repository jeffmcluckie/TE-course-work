package com.company;

public class Main {

    public static void main(String[] args) {

        String hi = "Hello, my name is ";
        String word = "";
        String l = "L";
        String i = "i";
        String z = "z";

        while(word.length() < 7){
            if(word.length() == 0){
                word += l;
            }
            else if(word.length() < 5){
                word += i;
            }
            else word += z;
                }
        System.out.println(hi + word);
            }
        }
