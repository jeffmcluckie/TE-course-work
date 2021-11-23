package com.techelevator;

public class Vampire extends HalloweenMonster {

    // The two constructors here show overloading (no inheritance needed for overloading)
    // same method (in this case the constructor) BUT takes in different arguments
    public Vampire(String monsterName, String realName, int age){
        super(monsterName, realName, age);
    }

    public Vampire(String realName, int age) {
        // default the monster name for all Vampire instances to "vampire"
        super("vampire", realName, age);
    }

    @Override
    public String getScarySound() {
        return "whaaaaaah...";
    }

    public int drinkBlood() {
        // Might be cool later if this is based on something
        // but for now just 5
        return 5;
    }

    // Fulfill the Tricky interface requirements
    @Override
    public String doTrick() {
        drinkBlood();
        return "Drank your blood...";
    }
//
//    @Override
//    public String toString() {
//        return String.format("Vampire{ realName:%s, age:%d, scarinessRating:%d}",
//                this.getRealName(), this.getAge(), this.getScarinessRating());
//    }
}
