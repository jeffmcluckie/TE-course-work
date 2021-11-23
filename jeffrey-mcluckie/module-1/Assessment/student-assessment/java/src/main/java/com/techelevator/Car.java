package com.techelevator;

public class Car {
    private int year;
    private String make;
    private boolean isClassicCar;
    private int age;

    public Car(int year, String make, boolean isClassicCar) {
        this.year = year;
        this.make = make;
        this.isClassicCar = isClassicCar;
    }

    public int getYear() {
        return year;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Car() {
    }

    public int ageCheck(){
        age = 2021 - year;
        return age;
    }

    public boolean mustReceiveCheck(int yearToCheck){

        if(getAge() < 4){
            return false;
        }
        else if(age > 25 || isClassicCar){
            return false;
        }
        else if(yearToCheck % 2 == 0 && year % 2 == 0){
            return true;
        }
        else if(yearToCheck % 2 == 0 && year % 2 == 1){
            return false;
        }
        else if (yearToCheck % 2 == 1 && year % 2 == 0){
            return false;
        }
        else return true;
    }

    @Override
    public String toString() {
        return "Car - " +
                "{" + year + "} - " +
                "{" + make +
                '}';
    }
}
